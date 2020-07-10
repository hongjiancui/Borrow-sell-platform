package com.neusoft.bsp.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Component
@FeignClient(value = "bsp-wallet")
public interface WalletFeignService {
    @RequestMapping(value = "/wallet/refund", method = RequestMethod.POST)
    void refund(@RequestBody Map<String, String> params);

    @RequestMapping(value = "/wallet/pay", method = RequestMethod.POST)
    void pay(@RequestBody Map<String, String> params);
}
