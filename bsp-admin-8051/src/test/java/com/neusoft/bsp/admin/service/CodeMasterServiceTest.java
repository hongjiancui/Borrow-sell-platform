package com.neusoft.bsp.admin.service;

import com.neusoft.bsp.admin.entity.CodeMaster;
import com.neusoft.bsp.admin.mapper.CodeMasterMapper;
import com.neusoft.bsp.admin.service.impl.CodeMasterServiceImpl;
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
public class CodeMasterServiceTest {
    @MockBean
    private CodeMasterMapper codeMasterMapper;

    @Resource
    private CodeMasterService codeMasterService;

    @Configuration
    static class codeMasterServiceConfig {
        @Bean
        public CodeMasterService codeMasterService() {
            return new CodeMasterServiceImpl();
        }
    }

    @Test
    public void getAll() {
        List<CodeMaster> result = new ArrayList<>();
        result.add(new CodeMaster());
        result.add(new CodeMaster());

        when(codeMasterMapper.getAll()).thenReturn(result);

        List<CodeMaster> returnData = codeMasterService.getAll();
        Assertions.assertTrue(returnData.size() > 0);
    }

    @Test
    public void insert() {
        CodeMaster codeMaster = new CodeMaster();

        when(codeMasterMapper.insert(any())).thenReturn(1);
        int result = codeMasterService.insert(codeMaster);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void delete() {
        String cdmId = "1";

        when(codeMasterMapper.delete(any())).thenReturn(1);
        int result = codeMasterService.delete(cdmId);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void update() {
        CodeMaster codeMaster = new CodeMaster();

        when(codeMasterMapper.update(any())).thenReturn(1);
        int result = codeMasterService.update(codeMaster);
        Assertions.assertEquals(1, result);
    }
}