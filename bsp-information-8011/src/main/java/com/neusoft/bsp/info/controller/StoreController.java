package com.neusoft.bsp.info.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.info.entity.Store;
import com.neusoft.bsp.info.service.StoreService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

@RequestMapping("/info")
@RestController
public class StoreController {
    @Resource
    private StoreService storeService;

    @RequestMapping(value = "/store/get", method = RequestMethod.GET)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R getStores(@RequestParam("dsrId") String dsrId) {
        return R.isSuccess().data(storeService.getStores(dsrId));
    }

    @RequestMapping(value = "/store/add", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R addStore(@RequestBody Store store) {
        int result = storeService.addStore(store);

        if (result == 0) {
            return R.isFail().msg("fail to add");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/store/delete", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R deleteStore(@RequestBody Store store) {
        int result = storeService.deleteStore(store.getStrId());

        if (result == 0) {
            return R.isFail().msg("fail to delete");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/store/image/upload", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('admin', 'bvo')")
    public R uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("strId") String strId){
        if (file.isEmpty()) {
            return R.isFail().msg("please select image!");
        }

        String imagePath = storeService.uploadImage(file, strId);
        if (imagePath == null) {
            return R.isFail().msg("upload image fail!");
        }

        return R.isSuccess().data(imagePath);
    }
}
