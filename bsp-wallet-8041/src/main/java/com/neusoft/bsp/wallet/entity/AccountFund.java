package com.neusoft.bsp.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountFund {
    private String walletId;
    private String availableMoney;
    private String depositingMoney;
    private String withdrawingMoney;
    private String currency;
}
