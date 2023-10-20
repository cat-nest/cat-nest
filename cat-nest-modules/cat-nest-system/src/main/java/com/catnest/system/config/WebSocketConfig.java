package com.catnest.system.config;

import com.catnest.system.handle.ChatWsHanler;
import com.catnest.system.interceptor.CatNestWebSocketInterceptor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import javax.annotation.PostConstruct;

@Configuration
@EnableWebSocket
@Slf4j
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private ChatWsHanler chatwsHanler;

    @Autowired
    private CatNestWebSocketInterceptor catNestWebSocketInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(chatwsHanler, "/channel").addInterceptors(catNestWebSocketInterceptor);
    }


    @PostConstruct
    private void PostConstruct() {
        log.info("注册WebSocket成功");
    }

}
