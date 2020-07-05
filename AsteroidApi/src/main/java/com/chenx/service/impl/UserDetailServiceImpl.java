package com.chenx.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailServiceImpl implements UserDetailsService {


    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
