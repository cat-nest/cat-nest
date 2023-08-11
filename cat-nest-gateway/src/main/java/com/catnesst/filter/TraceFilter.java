package com.catnesst.filter;

import org.slf4j.MDC;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Component
public class TraceFilter implements GlobalFilter {

    private static final String TRACE_ID = "traceId";

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        ServerHttpRequest.Builder mutate = request.mutate();

        //获取请求头中的traceId
        String traceId = headers.getFirst(TRACE_ID);
        if (!StringUtils.hasText(traceId)) {
            traceId = UUID.randomUUID().toString().replace("-", "").toUpperCase(Locale.ROOT);
        }
        MDC.put(TRACE_ID, traceId);

        mutate.header(TRACE_ID, traceId);

        return chain.filter(exchange.mutate().request(mutate.build()).build());
    }
}