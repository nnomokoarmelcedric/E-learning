package com.KNops.apigw.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableHystrix
public class GatewayConfig {
    @Autowired
    private AuthenticationFilter filter;

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("authentification", r -> r.path("/knops/auth/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://AUTHENTIFICATION"))
                .route("videos", r -> r.path("/videos/**")
                        .filters(f -> f.filter(filter))
                        .uri("lb://VIDEOS"))
                .build();
    }
}