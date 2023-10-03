package com.catnest.gateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Flux;


@Configuration
@Slf4j
public class CatNestRouteConfig implements RouteDefinitionLocator {
    @Override
    public Flux<RouteDefinition> getRouteDefinitions() {

        log.info("start loading route info ..");

        return null;
    }
}
