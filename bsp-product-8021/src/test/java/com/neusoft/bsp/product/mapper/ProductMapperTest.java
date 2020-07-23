package com.neusoft.bsp.product.mapper;

import com.neusoft.bsp.product.entity.Product;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class ProductMapperTest {
    @Resource
    private ProductMapper productMapper;

    @Test
    public void getProductsByBrandId() {
        String brdId = "1";
        List<Map<String, String>> result = productMapper.getProductsByBrandId(brdId);
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void addProduct() {
        Map<String, String> params = new HashMap<>();
        params.put("brdId", "1");
        params.put("manId", "1");
        params.put("skuCd", "1");
        params.put("name", "1");
        params.put("model", "1");
        params.put("description", "1");
        params.put("warrantyDay", "1");
        params.put("retailPrice", "1");
        params.put("minRetailPrice", "1");
        params.put("replenishmentPeriod", "1");
        params.put("warranty", "1");

        int result = productMapper.addProduct(params);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void updateStatus() {
        Product product = new Product();
        product.setProId("1");
        product.setStsCd("1");

        int result = productMapper.updateStatus(product);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getProductCategoryByBrandId() {
        String brdId = "1";
        List<Map<String, String>> result = productMapper.getProductsByBrandId(brdId);
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void getProductDetail() {
        String brdId = "1";
        List<Map<String, String>> result = productMapper.getProductDetail(brdId);
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void updateDetail() {
        Map<String, String> params = new HashMap<>();
        params.put("proId", "1");
        params.put("skuCd", "1");
        params.put("name", "1");
        params.put("model", "1");
        params.put("description", "1");
        params.put("warrantyDay", "1");
        params.put("retailPrice", "1");
        params.put("minRetailPrice", "1");
        params.put("replenishmentPeriod", "1");
        params.put("warranty", "1");

        int result = productMapper.updateDetail(params);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void updateImageUrl() {
        String proId = "1";
        String imageUrl = "http://xxxx.com";

        int result = productMapper.updateImageUrl(proId, imageUrl);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getProductsBS() {
        List<Map<String, String>> result = productMapper.getProductsBS();
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void getProductsByManId() {
        String manId = "1";
        List<Product> result = productMapper.getProductsByManId(manId);
        Assertions.assertTrue(result.size() > 0);
    }
}