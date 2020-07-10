package com.neusoft.bsp.admin.feign;

import com.neusoft.bsp.admin.entity.TransactionAudit;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "bsp-wallet")
public interface WalletFeignService {
    @RequestMapping(value = "/wallet/transaction/audit", method = RequestMethod.GET)
    List<TransactionAudit> getTransactionAudit();

    @RequestMapping(value = "/wallet/audit/pass", method = RequestMethod.POST)
    void auditPass(@RequestBody Map<String, String> params);

    @RequestMapping(value = "/wallet/audit/refuse", method = RequestMethod.POST)
    void auditRefuse(@RequestBody Map<String, String> params);
}
