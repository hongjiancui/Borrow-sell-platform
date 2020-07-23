package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.wallet.entity.TransactionRecord;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class TransactionRecordMapperTest {
    @Resource
    private TransactionRecordMapper transactionRecordMapper;

    @Test
    public void getTransactionsByWalletId() {
        String walletId = "9";
        List<TransactionRecord> records = transactionRecordMapper.getTransactionsByWalletId(walletId);
        Assertions.assertTrue(records.size() > 0);
    }

    @Test
    public void updateStatus() {
        String tId = "1";
        String status = "1";
        int result = transactionRecordMapper.updateStatus(tId, status);
        Assertions.assertEquals(1, result);
    }
}