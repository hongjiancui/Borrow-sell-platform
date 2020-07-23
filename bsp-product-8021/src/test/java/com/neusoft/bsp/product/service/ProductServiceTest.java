package com.neusoft.bsp.product.service;

import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.product.entity.Brand;
import com.neusoft.bsp.product.entity.Manufacturer;
import com.neusoft.bsp.product.entity.Product;
import com.neusoft.bsp.product.feign.InformationFeignService;
import com.neusoft.bsp.product.mapper.PackageInfoMapper;
import com.neusoft.bsp.product.mapper.ProductCategoryMapper;
import com.neusoft.bsp.product.mapper.ProductMapper;
import com.neusoft.bsp.product.service.impl.ProductServiceImpl;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class ProductServiceTest {
    @MockBean
    private ProductMapper productMapper;

    @MockBean
    private ProductCategoryMapper productCategoryMapper;

    @MockBean
    private PackageInfoMapper packageInfoMapper;

    @MockBean
    private InformationFeignService informationFeignService;

    @MockBean
    private OSSClient ossClient;

    @Resource
    private ProductService productService;

    @Configuration
    static class productServiceConfig {
        @Bean
        public ProductService productService() {
            return new ProductServiceImpl();
        }
    }

    @Test
    public void getProductsBasic() {
        String brdId = "1";
        List<Map<String, String>> result = new ArrayList<>();
        result.add(new HashMap<>());
        result.add(new HashMap<>());

        when(productMapper.getProductsByBrandId(any())).thenReturn(result);

        List<Map<String, String>> productsBasic = productService.getProductsBasic(brdId);
        Assertions.assertTrue(productsBasic.size() > 0);
    }

    @Test
    public void addProduct() {
        Map<String, String> params = new HashMap<>();

        when(productMapper.addProduct(any())).thenReturn(1);
        when(productMapper.getLastProductId()).thenReturn("1");
        when(productCategoryMapper.addProductCategory(any())).thenReturn(1);
        when(packageInfoMapper.addPackageInfo(any())).thenReturn(1);

        int result = productService.addProduct(params);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void updateProduct() {
        Product product = new Product();
        when(productMapper.update(any())).thenReturn(1);

        int result = productService.updateProduct(product);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void updateProductStatus() {
        Product product = new Product();
        when(productMapper.updateStatus(any())).thenReturn(1);

        int result = productService.updateProductStatus(product);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void deleteProduct() {
        String proId = "1";
        when(productMapper.delete(any())).thenReturn(1);
        when(productCategoryMapper.delete(any())).thenReturn(1);
        when(packageInfoMapper.delete(proId)).thenReturn(1);

        int result = productService.deleteProduct(proId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getProductDetail() {
        String proId = "1";
        List<Map<String, String>> result = new ArrayList<>();
        result.add(new HashMap<>());
        result.add(new HashMap<>());

        when(productMapper.getProductDetail(any())).thenReturn(result);
        List<Map<String, String>> returnData = productService.getProductDetail(proId);
        Assertions.assertTrue(returnData.size() > 0);
    }

    @Test
    public void updateProductDetail() {
        when(productMapper.updateDetail(any())).thenReturn(1);
        when(packageInfoMapper.updatePackage(any())).thenReturn(1);

        int result = productService.updateProductDetail(new HashMap<>());
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getProductsBS() {
        List<Map<String, String>> result = new ArrayList<>();
        result.add(new HashMap<>());
        result.add(new HashMap<>());

        when(productMapper.getProductsBS()).thenReturn(result);

        List<Map<String, String>> returnData = productService.getProductsBS();
        Assertions.assertTrue(returnData.size() > 0);
    }

    @Test
    public void getProduct() {
        String proId = "1";
        Product product = new Product();
        product.setProId(proId);

        when(productMapper.getById(any())).thenReturn(product);

        Product result = productService.getProduct(proId);
        Assertions.assertEquals("1", result.getProId());
    }

    @Test
    public void getAllProduct() {
        String userId = "1";

        List<Manufacturer> companies = new ArrayList<>();
        Manufacturer m = new Manufacturer();
        m.setNameEn("test");
        companies.add(m);
        when(informationFeignService.getCompanies(any())).thenReturn(companies);

        List<Product> products = new ArrayList<>();
        products.add(new Product());
        when(productMapper.getProductsByManId(any())).thenReturn(products);

        Brand brand = new Brand();
        brand.setNameEn("test");
        when(informationFeignService.getBrandByBrandId(any())).thenReturn(brand);

        List<Map<String, String>> result = productService.getAllProduct(userId);
        Assertions.assertEquals("test", result.get(0).get("manName"));
        Assertions.assertEquals("test", result.get(0).get("brdName"));
    }
}