package com.zt.exception;


import com.zt.enums.ResultCode;

/**
 * 自定义数据库异常类
 * @author zt.赵童
 * @since 2019-01-16
 */
public class DataOperateException extends MyException {

	private static final long serialVersionUID = 1L;

	public DataOperateException(ResultCode retCode) {
		super(retCode);
	}

	public DataOperateException(String message, ResultCode retCode) {
		super(message, retCode);
	}

}
