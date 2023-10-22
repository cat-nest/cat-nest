package com.catnest.system.handle;

import com.catnest.system.entity.MessageContent;
import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jcajce.provider.symmetric.SEED;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;

/**
 * 聊天功能得websocket组件
 */
@Slf4j
@Component
public class ChatWsHanler implements WebSocketHandler {

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String id = session.getId();
        session.sendMessage(new TextMessage("欢迎连接"));
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        Object payload = message.getPayload();
        try {
            MessageContent cast = (MessageContent) payload;
        } catch (Exception e) {
            session.sendMessage(new TextMessage("消息解析错误"));
        }
        session.sendMessage(new TextMessage("回复:" + payload));
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        log.error("ws连接出现异常", exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        log.info("session:{} 连接关闭：{}", session.getId(), closeStatus);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
