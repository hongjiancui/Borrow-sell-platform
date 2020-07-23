package com.neusoft.bsp.info.service;

import com.neusoft.bsp.info.entity.DropShipper;
import com.neusoft.bsp.info.mapper.DropShipperMapper;
import com.neusoft.bsp.info.service.impl.BrandServiceImpl;
import com.neusoft.bsp.info.service.impl.DropShipperServiceImpl;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class DropShipperServiceTest {
    @MockBean
    private DropShipperMapper dropShipperMapper;

    @Resource
    private DropShipperService dropShipperService;

    @Configuration
    static class dropshipperServiceConfig {
        @Bean
        public DropShipperService dropShipperService() {
            return new DropShipperServiceImpl();
        }
    }

    @Test
    public void getDropShipper() {
        String userId = "1";

        DropShipper dropShipper = new DropShipper();
        dropShipper.setUserId(userId);
        when(dropShipperMapper.getDropShipperByUserId(any())).thenReturn(dropShipper);

        DropShipper result = dropShipperService.getDropShipper(userId);
        Assertions.assertEquals(userId, result.getUserId());
    }

    @Test
    public void updateDropShipper() {
        DropShipper dropShipper = new DropShipper();

        when(dropShipperMapper.update(any())).thenReturn(1);
        int result = dropShipperService.updateDropShipper(dropShipper);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void addDropShipper() {
        DropShipper dropShipper = new DropShipper();

        when(dropShipperMapper.insert(any())).thenReturn(1);
        int result = dropShipperService.addDropShipper(dropShipper);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void getDropShipperByDsrId() {
        String dsrId = "1";

        DropShipper dropShipper = new DropShipper();
        dropShipper.setDsrId(dsrId);
        when(dropShipperMapper.getById(any())).thenReturn(dropShipper);

        DropShipper result = dropShipperService.getDropShipperByDsrId(dsrId);
        Assertions.assertEquals(dsrId, result.getDsrId());
    }
}