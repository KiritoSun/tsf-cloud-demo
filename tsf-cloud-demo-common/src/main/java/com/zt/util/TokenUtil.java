package com.zt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;

/**
 * Token帮助类
 * @author zt.赵童
 * @since 2019-01-16
 */
public class TokenUtil {

    /**
     * 根据id和密码生成token
     * @param id 用户id
     * @param password 用户密码
     * @return token
     */
    public static String codeToken(Integer id, String password) {
        String token = null;
        token= JWT
                .create()
                .withAudience(id + "")
                .sign(Algorithm.HMAC256(password));
        return token;
    }

    /**
     * 根据token解码获取id
     * @param token token值
     * @return 用户id
     */
    public static Integer decodeToken(String token) {
        Integer id = null;
        id = Integer.parseInt(JWT.decode(token).getAudience().get(0));
        return id;
    }

    /**
     * 验证token的有效性
     * @param token token值
     * @param password 用户密码
     * @return boolean
     */
    public static boolean verifyToken(String token, String password) {
        JWTVerifier jwtVerifier = JWT.require(Algorithm
                .HMAC256(password)).build();
        try {
            jwtVerifier.verify(token);
        } catch (JWTVerificationException e) {
            return false;
        }
        return true;
    }

}
