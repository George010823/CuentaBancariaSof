package com.sofka.model.mambu.retiro.gateways;

import com.sofka.model.mambu.retiro.MambuResponseAccountBalanceInfo;
import com.sofka.model.mambu.retiro.RequestRetiro;
import com.sofka.model.mambu.retiro.ResponseRetiro;
import reactor.core.publisher.Mono;

public interface IMambuDepositGateway {
    Mono<ResponseRetiro> createWithDrawalTransaction(RequestRetiro requestRetiro, String accountId);

    Mono<MambuResponseAccountBalanceInfo> getAccountBalance(String accountId);
}
