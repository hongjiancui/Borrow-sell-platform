package com.neusoft.bsp.user.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import com.neusoft.bsp.common.base.R;
import com.neusoft.bsp.user.entity.User;
import com.neusoft.bsp.user.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@RestController
@Slf4j
@RequestMapping("/user")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PreAuthorize("isAnonymous()")
    @GetMapping("/code")
    public R getCode(HttpServletResponse response, HttpSession session) {
        //HuTool定义图形验证码的长和宽,验证码的位数，干扰线的条数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(200, 100,4,20);

        //将验证码放入session
        session.setAttribute("code", lineCaptcha.getCode());

        try {
            ServletOutputStream outputStream = response.getOutputStream();
            lineCaptcha.write(outputStream);
            outputStream.close();
        } catch (IOException e) {
            return R.isFail().msg(e.toString());
        }

        return R.isSuccess();
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public R login(@RequestBody Map<String, String> params, HttpSession session) {
        String username = params.get("username");
        String password = params.get("password");
        String code = params.get("code");

        //获得存储在session中的验证码
        String sessionCheckCode = (String) session.getAttribute("code");

        User user = loginService.login(username, password);

        if (sessionCheckCode.equals(code) && user != null){
            return R.isSuccess().msg("login successful!").data(user);
        }else {
            return R.isFail().msg("password or verification code is wrong!");
        }
    }
}
