package com.neusoft.bsp.wallet.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.wallet.entity.Account;
import com.neusoft.bsp.wallet.service.WalletService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/wallet")
@RestController
public class WalletController {
    @Resource
    private WalletService walletService;

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public R register(@RequestBody Account account) {
        int usernameResult = walletService.usernameExist(account.getUsername());
        if (usernameResult > 0) {
            return R.isFail().msg("username has been used!");
        }

        int result = walletService.register(account);
        if (result == 0) {
            return R.isFail().msg("fail to register!");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public R login(@RequestBody Account account) {
        Account result = walletService.login(account);
        if (result == null) {
            return R.isFail().msg("username or password is wrong!");
        }

        return R.isSuccess().data(result);
    }

    @RequestMapping(value = "/info/get", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public R getWalletInfo(@RequestParam("walletId") String walletId) {
        return R.isSuccess().data(walletService.getWalletInfo(walletId));
    }

    @RequestMapping(value = "/info/update", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public R updateWallet(@RequestBody Account account) {
        int result = walletService.updateWallet(account);
        if (result == 0) {
            return R.isFail().msg("update fail!");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/transaction", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public R getTransactions(@RequestParam("walletId") String walletId) {
        return R.isSuccess().data(walletService.getTransactions(walletId));
    }

    @RequestMapping(value = "/recharge", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public R recharge(@RequestBody Map<String, String> params) {
        walletService.recharge(params);

        return R.isSuccess();
    }

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public R withdraw(@RequestBody Map<String, String> params) {
        walletService.withdraw(params);

        return R.isSuccess();
    }
}
