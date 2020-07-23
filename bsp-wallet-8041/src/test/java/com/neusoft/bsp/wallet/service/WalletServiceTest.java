package com.neusoft.bsp.wallet.service;

import com.neusoft.bsp.wallet.entity.Account;
import com.neusoft.bsp.wallet.entity.AccountFund;
import com.neusoft.bsp.wallet.entity.TransactionAudit;
import com.neusoft.bsp.wallet.entity.TransactionRecord;
import com.neusoft.bsp.wallet.mapper.AccountFundMapper;
import com.neusoft.bsp.wallet.mapper.AccountMapper;
import com.neusoft.bsp.wallet.mapper.TransactionAuditMapper;
import com.neusoft.bsp.wallet.mapper.TransactionRecordMapper;
import com.neusoft.bsp.wallet.service.impl.WalletServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class WalletServiceTest {
    @MockBean
    private AccountMapper accountMapper;

    @MockBean
    private AccountFundMapper accountFundMapper;

    @MockBean
    private TransactionRecordMapper transactionRecordMapper;

    @MockBean
    private TransactionAuditMapper transactionAuditMapper;

    @Resource
    private WalletService walletService;

    @Configuration
    static class walletServiceConfig {
        @Bean
        public WalletService walletService() {
            return new WalletServiceImpl();
        }
    }

    @Test
    public void register() {
        when(accountMapper.insert(any())).thenReturn(1);
        when(accountMapper.getLastId()).thenReturn("1");
        when(accountFundMapper.insertData(any())).thenReturn(1);

        int result = walletService.register(new Account());
        Assertions.assertEquals(1, result);
    }

    @Test
    public void usernameExist() {
        when(accountMapper.getUsername("exist")).thenReturn(1);
        when(accountMapper.getUsername("not exist")).thenReturn(0);

        int result_exist = walletService.usernameExist("exist");
        int result_notExist = walletService.usernameExist("not exist");
        Assertions.assertEquals(1, result_exist);
        Assertions.assertEquals(0, result_notExist);
    }

    @Test
    public void login() {
        Account account = new Account();
        account.setPassword("password");
        account.setUsername("username");

        when(accountMapper.getAccountByUsername(any()))
                .thenReturn(account);

        Account result = walletService.login(account);
        Assertions.assertEquals("username", result.getUsername());
        Assertions.assertEquals("password", result.getPassword());
    }

    @Test
    public void getWalletInfo() {
        String walletId = "1";
        AccountFund accountFund = new AccountFund();
        accountFund.setWalletId("1");

        when(accountFundMapper.getById(any())).thenReturn(accountFund);

        AccountFund walletInfo = walletService.getWalletInfo(walletId);
        Assertions.assertEquals("1", walletInfo.getWalletId());
    }

    @Test
    public void updateWallet() {
        when(accountMapper.update(any())).thenReturn(1);

        int result = walletService.updateWallet(new Account());
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getTransactions() {
        List<TransactionRecord> records = new ArrayList<>();
        records.add(new TransactionRecord());
        records.add(new TransactionRecord());

        when(transactionRecordMapper.getTransactionsByWalletId(any())).thenReturn(records);

        List<TransactionRecord> result = walletService.getTransactions("test");
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void recharge() {
        Map<String, String> params = new HashMap<>();
        params.put("walletId", "1");
        params.put("money", "100");

        when(transactionRecordMapper.getLastId()).thenReturn("1");
        walletService.recharge(params);
    }

    @Test
    public void withdraw() {
        Map<String, String> params = new HashMap<>();
        params.put("walletId", "1");
        params.put("money", "100");

        when(transactionRecordMapper.getLastId()).thenReturn("1");
        walletService.withdraw(params);
    }

    @Test
    public void getTransactionAudit() {
        List<TransactionAudit> records = new ArrayList<>();
        records.add(new TransactionAudit());
        records.add(new TransactionAudit());

        when(transactionAuditMapper.getTransactionAuditByStatus()).thenReturn(records);
        List<TransactionAudit> result = walletService.getTransactionAudit();
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void auditPass() {
        Map<String, String> params = new HashMap<>();
        params.put("walletId", "1");
        params.put("transactionAuditId", "1");

        TransactionAudit ta = new TransactionAudit();
        ta.setTransactionId("1");
        ta.setOperateType("1");

        when(transactionAuditMapper.getById(any())).thenReturn(ta);
        walletService.auditPass(params);
    }

    @Test
    public void auditRefuse() {
        Map<String, String> params = new HashMap<>();
        params.put("walletId", "1");
        params.put("transactionAuditId", "1");

        TransactionAudit ta = new TransactionAudit();
        ta.setTransactionId("1");
        ta.setOperateType("1");

        when(transactionAuditMapper.getById(any())).thenReturn(ta);
        walletService.auditRefuse(params);
    }

    @Test
    public void pay() {
        Map<String, String> params = new HashMap<>();
        params.put("walletId_dsr", "1");
        params.put("userId_brd", "1");
        params.put("money", "100");

        when(accountMapper.getWalletIdByUserId(any())).thenReturn("1");
        walletService.pay(params);
    }

    @Test
    public void refund() {
        Map<String, String> params = new HashMap<>();
        params.put("userId_dsr", "1");
        params.put("userId_brd", "1");
        params.put("money", "100");

        when(accountMapper.getWalletIdByUserId(any())).thenReturn("1");
        walletService.refund(params);
    }

    @Test
    public void binding() {
        Map<String, String> params = new HashMap<>();
        params.put("walletId", "1");
        params.put("userId", "1");
        walletService.binding(params);
    }
}