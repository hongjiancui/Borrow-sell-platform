package com.neusoft.bsp.admin.controller;

import com.neusoft.bsp.admin.entity.CodeMaster;
import com.neusoft.bsp.admin.service.CodeMasterService;
import com.neusoft.bsp.common.base.R;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RequestMapping("/admin")
@RestController
public class CodeMasterController {
    @Resource
    private CodeMasterService codeMasterService;

    @RequestMapping(value = "/dict/get", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('admin')")
    public R getCodeMasters() {
        return R.isSuccess().data(codeMasterService.getAll());
    }

    @RequestMapping(value = "/dict/add", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public R addCodeMaster(@RequestBody CodeMaster codeMaster) {
        int result = codeMasterService.insert(codeMaster);

        if (result == 0) {
            return R.isFail().msg("fail to add");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/dict/update", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public R updateCodeMaster(@RequestBody CodeMaster codeMaster) {
        int result = codeMasterService.update(codeMaster);

        if (result == 0) {
            return R.isFail().msg("fail to update");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/dict/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAuthority('admin')")
    public R deleteCodeMaster(@RequestBody CodeMaster codeMaster) {
        int result = codeMasterService.delete(codeMaster.getCdmId());

        if (result == 0) {
            return R.isFail().msg("fail to delete");
        }

        return R.isSuccess();
    }
}
