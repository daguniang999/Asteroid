package com.chenx.jwt;

import com.chenx.common.util.JwtUtil;
import org.junit.Test;

public class JwtUtilTest {


    @Test
    public void createTokenTest() {
        Long uid = 1234L;
        try {
            String token = JwtUtil.createToken("1234", "test");
            System.out.println(token);
        } catch(Exception e){

        }
    }


    @Test
    public void verityToken() {
        System.out.println(JwtUtil.verityToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJuYW1lIjoidGVzdCIsImlkIjoiMTIzNCIsImV4cCI6MTU5NDAyNzY5NywiaWF0IjoxNTkzOTQxMjk3fQ.SIz7X2Cp3FUY_8ounaGNCqIOJ-vFGiIcAETEaC4yd9c"));
    }

}
