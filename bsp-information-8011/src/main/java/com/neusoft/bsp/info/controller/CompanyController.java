package com.neusoft.bsp.info.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.info.entity.Manufacturer;
import com.neusoft.bsp.info.service.CompanyService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/info")
@RestController
public class CompanyController {
    @Resource
    private CompanyService companyService;

    @RequestMapping(value = "/company/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('admin', 'mvo')")
    public R getCompanies(@RequestParam("userId") String userId) {
        return R.isSuccess().data(companyService.getAllCompanies(userId));
    }

    @RequestMapping(value = "/company/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'mvo')")
    public R addCompany(@RequestBody Manufacturer manufacturer) {
        int result = companyService.addCompany(manufacturer);

        if (result == -1) {
            return R.isFail().msg("fail to add");
        }

        Map<String, String> returnData = new HashMap<>();
        returnData.put("manId", String.valueOf(result));
        return R.isSuccess().data(returnData);
    }

    @RequestMapping(value = "/company/update", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'mvo')")
    public R updateCompany(@RequestBody Manufacturer manufacturer) {
        int result = companyService.updateCompany(manufacturer);

        if (result == 0) {
            return R.isFail().msg("fail to update");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/company/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'mvo')")
    public R deleteCompany(@RequestBody Manufacturer manufacturer) {
        int result = companyService.deleteCompany(manufacturer.getManId());

        if (result == 0) {
            return R.isFail().msg("fail to delete");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/company/image/upload", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'mvo')")
    public R uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("manId") String manId){
        if (file.isEmpty()) {
            return R.isFail().msg("please select image!");
        }

        String imagePath = companyService.uploadImage(file, manId);
        if (imagePath == null) {
            return R.isFail().msg("upload image fail!");
        }

        return R.isSuccess().data(imagePath);
    }
}
