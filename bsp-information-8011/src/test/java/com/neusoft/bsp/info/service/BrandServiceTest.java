package com.neusoft.bsp.info.service;

import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.info.entity.Brand;
import com.neusoft.bsp.info.mapper.BrandMapper;
import com.neusoft.bsp.info.service.impl.BrandServiceImpl;
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
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class BrandServiceTest {
    @MockBean
    private BrandMapper brandMapper;

    @MockBean
    private OSSClient ossClient;

    @Resource
    private BrandService brandService;

    @Configuration
    static class brandServiceConfig {
        @Bean
        public BrandService brandService() {
            return new BrandServiceImpl();
        }
    }

    @Test
    public void getAllBrands() {
        List<Brand> result = new ArrayList<>();
        result.add(new Brand());
        result.add(new Brand());

        String manId = "1";
        when(brandMapper.getBrandsByManId(any())).thenReturn(result);

        List<Brand> allBrands = brandService.getAllBrands(manId);
        Assertions.assertTrue(allBrands.size() > 0);
    }

    @Test
    public void addBrand() {
        when(brandMapper.insert(any())).thenReturn(1);

        Brand brand = new Brand();
        int result = brandService.addBrand(brand);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void updateBrand() {
        when(brandMapper.update(any())).thenReturn(1);

        Brand brand = new Brand();
        int result = brandService.updateBrand(brand);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void deleteBrand() {
        when(brandMapper.delete(any())).thenReturn(1);

        String brdId = "1";
        int result = brandService.deleteBrand(brdId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getBrandByBrdId() {
        String brdId = "1";
        Brand brand = new Brand();
        brand.setBrdId(brdId);

        when(brandMapper.getById(any())).thenReturn(brand);

        Brand result = brandService.getBrandByBrdId(brdId);
        Assertions.assertEquals(brdId, result.getBrdId());
    }

    @Test
    public void getBrandUserId() {
        String brdId = "1";
        when(brandMapper.getBrandUserId(any())).thenReturn("1");

        String userId = brandService.getBrandUserId(brdId);
        Assertions.assertEquals("1", userId);
    }
}