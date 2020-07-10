package com.neusoft.bsp.wallet.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionAudit {
    private String transactionAuditId;
    private String transactionId;
    private String operateMoney;
    private String operateType;
    private String status;
    private String createTime;
    private String username;
    private String walletId;
}
