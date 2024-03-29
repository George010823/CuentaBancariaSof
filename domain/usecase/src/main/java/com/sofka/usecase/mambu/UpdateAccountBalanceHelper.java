package com.sofka.usecase.mambu;

import com.sofka.model.dto.UpdateBalanceDTO;
import com.sofka.model.enums.TYPE;
import com.sofka.model.mambu.retiro.MambuResponseAccountBalanceInfo;

import java.util.Objects;

import static com.sofka.model.enums.CHANNEL.*;
import static com.sofka.model.enums.TYPE.DEPOSIT;
import static com.sofka.model.enums.TYPE.WITHDRAW;

public class UpdateAccountBalanceHelper {
    public static Double getTransactionTax(UpdateBalanceDTO updateBalanceDTO){
        if (updateBalanceDTO.getType() == null || updateBalanceDTO.getChannel() == null) {
            return 0.0;
        }
        switch (updateBalanceDTO.getType()) {
            case DEPOSIT:
                switch (updateBalanceDTO.getChannel()) {
                    case PHYSICAL_LOCATION:
                        return 0.0;
                    case ATM:
                        return 0.2;
                    case ANOTHER_ACCOUNT:
                        return 0.15;
                }
                break;
            case WITHDRAW:
                switch (updateBalanceDTO.getChannel()) {
                    case PHYSICAL_STORE:
                        return 0.0;
                    case WEB:
                        return 0.5;
                    case ATM:
                        return 0.1;
                }
                break;
        }
        return 0.0;
    }

    public static Double getTransactionNewBalance(MambuResponseAccountBalanceInfo accountBalanceInfo, UpdateBalanceDTO updateBalanceDTO, double tax){
        if (updateBalanceDTO.getType() == TYPE.DEPOSIT) {
            return accountBalanceInfo.getBalances().getTotalBalance() - tax + updateBalanceDTO.getTransactionCost();
        } else if (updateBalanceDTO.getType() == WITHDRAW) {
            return accountBalanceInfo.getBalances().getTotalBalance() - tax - updateBalanceDTO.getTransactionCost();
        }
        return accountBalanceInfo.getBalances().getTotalBalance();
    }
}
