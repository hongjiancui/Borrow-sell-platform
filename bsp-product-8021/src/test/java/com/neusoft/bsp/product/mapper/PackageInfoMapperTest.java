package com.neusoft.bsp.product.mapper;

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
import java.util.Map;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class PackageInfoMapperTest {
    @Resource
    private PackageInfoMapper packageInfoMapper;

    @Test
    public void addPackageInfo() {
        Map<String, String> params = new HashMap<>();
        params.put("proId", "1");
        params.put("width", "1");
        params.put("height", "1");
        params.put("length", "1");
        params.put("weight", "1");

        int result = packageInfoMapper.addPackageInfo(params);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void updatePackage() {
        Map<String, String> params = new HashMap<>();
        params.put("proId", "1");
        params.put("width", "1");
        params.put("height", "1");
        params.put("length", "1");
        params.put("weight", "1");

        int result = packageInfoMapper.updatePackage(params);
        Assertions.assertEquals(1, result);
    }
}