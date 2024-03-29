package com.sofka.config;

import com.sofka.model.bank_account.gateways.BankAccountGateway;
import com.sofka.model.mambu.retiro.gateways.IMambuDepositGateway;
import com.sofka.model.transaction.gateways.ITransactionGateway;
import com.sofka.usecase.account.CreateAccountUseCase;
import com.sofka.usecase.account.FindAccountByIdUseCase;
import com.sofka.usecase.account.UpdateTransactionUseCase;
import com.sofka.usecase.mambu.MambuCreateWithDrawalTransactionUseCase;
import com.sofka.usecase.mambu.MambuGetAccountBalanceUseCase;
import com.sofka.usecase.mambu.UpdateAccountBalanceUseCase;
import com.sofka.usecase.transaction.CreateTransactionUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {
        "com.sofka.driven"})
public class UseCasesConfig {

        @Bean
        public CreateTransactionUseCase createTransactionUseCase(ITransactionGateway iTransactionGateway){
                return new CreateTransactionUseCase(iTransactionGateway);
        }

        @Bean
        public CreateAccountUseCase createAccountUseCase(BankAccountGateway iAccountGateway){
                return new CreateAccountUseCase(iAccountGateway);
        }

        @Bean
        public UpdateAccountBalanceUseCase updateAccountBalanceUseCase(BankAccountGateway iAccountGateway){
                return new UpdateAccountBalanceUseCase(iAccountGateway);
        }

        @Bean
        public FindAccountByIdUseCase findAccountByIdUseCase(BankAccountGateway iAccountGateway){
                return new FindAccountByIdUseCase(iAccountGateway);
        }
//
//        @Bean
//        public GetAllTransactionsUseCase getAllTransactionsUseCase(ITransactionGateway iTransactionGateway){
//                return new GetAllTransactionsUseCase(iTransactionGateway);
//        }
        @Bean
        public UpdateTransactionUseCase updateTransactionUseCase(BankAccountGateway bankAccountGateway){
                return new UpdateTransactionUseCase(bankAccountGateway);
        }

        @Bean
        public MambuCreateWithDrawalTransactionUseCase createWithDrawalTransactionUseCase(IMambuDepositGateway mambuDepositGateway){
                return new MambuCreateWithDrawalTransactionUseCase(mambuDepositGateway);
        }

        @Bean
        public MambuGetAccountBalanceUseCase getAccountBalanceUseCase(IMambuDepositGateway mambuDepositGateway){
                return new MambuGetAccountBalanceUseCase(mambuDepositGateway);
        }
}
