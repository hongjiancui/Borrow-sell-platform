package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.wallet.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountMapper extends BaseMapper<String, Account> {
    int getUsername(@Param("username") String username);

    String getLastId();

    Account getAccountByUsername(@Param("username") String username);

    String getWalletIdByUserId(@Param("userId") String userId);

    void binding(@Param("userId") String userId, @Param("walletId") String walletId);
}
