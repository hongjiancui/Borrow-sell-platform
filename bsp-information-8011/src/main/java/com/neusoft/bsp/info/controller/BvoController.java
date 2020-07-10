package com.neusoft.bsp.info.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.info.entity.Brand;
import com.neusoft.bsp.info.entity.DropShipper;
import com.neusoft.bsp.info.service.DropShipperService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("/info")
@RestController
public class BvoController {
    @Resource
    private DropShipperService dropShipperService;

    @RequestMapping(value = "/bvo/get", method = RequestMethod.GET)
    public R getBvoInfo(@RequestParam("userId") String userId) {
        return R.isSuccess().data(dropShipperService.getDropShipper(userId));
    }

    @RequestMapping(value = "/bvo/update", method = RequestMethod.POST)
    public R updateBvoInfo(@RequestBody DropShipper dropShipper) {
        int result = dropShipperService.updateDropShipper(dropShipper);

        if (result == 0) {
            return R.isFail().msg("fail to update");
        }

        return R.isSuccess();
    }

    @RequestMapping(value = "/bvo/add", method = RequestMethod.POST)
    public R addBvoInfo(@RequestBody DropShipper dropShipper) {
        int result = dropShipperService.addDropShipper(dropShipper);

        if (result == 0) {
            return R.isFail().msg("fail to add");
        }

        return R.isSuccess();
    }
}
