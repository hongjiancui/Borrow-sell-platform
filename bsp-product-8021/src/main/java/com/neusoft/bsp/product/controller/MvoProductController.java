package com.neusoft.bsp.product.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.product.service.ProductService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/pro")
@RestController
public class MvoProductController {
    @Resource
    private ProductService productService;

    @RequestMapping(value = "/mvo/product/all", method = RequestMethod.GET)
    public R getAllProduct(@RequestParam("userId") String userId) {
        return R.isSuccess().data(productService.getAllProduct(userId));
    }

    @RequestMapping(value = "/mvo/product/get", method = RequestMethod.GET)
    public R getProductBasic(@RequestParam("brdId") String brdId) {
        return R.isSuccess().data(productService.getProductsBasic(brdId));
    }

    @RequestMapping(value = "/mvo/product/detail/get", method = RequestMethod.GET)
    public R getProductDetail(@RequestParam("proId") String proId) {
        return R.isSuccess().data(productService.getProductDetail(proId));
    }


    @RequestMapping(value = "/mvo/product/add", method = RequestMethod.POST)
    public R addProduct(@RequestBody Map<String, String> params) {
        int result = productService.addProduct(params);

        if (result == 0) {
            return R.isFail().msg("fail to add");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/mvo/product/update", method = RequestMethod.POST)
    public R updateProduct(@RequestBody Product product) {
        int result = productService.updateProduct(product);

        if (result == 0) {
            return R.isFail().msg("fail to update");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/mvo/product/status/update", method = RequestMethod.POST)
    public R updateProductStatus(@RequestBody Product product) {
        int result = productService.updateProductStatus(product);

        if (result == 0) {
            return R.isFail().msg("fail to update");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/mvo/product/delete", method = RequestMethod.POST)
    public R deleteProduct(@RequestBody Product product) {
        int result = productService.deleteProduct(product.getProId());

        if (result == 0) {
            return R.isFail().msg("fail to delete");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/mvo/product/detail/update", method = RequestMethod.POST)
    public R updateProductDetail(@RequestBody Map<String, String> params) {
        int result = productService.updateProductDetail(params);

        if (result == 0) {
            return R.isFail().msg("fail to update");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/mvo/product/image/upload", method = RequestMethod.POST)
    public R uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("proId") String proId){
        if (file.isEmpty()) {
            return R.isFail().msg("please select image!");
        }

        String imagePath = productService.uploadImage(file, proId);
        if (imagePath == null) {
            return R.isFail().msg("upload image fail!");
        }

        return R.isSuccess().data(imagePath);
    }
}
