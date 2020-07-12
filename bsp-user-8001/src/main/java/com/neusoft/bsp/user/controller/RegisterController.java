package com.neusoft.bsp.user.controller;

import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.RegisterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class RegisterController {
    @Resource
    private RegisterService registerService;

    @GetMapping("/username/exist")
    @PreAuthorize("isAnonymous()")
    public R usernameExist(@RequestParam("username") String username) {
        int isExist = registerService.getUsername(username);
        Map<String, Integer> returnData = new HashMap<>();
        returnData.put("isExist", isExist);

        if (isExist == 1) {
            return R.isFail().msg("username has been used!").data(returnData);
        }

        return R.isSuccess().msg("username can be used!").data(returnData);
    }

    @PostMapping("/register")
    @PreAuthorize("isAnonymous()")
    public R register(@RequestBody User user) {
        registerService.register(user);

        return R.isSuccess();
    }
}
