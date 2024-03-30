package com.sofka.consumer;

import com.sofka.model.mambu.retiro.MambuResponseAccountBalanceInfo;
import com.sofka.model.mambu.retiro.RequestRetiro;
import com.sofka.model.mambu.retiro.ResponseRetiro;
import com.sofka.model.mambu.retiro.gateways.IMambuDepositGateway;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Service
public class MambuDepositGatewayImpl implements IMambuDepositGateway {

    private final WebClient webClient;
    private boolean marcador = true;
    private String concatIncremeto;

    public MambuDepositGatewayImpl(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<ResponseRetiro> createWithDrawalTransaction(RequestRetiro mambuRequestCashOut, String accountId) {
        String externalId = mambuRequestCashOut.getExternalId();
        if (marcador){
            concatIncremeto+="AG";
            externalId = externalId + concatIncremeto;
            mambuRequestCashOut.setExternalId(externalId);
            marcador = false;
        } else {
            concatIncremeto+=7;
            externalId = externalId + concatIncremeto;
            mambuRequestCashOut.setExternalId(externalId);
        }
        return webClient
                .post()
                .uri("deposits/"+accountId+"/withdrawal-transactions")
                .bodyValue(mambuRequestCashOut)
                .retrieve()
                .bodyToMono(ResponseRetiro.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode().value() == 400) {
                        return Mono.error(new RuntimeException(ex.getResponseBodyAs(String.class)));
                    }
                    return Mono.error(ex);
                });
    }

    @Override
    public Mono<MambuResponseAccountBalanceInfo> getAccountBalance(String accountId) {
        return webClient
                .get()
                .uri("deposits/" + accountId)
                .retrieve()
                .bodyToMono(MambuResponseAccountBalanceInfo.class)
                .onErrorResume(WebClientResponseException.class, ex -> {
                    if (ex.getStatusCode().value() == 404) {
                        return Mono.error(new RuntimeException("Invalid deposit account ID"));
                    }
                    return Mono.error(ex);
                });
    }
}
