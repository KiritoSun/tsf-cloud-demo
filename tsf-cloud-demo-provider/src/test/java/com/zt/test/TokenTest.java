package com.zt.test;

import com.zt.util.TokenUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;

public class TokenTest {

    @Test
    public void fun() {
        User user = new User(15001, "123456");
        String token = TokenUtil.codeToken(user.id, user.password);
        System.out.println("token : " + token);
        Integer id = TokenUtil.decodeToken(token);
        System.out.println("id : " + id);
        String password = user.getPassword();
        boolean result = TokenUtil.verifyToken(token + "22", password);
        System.out.println("result : " + result);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class User {
        private Integer id;
        private String password;
    }

}
