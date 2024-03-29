package com.sofka.usecase.mambu;

import com.sofka.model.mambu.retiro.MambuResponseAccountBalanceInfo;
import reactor.core.publisher.Mono;
import com.sofka.model.mambu.retiro.gateways.IMambuDepositGateway;

import java.util.function.Function;

public class MambuGetAccountBalanceUseCase implements Function<String, Mono<MambuResponseAccountBalanceInfo>> {
    private final IMambuDepositGateway mambuDepositGateway;

    public MambuGetAccountBalanceUseCase(IMambuDepositGateway mambuDepositGateway) {
        this.mambuDepositGateway = mambuDepositGateway;
    }

    @Override
    public Mono<MambuResponseAccountBalanceInfo> apply(String accountId) {
        return mambuDepositGateway.getAccountBalance(accountId);
    }
}
