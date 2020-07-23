package com.neusoft.bsp.wallet.service.impl;

import cn.hutool.core.util.IdUtil;
import com.neusoft.bsp.wallet.entity.Account;
import com.neusoft.bsp.wallet.entity.AccountFund;
import com.neusoft.bsp.wallet.entity.TransactionAudit;
import com.neusoft.bsp.wallet.entity.TransactionRecord;
import com.neusoft.bsp.wallet.mapper.AccountFundMapper;
import com.neusoft.bsp.wallet.mapper.AccountMapper;
import com.neusoft.bsp.wallet.mapper.TransactionAuditMapper;
import com.neusoft.bsp.wallet.mapper.TransactionRecordMapper;
import com.neusoft.bsp.wallet.service.WalletService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class WalletServiceImpl implements WalletService {
    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountFundMapper accountFundMapper;

    @Resource
    private TransactionRecordMapper transactionRecordMapper;

    @Resource
    private TransactionAuditMapper transactionAuditMapper;

    @Override
    public int register(Account account) {
        int result1 = accountMapper.insert(account);

        String walletId = accountMapper.getLastId();
        int result2 = accountFundMapper.insertData(walletId);

        return result1 == 0 || result2 == 0 ? 0 : 1;
    }

    @Override
    public int usernameExist(String username) {
        return accountMapper.getUsername(username);
    }

    @Override
    public Account login(Account account) {
        Account accountGet = accountMapper.getAccountByUsername(account.getUsername());

        if (accountGet == null || !accountGet.getPassword().equals(account.getPassword())) {
            return null;
        }

        return accountGet;
    }

    @Override
    public AccountFund getWalletInfo(String walletId) {
        return accountFundMapper.getById(walletId);
    }

    @Override
    public int updateWallet(Account account) {
        return accountMapper.update(account);
    }

    @Override
    public List<TransactionRecord> getTransactions(String walletId) {
        return transactionRecordMapper.getTransactionsByWalletId(walletId);
    }

    @Override
    public void pay(Map<String, String> params) {
        String walletId_dsr = params.get("walletId_dsr");
        String userId_brd = params.get("userId_brd");
        String money = params.get("money");

        String walletId_brd = accountMapper.getWalletIdByUserId(userId_brd);

        //更新钱包信息
        accountFundMapper.payBrd(walletId_brd, money);
        accountFundMapper.payDsr(walletId_dsr, money);

        //添加流水记录
        TransactionRecord transactionRecord_dsr = new TransactionRecord();
        transactionRecord_dsr.setWalletId(walletId_dsr);
        transactionRecord_dsr.setTransactionNumber(IdUtil.simpleUUID());
        transactionRecord_dsr.setTransactionMoney(money);
        transactionRecord_dsr.setTransactionMethod("1");
        transactionRecord_dsr.setTransactionType("3");
        transactionRecord_dsr.setStatus("2");
        transactionRecordMapper.insert(transactionRecord_dsr);

        TransactionRecord transactionRecord_brd = new TransactionRecord();
        transactionRecord_brd.setWalletId(walletId_brd);
        transactionRecord_brd.setTransactionNumber(IdUtil.simpleUUID());
        transactionRecord_brd.setTransactionMoney(money);
        transactionRecord_brd.setTransactionMethod("1");
        transactionRecord_brd.setTransactionType("3");
        transactionRecord_brd.setStatus("2");
        transactionRecordMapper.insert(transactionRecord_brd);
    }

    @Override
    public void refund(Map<String, String> params) {
        String userId_dsr = params.get("userId_dsr");
        String userId_brd = params.get("userId_brd");

        String money = params.get("money");
        String walletId_dsr = accountMapper.getWalletIdByUserId(userId_dsr);
        String walletId_brd = accountMapper.getWalletIdByUserId(userId_brd);

        //更新钱包信息
        accountFundMapper.refundBrd(walletId_brd, money);
        accountFundMapper.refundDsr(walletId_dsr, money);

        //添加流水记录
        TransactionRecord transactionRecord_dsr = new TransactionRecord();
        transactionRecord_dsr.setWalletId(walletId_dsr);
        transactionRecord_dsr.setTransactionNumber(IdUtil.simpleUUID());
        transactionRecord_dsr.setTransactionMoney(money);
        transactionRecord_dsr.setTransactionMethod("1");
        transactionRecord_dsr.setTransactionType("4");
        transactionRecord_dsr.setStatus("2");
        transactionRecordMapper.insert(transactionRecord_dsr);

        TransactionRecord transactionRecord_brd = new TransactionRecord();
        transactionRecord_brd.setWalletId(walletId_brd);
        transactionRecord_brd.setTransactionNumber(IdUtil.simpleUUID());
        transactionRecord_brd.setTransactionMoney(money);
        transactionRecord_brd.setTransactionMethod("1");
        transactionRecord_brd.setTransactionType("4");
        transactionRecord_brd.setStatus("2");
        transactionRecordMapper.insert(transactionRecord_brd);
    }

    @Override
    public void recharge(Map<String, String> params) {
        String walletId = params.get("walletId");
        String money = params.get("money");

        //更新钱包账户信息
        accountFundMapper.recharge(walletId, Double.parseDouble(money));

        //添加账户记录
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setWalletId(walletId);
        transactionRecord.setTransactionNumber(IdUtil.simpleUUID());
        transactionRecord.setTransactionMoney(money);
        transactionRecord.setTransactionMethod("1");
        transactionRecord.setTransactionType("1");
        transactionRecord.setStatus("1");
        transactionRecordMapper.insert(transactionRecord);

        //添加审计记录
        String tId = transactionRecordMapper.getLastId();
        TransactionAudit transactionAudit = new TransactionAudit();
        transactionAudit.setTransactionId(tId);
        transactionAudit.setOperateMoney(money);
        transactionAudit.setOperateType("1");
        transactionAudit.setStatus("1");
        transactionAuditMapper.insert(transactionAudit);
    }

    @Override
    public void withdraw(Map<String, String> params) {
        String walletId = params.get("walletId");
        String money = params.get("money");

        //更新钱包账户信息
        accountFundMapper.withdraw(walletId, Double.parseDouble(money));

        //添加账户记录
        TransactionRecord transactionRecord = new TransactionRecord();
        transactionRecord.setWalletId(walletId);
        transactionRecord.setTransactionNumber(IdUtil.simpleUUID());
        transactionRecord.setTransactionMoney(money);
        transactionRecord.setTransactionMethod("1");
        transactionRecord.setTransactionType("2");
        transactionRecord.setStatus("1");
        transactionRecordMapper.insert(transactionRecord);

        //添加审计记录
        String tId = transactionRecordMapper.getLastId();
        TransactionAudit transactionAudit = new TransactionAudit();
        transactionAudit.setTransactionId(tId);
        transactionAudit.setOperateMoney(money);
        transactionAudit.setOperateType("2");
        transactionAudit.setStatus("1");
        transactionAuditMapper.insert(transactionAudit);
    }

    @Override
    public List<TransactionAudit> getTransactionAudit() {
        return transactionAuditMapper.getTransactionAuditByStatus();
    }

    @Override
    public void auditPass(Map<String, String> params) {
        String walletId = params.get("walletId");
        String taId = params.get("transactionAuditId");

        //获取流水记录
        TransactionAudit ta = transactionAuditMapper.getById(taId);

        //更新流水表
        transactionRecordMapper.updateStatus(ta.getTransactionId(), "2");

        //更新审计表
        transactionAuditMapper.updateStatus(taId, "2");

        //更新账户资金表：充值
        if (ta.getOperateType().equals("1")) {
            accountFundMapper.rechargeAudit(walletId, ta.getOperateMoney());
        }

        //更新账户资金表：提现
        if (ta.getOperateType().equals("2")) {
            accountFundMapper.withdrawAudit(walletId, ta.getOperateMoney());
        }
    }

    @Override
    public void auditRefuse(Map<String, String> params) {
        String walletId = params.get("walletId");
        String taId = params.get("transactionAuditId");

        //获取流水记录
        TransactionAudit ta = transactionAuditMapper.getById(taId);

        //更新流水表
        transactionRecordMapper.updateStatus(ta.getTransactionId(), "-1");

        //更新审计表
        transactionAuditMapper.updateStatus(taId, "-1");

        //更新账户资金表：充值
        if (ta.getOperateType().equals("1")) {
            accountFundMapper.rechargeRefuse(walletId, ta.getOperateMoney());
        }

        //更新账户资金表：提现
        if (ta.getOperateType().equals("2")) {
            accountFundMapper.withdrawRefuse(walletId, ta.getOperateMoney());
        }
    }

    @Override
    public void binding(Map<String, String> params) {
        String walletId = params.get("walletId");
        String userId = params.get("userId");

        accountMapper.binding(userId, walletId);
    }
}
