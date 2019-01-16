package com.zt.exception;

import com.zt.enums.ResultCode;

/**
 * 自定义权限异常类
 * @author zt.赵童
 * @since 2019-01-16
 */
public class AuthException extends MyException {

    private static final long serialVersionUID = 1L;

    public AuthException() {
        super(ResultCode.PERMISSION_NO_ACCESS);
    }

    public AuthException(String message) {
        super(message, ResultCode.PERMISSION_NO_ACCESS);
    }

}
