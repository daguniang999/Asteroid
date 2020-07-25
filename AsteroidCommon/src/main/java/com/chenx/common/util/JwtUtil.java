package com.chenx.common.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.chenx.common.bean.User;


import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    public static final String SECRET = "HDSKSDDJKMDds";

    public static final int calendarField = Calendar.DATE;

    /**
         * JWT生成Token.
     *
     * JWT构成: header, payload, signature
     *
     * @param user_id
     *
     */
    public static String createToken(String user_id, String username) throws Exception {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.HOUR_OF_DAY, 1);
        Date expTime = calendar.getTime();


        Map<String, Object> header = new HashMap<String, Object>();
        header.put("alg", "HS256");
        header.put("typ", "JWT");

        System.out.println(now.getTime() + "   " + expTime.getTime());

        String token = JWT.create()
                .withHeader(header)
                .withClaim("id", user_id)
                .withClaim("name", username)
                .withIssuedAt(now)
                .withExpiresAt(expTime)
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }

    public static boolean verityToken(String token) throws AlgorithmMismatchException, TokenExpiredException {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
            verifier.verify(token);
        } catch(AlgorithmMismatchException e) {
            throw e;
        } catch (TokenExpiredException e) {
            throw e;
        }
        return true;
    }

    public static boolean isExpired(String token) {
        DecodedJWT decode  = JWT.decode(token);
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date endDate = decode.getExpiresAt();
        return now.compareTo(endDate) == 1 ? true : false;
    }

    public static User stringToUser(String tokenStr) {
        DecodedJWT decode  = JWT.decode(tokenStr);
        User user = new User();
        user.setId(decode.getClaim("id").asString());
        user.setName(decode.getClaim("name").asString());
        return user;
    }

//    public static String getTokenById(String token) {
//        try {
//
//        } catch (Exception e) {
//            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
//            verifier.verify(token);
//        }
//    }

    public static void main(String[] args) {
        isExpired("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyLCJleHAiOjE1OTUxNTQzMTB9.Xji3kp42ZHcLDnzFxsUKnlsZpNJzYXsSsUDMPOm5oF4");

    }
}
