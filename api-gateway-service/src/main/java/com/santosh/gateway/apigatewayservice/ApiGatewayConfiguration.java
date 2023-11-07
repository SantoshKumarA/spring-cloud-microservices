package com.santosh.gateway.apigatewayservice;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Function;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
// http://localhost:8765/currency-exchange-service/currency-exchange/from/USD/to/INR
        return builder.routes()
                .route(p -> p.path("/get")
                        .filters(f -> f
                                .addRequestHeader("MyHeader", "MyURIValue")
                                .addRequestParameter("MyRequestParam", "MyRequestParamValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p.path("/currency-exchange/**")
                        .uri("lb://currency-exchange-service"))    // Talk to Eureka on this name "/currency-exchange-service/" and Load balance it also.
                .route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-conversion-rest-template/**").uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-conversion-feign/**").uri("lb://currency-conversion-service"))
                .route(p -> p.path("/currency-conversion-new/**").filters(f -> f.rewritePath(
                        "/currency-conversion-new/(?<segment>.*)", "/currency-conversion-feign/${segment}"
                        ))
                        .uri("lb://currency-conversion-service"))
                .build();
    }
}
