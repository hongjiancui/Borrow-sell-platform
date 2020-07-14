package com.neusoft.bsp.admin.service.impl;

import com.neusoft.bsp.admin.entity.CodeMaster;
import com.neusoft.bsp.admin.mapper.CodeMasterMapper;
import com.neusoft.bsp.admin.service.CodeMasterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CodeMasterServiceImpl implements CodeMasterService {
    @Resource
    private CodeMasterMapper codeMasterMapper;

    @Override
    public List<CodeMaster> getAll() {
        return codeMasterMapper.getAll();
    }

    @Override
    public int insert(CodeMaster codeMaster) {
        return codeMasterMapper.insert(codeMaster);
    }

    @Override
    public int delete(String cdmId) {
        return codeMasterMapper.delete(cdmId);
    }

    @Override
    public int update(CodeMaster codeMaster) {
        return codeMasterMapper.update(codeMaster);
    }

}
