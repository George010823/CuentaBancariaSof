package com.sofka.consumer.generarRetiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sofka.consumer.AppException;
import com.sofka.consumer.generarRetiro.dto.ResponseRetiroDTO;
import com.sofka.model.Header;
import com.sofka.model.mambu.retiro.RequestRetiro;
import com.sofka.model.mambu.retiro.ResponseRetiro;
import com.sofka.model.mambu.retiro.gateways.RetiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GenerarRetiroConsumer implements RetiroRepository {

    private WebClient client;
    private final ObjectMapper mapper;

    @Value("${adapter.restconsumer.url}")
    private String baseHost;

    @Value("${adapter.restconsumer.urlRetiro}")
    private String urlRetiro;

    @Value("${adapter.restconsumer.authorization}")
    private String authorization;

    @Override
    public Mono<ResponseRetiro> generarRetiro(RequestRetiro requestRetiro, Header header, String idCuentaDeposito) {

        client = WebClient.builder()
                .baseUrl(baseHost)
                .defaultHeader("Accept", header.getAccept())
                .defaultHeader("Content-Type", header.getContentType())
                .defaultHeader("Idempotency-Key", header.getIdempotencyKey())
                .build();


        return client.post()
                .uri(uriBuilder -> uriBuilder
                        .path(urlRetiro)
                        .build(idCuentaDeposito))
                .bodyValue(requestRetiro)
                .retrieve()
                .bodyToMono(ResponseRetiroDTO.class)
                .map(responseRetiroDTO -> mapper.convertValue(responseRetiroDTO, ResponseRetiro.class))
                .onErrorResume(WebClientResponseException.class, e ->
                        Mono.error(new AppException((HttpStatus) e.getStatusCode(), e.getResponseBodyAsString()))
                );
    }

    @Override
    public Mono<ResponseRetiro> createWithDrawalTransaction(RequestRetiro mambuRequestCashOut, String accountId) {
        return null;
    }

    @Override
    public Mono<ResponseRetiro> getAccountBalance(String accountId) {
        return null;
    }
}
