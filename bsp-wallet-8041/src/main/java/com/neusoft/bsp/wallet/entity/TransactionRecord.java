package com.neusoft.bsp.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionRecord {
    private String transactionId;
    private String walletId;
    private String transactionNumber;
    private String transactionType;
    private String transactionMethod;
    private String transactionMoney;
    private String createTime;
    private String status;
}
