package com.sofka.usecase.mambu;

import com.sofka.model.mambu.retiro.RequestRetiro;
import com.sofka.model.mambu.retiro.ResponseRetiro;
import com.sofka.model.mambu.retiro.gateways.IMambuDepositGateway;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

public class MambuCreateWithDrawalTransactionUseCase implements BiFunction<RequestRetiro, String, Mono<ResponseRetiro>> {
    private final IMambuDepositGateway mambuDepositGateway;

    public MambuCreateWithDrawalTransactionUseCase(IMambuDepositGateway mambuDepositGateway) {
        this.mambuDepositGateway = mambuDepositGateway;
    }


    @Override
    public Mono<ResponseRetiro> apply(RequestRetiro mambuRequestCashOut, String accountId) {
        System.out.println(mambuRequestCashOut);
        if(mambuRequestCashOut.getAmount() < 0){
            return Mono.error(new RuntimeException("Balance bellow 0"));
        }
        return mambuDepositGateway.createWithDrawalTransaction(mambuRequestCashOut, accountId);
    }
}
