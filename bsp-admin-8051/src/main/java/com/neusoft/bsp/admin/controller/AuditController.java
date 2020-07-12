package com.neusoft.bsp.admin.controller;

import com.neusoft.bsp.admin.feign.WalletFeignService;
import com.neusoft.bsp.common.base.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/admin")
@RestController
public class AuditController {
    @Resource
    private WalletFeignService walletFeignService;

    @RequestMapping(value = "/audit/get", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('admin')")
    public R getTransactionAudits() {
        return R.isSuccess().data(walletFeignService.getTransactionAudit());
    }

    @RequestMapping(value = "/audit/pass", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public R auditPass(@RequestBody Map<String, String> params) {
        walletFeignService.auditPass(params);

        return R.isSuccess();
    }

    @RequestMapping(value = "/audit/refuse", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public R auditRefuse(@RequestBody Map<String, String> params) {
        walletFeignService.auditRefuse(params);

        return R.isSuccess();
    }
}
