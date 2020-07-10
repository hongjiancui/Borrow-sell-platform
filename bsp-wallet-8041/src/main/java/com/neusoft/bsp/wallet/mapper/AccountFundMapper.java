package com.neusoft.bsp.wallet.mapper;

import com.neusoft.bsp.common.base.BaseMapper;
import com.neusoft.bsp.wallet.entity.AccountFund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface AccountFundMapper extends BaseMapper<String, AccountFund>  {

    /*
     * @description 创建钱包账户时自动生成账户金额数据
     * @param
     * @return int
     **/
    int insertData(@Param("walletId") String walletId);

    /*
     * @description 充值操作
     * @param
     * @return int
     **/
    int recharge(@Param("walletId") String walletId, @Param("money") double money);

    /*
     * @description 提现操作
     * @param
     * @return int
     **/
    int withdraw(@Param("walletId") String walletId, @Param("money") double money);

    /*
     * @description 充值审核通过
     * @param
     * @return int
     **/
    int rechargeAudit(@Param("walletId") String walletId, @Param("money") String money);

    /*
     * @description 充值审核拒绝
     * @param
     * @return int
     **/
    int rechargeRefuse(@Param("walletId") String walletId, @Param("money") String money);

    /*
     * @description 提现审核通过
     * @param
     * @return int
     **/
    int withdrawAudit(@Param("walletId") String walletId, @Param("money") String money);

    /*
     * @description 提现审核拒绝
     * @param
     * @return int
     **/
    int withdrawRefuse(@Param("walletId") String walletId, @Param("money") String money);

    /*
     * @description 取消订单操作，公司账户钱包增加金额
     * @param
     * @return int
     **/
    int refundBrd(@Param("walletId") String walletId, @Param("money") String money);

    /*
     * @description 取消订单操作，借卖方账户钱包增加金额
     * @param
     * @return int
     **/
    int refundDsr(@Param("walletId") String walletId, @Param("money") String money);

    /*
     * @description 支付订单操作，公司账户钱包增加金额
     * @param
     * @return int
     **/
    int payBrd(@Param("walletId") String walletId, @Param("money") String money);

    /*
     * @description 支付订单操作，借卖方账户钱包扣减金额
     * @param
     * @return int
     **/
    int payDsr(@Param("walletId") String walletId, @Param("money") String money);
}
