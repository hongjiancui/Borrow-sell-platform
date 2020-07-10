package com.neusoft.bsp.admin.feign;

import com.neusoft.bsp.admin.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Component
@FeignClient(value = "bsp-user")
public interface UserFeignService {
    @RequestMapping(value = "/user/menu/all", method = RequestMethod.GET)
    List<User> getAllMenu();

    @RequestMapping(value = "/user/menu/add", method = RequestMethod.POST)
    void addMenu(@RequestBody Map<String, String> params);

    @RequestMapping(value = "/user/menu/delete", method = RequestMethod.POST)
    void deleteMenu(@RequestBody Map<String, String> params);
}
