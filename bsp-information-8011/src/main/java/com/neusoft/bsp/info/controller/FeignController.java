package com.neusoft.bsp.info.controller;

import com.neusoft.bsp.info.entity.Brand;
import com.neusoft.bsp.info.entity.DropShipper;
import com.neusoft.bsp.info.entity.Manufacturer;
import com.neusoft.bsp.info.service.BrandService;
import com.neusoft.bsp.info.service.CompanyService;
import com.neusoft.bsp.info.service.DropShipperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/info")
@RestController
public class FeignController {
    @Resource
    private BrandService brandService;

    @Resource
    private DropShipperService dropShipperService;

    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/brand/id", method = RequestMethod.GET)
    public Brand getBrandByBrandId(@RequestParam("brdId") String brdId) {
        return brandService.getBrandByBrdId(brdId);
    }

    @RequestMapping(value = "/brand/user/id", method = RequestMethod.GET)
    public String getBrandUserId(@RequestParam("brdId") String brdId) {
        return brandService.getBrandUserId(brdId);
    }

    @RequestMapping(value = "/dsr/id", method = RequestMethod.GET)
    public DropShipper getDropShipperByDsrId(@RequestParam("dsrId") String dsrId) {
        return dropShipperService.getDropShipperByDsrId(dsrId);
    }

    @RequestMapping(value = "/company/get/feign", method = RequestMethod.GET)
    public List<Manufacturer> getCompaniesFeign(@RequestParam("userId") String userId) {
        return companyService.getAllCompanies(userId);
    }
}
