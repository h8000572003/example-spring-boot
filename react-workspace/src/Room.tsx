import React from "react";
import {Box, Container} from "@mui/material";
import Button from "@mui/material/Button";
import {useNavigate} from 'react-router-dom';

const App: React.FC = () => {
    const navigate = useNavigate();

    function createRoom() {
        navigate('/call?id=' + formatDate());
        alert('Room')
    }

    function formatDate() {
        const date = new Date();

        const year = date.getFullYear();
        const month = String(date.getMonth() + 1).padStart(2, '0');
        const day = String(date.getDate()).padStart(2, '0');
        const hours = String(date.getHours()).padStart(2, '0');
        const minutes = String(date.getMinutes()).padStart(2, '0');
        const seconds = String(date.getSeconds()).padStart(2, '0');
        const milliseconds = String(date.getMilliseconds()).padStart(3, '0');

        return `${year}${month}${day}${hours}${minutes}${seconds}${milliseconds}`;
    }

    return (
        <div>
            <Container maxWidth="sm">
                <Box
                    display="flex"
                    flexDirection="column"
                    alignItems="center"
                    justifyContent="center"
                    height="100vh"
                >
                    <h1>建立新房間</h1>
                    <Button sx={{width: '100%'}}
                            variant="contained"
                            onClick={createRoom}
                    >
                        建立
                    </Button>
                </Box>
            </Container>
        </div>
    );

}
export default App;