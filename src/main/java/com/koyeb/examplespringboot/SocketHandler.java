package com.koyeb.examplespringboot;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

@Slf4j
@Component
@RequiredArgsConstructor
public class SocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();
    private Set<String> deviceOkList = new CopyOnWriteArraySet<>();
    private final ObjectMapper objectMapper;

    @Override
    public void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        this.removeCloseSession();
        SendMessageTypeDTO sendMessageTypeDTO = objectMapper.readValue(message.getPayload(), SendMessageTypeDTO.class);
        if (sendMessageTypeDTO.getEvent().equals("deviceOk")) {
            deviceOkList.add(session.getId());
            this.sendStartOffer(session);
        } else {
            for (WebSocketSession webSocketSession : sessions) {
                if (webSocketSession.isOpen() && !session.getId().equals(webSocketSession.getId())) {
                    log.debug("send message to session: {} ", webSocketSession.getId());
                    webSocketSession.sendMessage(message);
                }
            }
        }

    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        sessions.add(session);
        log.debug("session connected: {}", session.getId());
        this.removeCloseSession();
        this.sendOnLineCount();

        this.sendYourName(session);

    }

    private void sendStartOffer(WebSocketSession session) {
        long count = sessions.stream().map(WebSocketSession::getId).filter(deviceOkList::contains).count();
        if (count == 2) {
            SendMessageTypeDTO sendMessageTypeDTO = new SendMessageTypeDTO("start", session.getId());
            try {
                session.sendMessage(new TextMessage(objectMapper.writeValueAsString(sendMessageTypeDTO)));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    private void sendYourName(WebSocketSession session) {
        SendMessageTypeDTO sendMessageTypeDTO = new SendMessageTypeDTO("self", session.getId());
        try {
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(sendMessageTypeDTO)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        sessions.remove(session);
        this.removeCloseSession();
        this.sendOnLineCount();
    }

    private void sendOnLineCount() {
        for (WebSocketSession webSocketSession : sessions) {
            if (webSocketSession.isOpen()) {
                try {
                    SendMessageTypeDTO sendMessageTypeDTO = new SendMessageTypeDTO("count", sessions.size());
                    webSocketSession.sendMessage(new TextMessage(objectMapper.writeValueAsString(sendMessageTypeDTO)));
                } catch (IOException e) {
                    log.error("send message error", e);
                }
            }
        }
    }

    static class SendMessageTypeDTO {
        private String event;
        private Object data;

        public SendMessageTypeDTO() {
        }

        public SendMessageTypeDTO(String event, Object data) {
            this.event = event;
            this.data = data;
        }

        public String getEvent() {
            return event;
        }

        public Object getData() {
            return data;
        }
    }


    private void removeCloseSession() {
        Iterator<WebSocketSession> iterator = sessions.iterator();
        while (iterator.hasNext()) {
            WebSocketSession session = iterator.next();
            if (!session.isOpen()) {
                iterator.remove();
            }
        }
    }
}
