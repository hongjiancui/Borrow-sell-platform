package com.neusoft.bsp.info.service;

import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.info.entity.Manufacturer;
import com.neusoft.bsp.info.mapper.ManufacturerMapper;
import com.neusoft.bsp.info.service.impl.BrandServiceImpl;
import com.neusoft.bsp.info.service.impl.CompanyServiceImpl;
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
public class CompanyServiceTest {
    @MockBean
    private ManufacturerMapper manufacturerMapper;

    @MockBean
    private OSSClient ossClient;

    @Resource
    private CompanyService companyService;

    @Configuration
    static class companyServiceConfig {
        @Bean
        public CompanyService companyService() {
            return new CompanyServiceImpl();
        }
    }

    @Test
    public void getAllCompanies() {
        List<Manufacturer> result = new ArrayList<>();
        result.add(new Manufacturer());
        result.add(new Manufacturer());

        when(manufacturerMapper.getManufacturersByUserId(any())).thenReturn(result);

        String userId = "1";
        List<Manufacturer> returnData = companyService.getAllCompanies(userId);
        Assertions.assertTrue(returnData.size() > 0);
    }

    @Test
    public void addCompany() {
        Manufacturer manufacturer = new Manufacturer();

        when(manufacturerMapper.insert(any())).thenReturn(1);
        int result = companyService.addCompany(manufacturer);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void updateCompany() {
        Manufacturer manufacturer = new Manufacturer();

        when(manufacturerMapper.update(any())).thenReturn(1);
        int result = companyService.updateCompany(manufacturer);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void deleteCompany() {
        String manId = "1";

        when(manufacturerMapper.delete(any())).thenReturn(1);
        int result = companyService.deleteCompany(manId);
        Assertions.assertEquals(1, result);
    }
}