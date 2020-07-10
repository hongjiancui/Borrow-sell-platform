package com.neusoft.bsp.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private String walletId;
    private String username;
    private String password;
    private String accountType;
    private String userId;
}
