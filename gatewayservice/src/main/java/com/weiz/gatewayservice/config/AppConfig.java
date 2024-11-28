package com.weiz.gatewayservice.config;

import com.weiz.gatewayservice.filter.LoggingGatewayFilterFactory;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder, LoggingGatewayFilterFactory loggingGatewayFilterFactory) {
        return builder.routes()
                .route("user-route", r -> r.path("/user/**")
                        .filters(f -> f.stripPrefix(1))
//                                .filter(loggingGatewayFilterFactory.apply(new LoggingGatewayFilterFactory.Config())))
//                                .circuitBreaker(c -> c.setName("CircuitBreaker")
//                                        .getFallbackUri()))
                        .uri("lb://account-service"))
                .route("report-route", r -> r.path("/report/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://statistic-service"))
                .route("notification-route", r -> r.path("/user/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://notification-service"))
                .route("client-register-route", r -> r.path("/client-register-service/**")
                        .filters(f -> f.stripPrefix(1))
                        .uri("lb://client-register-service"))
                // swagger
                .route("openapi", r -> r.path("/v3/api-docs/**")
                        .filters(f -> f.rewritePath("/v3/api-docs/(?<service>).*", "/${service}/v3/api-docs"))
                        .uri("lb://gateway-service"))

                .build();

    }
}
