package com.neusoft.bsp.oauth.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/token")
public class TokenController {

    @RequestMapping(value = "/current/get", method = RequestMethod.GET)
    public Principal getUser(Principal principal) {
        return principal;
    }
}
