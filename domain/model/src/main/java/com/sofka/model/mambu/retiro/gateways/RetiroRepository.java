package com.sofka.model.mambu.retiro.gateways;

import com.sofka.model.Header;
import com.sofka.model.mambu.retiro.RequestRetiro;
import com.sofka.model.mambu.retiro.ResponseRetiro;
import reactor.core.publisher.Mono;

public interface RetiroRepository {
    Mono<ResponseRetiro> generarRetiro(RequestRetiro requestRetiro, Header header, String  idCuentaDeposito);
    Mono<ResponseRetiro> createWithDrawalTransaction(RequestRetiro mambuRequestCashOut, String accountId);

    Mono<ResponseRetiro> getAccountBalance(String accountId);
}
