package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.wallet.entity.TransactionAudit;
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


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class TransactionAuditMapperTest {
    @Resource
    private TransactionAuditMapper transactionAuditMapper;

    @Test
    public void getTransactionAuditByStatus() {
        List<TransactionAudit> record = transactionAuditMapper.getTransactionAuditByStatus();
    }

    @Test
    public void updateStatus() {
        String taId = "1";
        String status = "-1";

        int result = transactionAuditMapper.updateStatus(taId, status);
        Assertions.assertEquals(1, result);
    }
}