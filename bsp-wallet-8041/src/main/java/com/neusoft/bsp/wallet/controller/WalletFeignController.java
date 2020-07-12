package com.neusoft.bsp.wallet.controller;

import com.neusoft.bsp.wallet.entity.TransactionAudit;
import com.neusoft.bsp.wallet.service.WalletService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RequestMapping("/wallet")
@RestController
public class WalletFeignController {
    @Resource
    private WalletService walletService;

    @RequestMapping(value = "/transaction/audit", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('admin')")
    public List<TransactionAudit> getTransactionAudit() {
        return walletService.getTransactionAudit();
    }

    @RequestMapping(value = "/audit/pass", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public void auditPass(@RequestBody Map<String, String> params) {
        walletService.auditPass(params);
    }

    @RequestMapping(value = "/audit/refuse", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public void auditRefuse(@RequestBody Map<String, String> params) {
        walletService.auditRefuse(params);
    }

    @RequestMapping(value = "/refund", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'mvo', 'bvo')")
    public void refund(@RequestBody Map<String, String> params) {
        walletService.refund(params);
    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'mvo', 'bvo')")
    public void pay(@RequestBody Map<String, String> params) {
        walletService.pay(params);
    }

    @RequestMapping(value = "/binding", method = RequestMethod.POST)
    @PreAuthorize("isAnonymous()")
    public void binding(@RequestBody Map<String, String> params) {
        walletService.binding(params);
    }
}
