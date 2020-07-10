package com.neusoft.bsp.user.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Component
@FeignClient(value = "bsp-wallet")
public interface WalletFeignService {
    @RequestMapping(value = "/wallet/binding", method = RequestMethod.POST)
    void binding(@RequestBody Map<String, String> params);
}
