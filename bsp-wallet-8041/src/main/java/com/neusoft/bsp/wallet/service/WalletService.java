package com.neusoft.bsp.wallet.service;

import com.neusoft.bsp.wallet.entity.Account;
import com.neusoft.bsp.wallet.entity.AccountFund;
import com.neusoft.bsp.wallet.entity.TransactionAudit;
import com.neusoft.bsp.wallet.entity.TransactionRecord;

import java.util.List;
import java.util.Map;

public interface WalletService {
    int register(Account account);

    int usernameExist(String username);

    Account login(Account account);

    AccountFund getWalletInfo(String walletId);

    int updateWallet(Account account);

    List<TransactionRecord> getTransactions(String walletId);

    void recharge(Map<String, String> params);

    void withdraw(Map<String, String> params);

    List<TransactionAudit> getTransactionAudit();

    void auditPass(Map<String, String> params);

    void auditRefuse(Map<String, String> params);

    void pay(Map<String, String> params);

    void refund(Map<String, String> params);

    void binding(Map<String, String> params);
}
