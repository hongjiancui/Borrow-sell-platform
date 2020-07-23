package com.neusoft.bsp.info.mapper;

import com.neusoft.bsp.info.entity.Store;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class StoreMapperTest {
    @Resource
    private StoreMapper storeMapper;

    @Test
    public void getStoreByDsrId() {
        String dsrId = "1";
        List<Store> result = storeMapper.getStoreByDsrId(dsrId);
        Assertions.assertTrue(result.size() > 0);
    }

    @Test
    public void updateImageUrl() {
        String strId = "1";
        String imageUrl = "http://xxxx.com";

        int result = storeMapper.updateImageUrl(strId, imageUrl);
        Assertions.assertEquals(1, result);
    }
}