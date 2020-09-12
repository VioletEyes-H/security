package com.bula.security.service;

import com.bula.security.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * 使用自定义的UserDetailService
 */
@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return new User("", s, "", new ArrayList<>());
    }
    /**
     * 重载loadUserByUsername方法
     * @param openId
     * @param username
     * @return
     */
    public UserDetails loadUserByUsername(String openId, String username) {
        return new User(openId, username, "", new ArrayList<>());
    }
}
