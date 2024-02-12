package com.catnest.gateway.util;

import com.catnest.auth.domain.AuthUser;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.springframework.util.StringUtils;
import org.springframework.web.server.ServerWebExchange;

public class AuthenticationUtils {

    public static final String TOKEN = "token";

    public static String getToken(ServerWebExchange exchange) {
        String token = exchange.getRequest().getHeaders().getFirst(TOKEN);
        if (StringUtils.hasText(token)) {
            return token;
        }
        return null;
    }


}
