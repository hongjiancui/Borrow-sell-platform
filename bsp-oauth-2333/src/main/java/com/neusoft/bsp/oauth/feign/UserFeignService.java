package com.neusoft.bsp.oauth.feign;

import com.neusoft.bsp.oauth.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(value = "bsp-user")
public interface UserFeignService {
    @RequestMapping(value = "/user/getUserByUsername", method = RequestMethod.GET)
    User getUserByUsername(@RequestParam("username") String username);
}
