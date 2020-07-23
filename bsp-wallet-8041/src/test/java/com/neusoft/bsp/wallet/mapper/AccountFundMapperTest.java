package com.neusoft.bsp.wallet.mapper;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class AccountFundMapperTest {
    @Resource
    private AccountFundMapper accountFundMapper;

    @Test
    public void insertData() {
        String walletId = "100";
        int result = accountFundMapper.insertData(walletId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void recharge() {
        String walletId = "13";
        double money = 1000;
        int recharge = accountFundMapper.recharge(walletId, money);
        Assertions.assertEquals(1, recharge);
    }

    @Test
    public void withdraw() {
        String walletId = "13";
        double money = 1000;
        int withdraw = accountFundMapper.withdraw(walletId, money);
        Assertions.assertEquals(1, withdraw);
    }

    @Test
    public void rechargeAudit() {
        String walletId = "13";
        String money = "1000";
        int rechargeAudit = accountFundMapper.rechargeAudit(walletId, money);
        Assertions.assertEquals(1, rechargeAudit);
    }

    @Test
    public void rechargeRefuse() {
        String walletId = "13";
        String money = "1000";
        int rechargeRefuse = accountFundMapper.rechargeRefuse(walletId, money);
        Assertions.assertEquals(1, rechargeRefuse);
    }

    @Test
    public void withdrawAudit() {
        String walletId = "13";
        String money = "1000";
        int withdrawAudit = accountFundMapper.withdrawAudit(walletId, money);
        Assertions.assertEquals(1, withdrawAudit);
    }

    @Test
    public void withdrawRefuse() {
        String walletId = "13";
        String money = "1000";
        int withdrawRefuse = accountFundMapper.withdrawRefuse(walletId, money);
        Assertions.assertEquals(1, withdrawRefuse);
    }

    @Test
    public void refundBrd() {
        String walletId = "13";
        String money = "1000";
        int refundBrd = accountFundMapper.refundBrd(walletId, money);
        Assertions.assertEquals(1, refundBrd);
    }

    @Test
    public void refundDsr() {
        String walletId = "13";
        String money = "1000";
        int refundDsr = accountFundMapper.refundDsr(walletId, money);
        Assertions.assertEquals(1, refundDsr);
    }

    @Test
    public void payBrd() {
        String walletId = "13";
        String money = "1000";
        int payBrd = accountFundMapper.payBrd(walletId, money);
        Assertions.assertEquals(1, payBrd);
    }

    @Test
    public void payDsr() {
        String walletId = "13";
        String money = "1000";
        int payDsr = accountFundMapper.payDsr(walletId, money);
        Assertions.assertEquals(1, payDsr);
    }
}
