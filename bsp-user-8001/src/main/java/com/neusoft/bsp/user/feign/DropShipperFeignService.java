package com.neusoft.bsp.user.feign;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.user.entity.DropShipper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "bsp-information")
public interface DropShipperFeignService {
    @RequestMapping(value = "/info/bvo/add", method = RequestMethod.POST)
    R addBvoInfo(@RequestBody DropShipper dropShipper);
}
