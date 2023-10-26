package com.catnest.system.utils;

import com.catnest.system.entity.MessageContext;
import com.catnest.system.enums.MessageTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.socket.WebSocketSession;

import java.util.concurrent.ConcurrentMap;


/**
 * websocket 设计
 * 1.采用redis 保存用户信息 sessionId 和 用户userId进行绑定
 * 2.定时进行心跳检测，维护用户ws在线状态
 * 3.由后端服务器作为消息处理中心，转发消息实现 广播和单点
 */
@Slf4j
public class WsUtils {




    public void dealMessage(MessageContext context) {
        MessageTypeEnum messageType = context.getMessageType();

        String fromUser = context.getFromUser();
        String toUser = context.getToUser();
        String content = context.getContent();

        switch (messageType) {
            case SINGLE:
                //单点消息处理
                break;
            case BROADCAST:
                //广播消息处理
                break;
        }
    }

    /**
     * 单点消息
     */
    public <T> void singleMessage(MessageContext context, T data) {
        String content = context.getContent();


    }

    /**
     * 广播消息
     */
    public void raycastMessage() {

    }


}
