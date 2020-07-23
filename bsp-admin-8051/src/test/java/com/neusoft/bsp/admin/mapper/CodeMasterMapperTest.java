package com.neusoft.bsp.admin.mapper;

import com.neusoft.bsp.admin.entity.CodeMaster;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
@Transactional
public class CodeMasterMapperTest {
    @Resource
    private CodeMasterMapper codeMasterMapper;

    @Test
    public void insert() {
        CodeMaster codeMaster = new CodeMaster("1", "1", "1", "1", "1");

        int result = codeMasterMapper.insert(codeMaster);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void update() {
        CodeMaster codeMaster = new CodeMaster("1", "1", "1", "1", "1");

        int result = codeMasterMapper.update(codeMaster);
        Assertions.assertEquals(1, result);
    }

    @Test
    public void delete() {
        String cmId = "1";

        int result = codeMasterMapper.delete(cmId);
        Assertions.assertEquals(1, result);
    }

}
