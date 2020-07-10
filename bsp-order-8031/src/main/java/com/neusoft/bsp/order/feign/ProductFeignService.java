package com.neusoft.bsp.order.feign;

import com.neusoft.bsp.order.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "bsp-product")
public interface ProductFeignService {
    @RequestMapping(value = "/pro/get", method = RequestMethod.GET)
    Product getProduct(@RequestParam("proId") String proId);
}
