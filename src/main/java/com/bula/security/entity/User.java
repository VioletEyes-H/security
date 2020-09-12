package com.bula.security.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * 自定义UserDetails对象
 * 增加了一个openId对象
 * 不可以使用重写的get方法,会返回null
 */
public class User implements UserDetails {

    private String username;
    private String password;
    private Collection<? extends GrantedAuthority> authorities;
    private String openId;

    public User( String openId,String username, String password,  Collection<? extends GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.openId = openId;
    }

    public String getOpenId() {
        return openId;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }


    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
