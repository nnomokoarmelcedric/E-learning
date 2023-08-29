package com.KNops.configs;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class GatewayConfig {

    @Autowired
    private AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("Authentification", r -> r.path("/knops/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://Authentification"))
                .route("Videos", r -> r.path("/videos/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://Videos"))
                .build();
    }
}