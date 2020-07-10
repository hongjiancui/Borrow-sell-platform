package com.neusoft.bsp.product.feign;

import com.neusoft.bsp.product.entity.Brand;
import com.neusoft.bsp.product.entity.Manufacturer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "bsp-information")
public interface InformationFeignService {
    @RequestMapping(value = "/info/company/get/feign", method = RequestMethod.GET)
    List<Manufacturer> getCompanies(@RequestParam("userId") String userId);

    @RequestMapping(value = "/info/brand/id", method = RequestMethod.GET)
    Brand getBrandByBrandId(@RequestParam("brdId") String brdId);
}
