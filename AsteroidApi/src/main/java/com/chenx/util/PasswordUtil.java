package com.chenx.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordUtil implements PasswordEncoder {

    public boolean matches(CharSequence charSequence, String s) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(charSequence, s);
    }

    public String encode(CharSequence charSequence) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(charSequence);
    }
}
