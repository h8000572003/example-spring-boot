import React, { useEffect, useRef, useState } from 'react';
import Button from '@mui/material/Button';
import { Box, Container } from '@mui/material';
import { green } from '@mui/material/colors';
import CircularProgress from '@mui/material/CircularProgress';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import { VolumeDown, VolumeUp } from '@mui/icons-material';
const App: React.FC = () => {
    const peerConnectionRef = useRef<RTCPeerConnection | null>(null);
    const dataChannelRef = useRef<RTCDataChannel | null>(null);
    // const inputRef = useRef<HTMLInputElement>(null);
    const wsRef = useRef<WebSocket | null>(null);
    const [count, setCount] = useState<number>(0);
    const [isConnect, setIsConnect] = useState<boolean>(false);
    const [p2pOk, setP2pOk] = useState<boolean>(false);
    const [yourName, setYourName] = useState<string>('');
    const [roomId, setRoomId] = useState<string>('');
    const [isDevice,setDevice]= useState<boolean>(false);
    const [loading, setLoading] = React.useState(false);
    const [start,setStart]= React.useState(false);
    const [stepMessage,setStepMessage]= useState<string>('連線中');
    const [, setStream] = useState<MediaStream | null>(null);
    const [timer, setTimer] = useState<number>(0);
    const [echoCancellation,setEchoCancellation ] = useState<boolean>(false);
    const params = useParams();
    const navigate = useNavigate();
    useEffect(() => {
        const pathParam = params['*'];
        setRoomId(pathParam);
        wsRef.current = new WebSocket('/api/socket');

        wsRef.current.onopen = () => {
            console.log('Connected to the signaling server');
            initialize();
        };

        wsRef.current.onmessage = (msg) => {
            console.log('Got message', msg.data);
            const content = JSON.parse(msg.data);
            const data = content.data;

            function handleCount(data: number) {
                setCount(data);
            }

            function changeYourName(data: any) {
                setYourName(data);
            }

            switch (content.event) {
                case 'offer':
                    handleOffer(data);
                    break;
                case 'answer':
                    handleAnswer(data);
                    break;
                case 'candidate':
                    handleCandidate(data);
                    break;
                case 'count':
                    handleCount(data);
                    break;
                case 'self':
                    changeYourName(data);
                    break;
                case 'start':
                    setStart(true)
                    createOffer();
                    break;
                default:
                    break;
            }
        };

        return () => {
            off();
        };
    }, []);
    useEffect(() => {
        let interval;

        if (p2pOk) {
            interval = setInterval(() => {
                setTimer(prevTimer => prevTimer + 1);
            }, 1000);
        } else {
            clearInterval(interval);
            setTimer(0);
        }

        return () => {
            clearInterval(interval);
        };
    }, [p2pOk]);
    useEffect(() => {
        if(count ==2 && !isConnect &&isDevice && start){
            createOffer();
        }
        return () => {
        };
    }, [count,isDevice,start]);

    const send = (message: any) => {
        wsRef.current?.send(JSON.stringify(message));
    };

    const initialize = () => {
        const configuration: RTCConfiguration = {
            'iceServers': [
                { urls: 'stun:stun.l.google.com:19302' },
                { urls: 'stun:stun.services.mozilla.com' },
                { urls: 'stun:global.stun.twilio.com:3478' }
            ]
        };
        peerConnectionRef.current = new RTCPeerConnection(configuration);

        peerConnectionRef.current.onicecandidate = (event) => {
            if (event.candidate) {
                send({
                    event: 'candidate',
                    data: event.candidate
                });
            }
        };
        peerConnectionRef.current.oniceconnectionstatechange = () => {
            if (peerConnectionRef.current) {
                console.log(`ICE connection state change: ${peerConnectionRef.current.iceConnectionState}`);
                if (peerConnectionRef.current.iceConnectionState === 'connected' ||
                    peerConnectionRef.current.iceConnectionState === 'completed') {
                    setStepMessage('對話中')
                    console.log('P2P connection established successfully!!');
                    setLoading(false);
                    setP2pOk(true)
                }
                if (peerConnectionRef.current.iceConnectionState === 'disconnected' ||
                    peerConnectionRef.current.iceConnectionState === 'failed' ||
                    peerConnectionRef.current.iceConnectionState === 'closed') {
                    alert(peerConnectionRef.current.iceConnectionState)
                    setP2pOk(false)
                    off();
                }
            }
        };

        dataChannelRef.current = peerConnectionRef.current.createDataChannel('dataChannel');

        dataChannelRef.current.onerror = (error) => {
            console.log('Error occurred on datachannel:', error);
        };

        dataChannelRef.current.onmessage = (event) => {
            console.log('message:', event.data);
        };

        dataChannelRef.current.onclose = () => {
            console.log('data channel is closed');
        };

        peerConnectionRef.current.ondatachannel = (event) => {
            dataChannelRef.current = event.channel;
        };


        peerConnectionRef.current.ontrack = (event) => {
            // 在這裡，您可以將接收到的視訊流添加到一個 <video> 元素中，以便在網頁上顯示視訊通話的內容
            const videoElement = document.getElementById('remoteVideo') as HTMLVideoElement;
            if (videoElement) {
                const mediaStream = event.streams[0];
                videoElement.srcObject = mediaStream;
            }
        };

        navigator.mediaDevices.getUserMedia({ video: false, audio: { echoCancellation: echoCancellation } })
            .then(stream => {
                setStream(stream)
                setDevice(true)
                send({
                    event: 'deviceOk',
                    data: 'ok'
                });
                // 獲取視訊流成功，將其添加到 RTCPeerConnection 中
                stream.getTracks().forEach(track => {
                    peerConnectionRef.current?.addTrack(track, stream);
                });
            })
            .catch(error => {
                console.log('Error accessing media devices.', error);
            });
    };

    const createOffer = () => {
        setStepMessage('撥號中')
        setLoading(true);
        peerConnectionRef.current?.createOffer()
            .then(offer => {
                send({
                    event: 'offer',
                    data: offer
                });
                return peerConnectionRef.current?.setLocalDescription(offer);
            })
            .catch(error => {
                alert(`Error creating an offer${error}`);
            });
        setIsConnect(true);
    };

    const handleOffer = (offer: RTCSessionDescriptionInit) => {
        peerConnectionRef.current?.setRemoteDescription(new RTCSessionDescription(offer))
            .then(() => {
                return peerConnectionRef.current?.createAnswer();
            })
            .then(answer => {
                return peerConnectionRef.current?.setLocalDescription(answer);
            })
            .then(() => {
                send({
                    event: 'answer',
                    data: peerConnectionRef.current?.localDescription
                });
            })
            .catch(error => {
                alert(`Error creating an answer${error}`);
            });
    };

    const handleCandidate = (candidate: RTCIceCandidateInit) => {
        peerConnectionRef.current?.addIceCandidate(new RTCIceCandidate(candidate));
        setLoading(false)
    };

    const handleAnswer = (answer: RTCSessionDescriptionInit) => {
        peerConnectionRef.current?.setRemoteDescription(new RTCSessionDescription(answer));
        console.log('connection established successfully!!');
    };

    // const sendMessage = () => {
    //     if (dataChannelRef.current) {
    //         dataChannelRef.current.send(message);
    //         setMessage('');
    //     }
    // };
    const off = () => {
        peerConnectionRef.current?.close();
        dataChannelRef.current?.close();
        wsRef.current?.close();
        // setStepMessage('對話已結束');
        setP2pOk(false);


    }
    const exist = () => {
        navigate('/callover');
    }
    const toggleEchoCancellation = () => {
        setEchoCancellation(prevState => !prevState);
    };
    return (
        <>
            <Container maxWidth="sm">

                <Box
                    display="flex"
                    flexDirection="column"
                    alignItems="center"
                    justifyContent="center"
                    height="100vh"
                >

                    <h1>{roomId}</h1>
                    <video id="remoteVideo" autoPlay playsInline></video>

                    <h1>{stepMessage}</h1>
                    <Box sx={{m: 1, position: 'relative'}}>


                        {loading && (
                            <CircularProgress
                                size={24}
                                sx={{
                                    color: green[500],
                                    position: 'absolute',
                                    top: '50%',
                                    left: '50%',
                                    marginTop: '-12px',
                                    marginLeft: '-12px'
                                }}
                            />
                        )}
                    </Box>
                    {p2pOk &&
                        <>
                            <h2>
                                通話時間:{timer}
                            </h2>
                            <Button sx={{width: '100%'}} onClick={toggleEchoCancellation}      variant="contained">
                                {echoCancellation?  <VolumeDown />:  <VolumeUp />}
                            </Button>

                            {/*<IconButton*/}
                            {/*    onClick={toggleEchoCancellation}*/}
                            {/*    style={{ backgroundColor: echoCancellation ? 'red' : 'green' }}*/}
                            {/*>*/}
                            {/*    <VolumeMute />*/}
                            {/*</IconButton>*/}

                            <Button sx={{width: '100%'}}
                                    color="error"
                                    variant="contained"
                                    onClick={exist}
                            >
                                掛電話
                            </Button>

                        </>
                    }
                    <footer>{yourName}</footer>
                </Box>
            </Container>
        </>
    );
};

export default App;
