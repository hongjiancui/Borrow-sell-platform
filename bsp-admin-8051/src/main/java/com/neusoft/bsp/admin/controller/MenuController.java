package com.neusoft.bsp.admin.controller;

import com.neusoft.bsp.admin.service.MenuService;
import com.neusoft.bsp.common.base.R;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RequestMapping("/admin")
@RestController
public class MenuController {
    @Resource
    private MenuService menuService;

    @RequestMapping(value = "/menu/get", method = RequestMethod.GET)
    public R getAllMenu() {
        return R.isSuccess().data(menuService.getAllMenu());
    }

    @RequestMapping(value = "/menu/add", method = RequestMethod.POST)
    public R addMenu(@RequestBody Map<String, String> params) {
        menuService.addMenu(params);
        return R.isSuccess();
    }

    @RequestMapping(value = "/menu/delete", method = RequestMethod.POST)
    public R deleteMenu(@RequestBody Map<String, String> params) {
        menuService.deleteMenu(params);
        return R.isSuccess();
    }
}
