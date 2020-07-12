package com.neusoft.bsp.product.controller;

import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.product.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/pro")
@RestController
public class FeignController {
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @PreAuthorize("isAnonymous()")
    public Product getProduct(@RequestParam("proId") String proId) {
        return productService.getProduct(proId);
    }
}
