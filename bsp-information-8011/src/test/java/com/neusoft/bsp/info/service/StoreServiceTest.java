package com.neusoft.bsp.info.service;

import com.aliyun.oss.OSSClient;
import com.neusoft.bsp.info.entity.Store;
import com.neusoft.bsp.info.mapper.StoreMapper;
import com.neusoft.bsp.info.service.impl.BrandServiceImpl;
import com.neusoft.bsp.info.service.impl.StoreServiceImpl;
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
public class StoreServiceTest {
    @MockBean
    private StoreMapper storeMapper;

    @MockBean
    private OSSClient ossClient;

    @Resource
    private StoreService storeService;

    @Configuration
    static class storeServiceConfig {
        @Bean
        public StoreService storeService() {
            return new StoreServiceImpl();
        }
    }

    @Test
    public void getStores() {
        List<Store> stores = new ArrayList<>();
        stores.add(new Store());
        stores.add(new Store());
        when(storeMapper.getStoreByDsrId(any())).thenReturn(stores);

        String dsrId = "1";
        List<Store> result = storeService.getStores(dsrId);
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void addStore() {
        Store store = new Store();

        when(storeMapper.insert(any())).thenReturn(1);
        int result = storeService.addStore(store);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void deleteStore() {
        String strId = "1";

        when(storeMapper.delete(any())).thenReturn(1);
        int result = storeService.deleteStore(strId);
        Assertions.assertEquals(1, result);
    }
}