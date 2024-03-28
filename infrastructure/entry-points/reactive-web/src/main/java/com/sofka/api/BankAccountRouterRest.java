package com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class BankAccountRouterRest {

    @Bean
    public RouterFunction<ServerResponse> accountRoutes(AccountHandler accountHandler) {
        return RouterFunctions.route(
                        POST("/api/account/create").and(accept(MediaType.APPLICATION_JSON))
                        , accountHandler::createAccount)
                .andRoute(
                        GET("/api/account/getById").and(RequestPredicates.accept(MediaType.APPLICATION_JSON))
                                .and(RequestPredicates.queryParam("id", id -> true))
                        , accountHandler::getAccountById)
                .andRoute(
                        PUT("/api/account/updateBalance").and(accept(MediaType.APPLICATION_JSON))
                                .and(RequestPredicates.queryParam("id", id -> true))
                        ,accountHandler::updateTransaction);
    }
}
