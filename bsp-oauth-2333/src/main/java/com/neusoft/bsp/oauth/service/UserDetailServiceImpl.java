package com.neusoft.bsp.oauth.service;

import com.neusoft.bsp.oauth.entity.User;
import com.neusoft.bsp.oauth.feign.UserFeignService;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Resource
    private UserFeignService userFeignService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userFeignService.getUserByUsername(userName);

        if(user != null){
            return new org.springframework.security.core.userdetails.User(
                    user.getUsername(),
                    user.getPassword(),
                    AuthorityUtils.createAuthorityList(user.getRole().getName()));
        }else{
            throw new UsernameNotFoundException("用户[" + userName + "]不存在");
        }
    }
}