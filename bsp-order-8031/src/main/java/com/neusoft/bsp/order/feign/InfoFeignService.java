package com.neusoft.bsp.order.feign;

import com.neusoft.bsp.order.entity.DropShipper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "bsp-information")
public interface InfoFeignService {
    @RequestMapping(value = "/info/brand/user/id", method = RequestMethod.GET)
    String getBrandUserId(@RequestParam("brdId") String brdId);

    @RequestMapping(value = "/info/dsr/id", method = RequestMethod.GET)
    DropShipper getDropShipperByDsrId(@RequestParam("dsrId") String dsrId);
}
