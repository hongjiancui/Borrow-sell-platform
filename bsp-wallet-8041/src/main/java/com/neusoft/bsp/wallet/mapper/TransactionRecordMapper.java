package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.wallet.entity.TransactionRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TransactionRecordMapper extends BaseMapper<String, TransactionRecord> {
    List<TransactionRecord> getTransactionsByWalletId(@Param("walletId") String walletId);

    String getLastId();

    int updateStatus(@Param("tId") String tId, @Param("status") String status);
}
