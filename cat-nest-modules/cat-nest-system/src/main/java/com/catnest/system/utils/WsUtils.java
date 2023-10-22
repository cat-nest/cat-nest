package com.catnest.system.utils;

import lombok.extern.slf4j.Slf4j;
import org.bouncycastle.jcajce.provider.symmetric.SEED;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;


/**
 * websocket 设计
 * 1.采用redis 保存用户信息 sessionId 和 用户userId进行绑定
 * 2.定时进行心跳检测，维护用户ws在线状态
 * 3.由后端服务器作为消息处理中心，转发消息实现 广播和单点
 */
@Slf4j
public class WsUtils {


    /**
     * 单点消息
     */
    public <T> void sendMessage(WebSocketSession session, T data) {


    }

    /**
     * 广播消息
     */
    public void raycastMessage() {

    }


}
