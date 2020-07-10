package com.neusoft.bsp.admin.service;

import com.neusoft.bsp.admin.entity.CodeMaster;

import java.util.List;

public interface CodeMasterService {
    List<CodeMaster> getAll();

    int insert(CodeMaster codeMaster);

    int delete(String cdmId);

    int update(CodeMaster codeMaster);
}
