package com.sofka.usecase.mambu;

import com.sofka.model.Header;
import com.sofka.model.mambu.retiro.RequestRetiro;
import com.sofka.model.mambu.retiro.ResponseRetiro;
import com.sofka.model.mambu.retiro.gateways.RetiroRepository;
import reactor.core.publisher.Mono;

import java.util.function.Function;

public class GenerarRetiroUseCase {
    private final RetiroRepository retiroRepository;

    public GenerarRetiroUseCase(RetiroRepository retiroRepository) {
        this.retiroRepository = retiroRepository;
    }

    public Mono<ResponseRetiro> generarRetiro(RequestRetiro requestRetiro, Header header, String idCuentaDeposito){
        return retiroRepository.generarRetiro(requestRetiro, header, idCuentaDeposito)
                .onErrorResume(throwable -> Mono.error(throwable));
    }
}
