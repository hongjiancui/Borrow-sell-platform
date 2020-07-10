package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.wallet.entity.TransactionAudit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TransactionAuditMapper extends BaseMapper<String, TransactionAudit> {

    List<TransactionAudit> getTransactionAuditByStatus();

    int updateStatus(@Param("taId") String taId, @Param("status") String status);
}
