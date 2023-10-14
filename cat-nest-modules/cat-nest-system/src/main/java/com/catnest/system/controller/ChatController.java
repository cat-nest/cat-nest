package com.catnest.system.controller;


import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.websocket.OnMessage;

public class ChatController {

    @OnMessage
    public void onMessage(TextMessage message, WebSocketSession session) {
        System.out.println(message);
    }
}
