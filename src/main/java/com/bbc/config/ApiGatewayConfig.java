package com.bbc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("user_route", r -> r.path("/api/users/**")
                        .uri("http://localhost:8092"))
                .route("ride_request_route", r -> r.path("/api/rideRequests/**")
                        .uri("http://localhost:8092"))
                .route("driver_route", r -> r.path("/api/drivers/**")
                        .uri("http://localhost:8091"))
                .route("security_route", r -> r.path("/auths/register/**")
                        .uri("http://localhost:8084"))
                .build();
    }

}
