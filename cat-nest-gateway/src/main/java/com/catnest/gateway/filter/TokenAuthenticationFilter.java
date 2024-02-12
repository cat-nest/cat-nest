package com.catnest.gateway.filter;

import com.alibaba.fastjson2.JSON;
import com.catnest.auth.domain.AuthUser;
import com.catnest.gateway.util.AuthenticationUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.print.DocFlavor;
import java.util.Arrays;
import java.util.function.Consumer;

@Component
@Slf4j
public class TokenAuthenticationFilter implements GlobalFilter, Ordered {

    //空用户
    private static final AuthUser EMPTY_AUTH_USER = new AuthUser();

    //用户信息请求头
    private static final String LOGIN_HEADER = "LOGIN_USER";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String token = AuthenticationUtils.getToken(exchange);
        //无token则继续进行
        if (!StringUtils.hasText(token)) {
            return chain.filter(exchange);
        }
        //有token则解析
        //解析token的操作在user系统 测试环境先mock一个

        return getUserLogin().defaultIfEmpty(EMPTY_AUTH_USER).flatMap(authUser -> {
            //如果用户是系统默认的空用户 则作为无token继续放行
            if (EMPTY_AUTH_USER.equals(authUser)) {
                return chain.filter(exchange);
            }
            //如果不是空，则放入缓存
            //将 user 并设置到请求头，使用 json 存储值
            ServerWebExchange build = exchange.mutate().request(builder -> {
                builder.header(LOGIN_HEADER, JSON.toJSONString(authUser));
            }).build();

            return chain.filter(build);
        });
    }


    private Mono<AuthUser> getUserLogin() {
        AuthUser authUser = new AuthUser();
        authUser.setUserId("Yiwyn");
        authUser.setUserName("伊温");
        authUser.setRoles(Arrays.asList("admin", "write"));
        return Mono.just(authUser);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
