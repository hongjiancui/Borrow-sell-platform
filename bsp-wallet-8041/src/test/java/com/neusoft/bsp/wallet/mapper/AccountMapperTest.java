package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.wallet.entity.Account;
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
public class AccountMapperTest {
    @Resource
    private AccountMapper accountMapper;

    @Test
    public void insert() {
        Account account = new Account();
        account.setUsername("username");
        account.setPassword("password");
        account.setAccountType("1");

        int result = accountMapper.insert(account);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getUsername() {
        String username = "test_wallet";
        int result = accountMapper.getUsername(username);
        Assertions.assertTrue(result > 0);
    }

    @Test
    public void getLastId() {
        String lastId = accountMapper.getLastId();
        System.out.println(lastId);
    }

    @Test
    public void getAccountByUsername() {
        Account admin = accountMapper.getAccountByUsername("test_wallet");
        Assertions.assertEquals("test_wallet", admin.getUsername());
    }

    @Test
    public void getWalletIdByUserId() {
        String walletId = accountMapper.getWalletIdByUserId("3");
        Assertions.assertEquals("9", walletId);
    }

    @Test
    public void binding() {
        String userId = "10";
        String walletId = "13";

        accountMapper.binding(userId, walletId);
    }

    @Test
    public void update() {
        Account account = new Account();
        account.setWalletId("13");
        account.setPassword("xxxx");
        int result = accountMapper.update(account);
        Assertions.assertEquals(1, result);
    }
}
