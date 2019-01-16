package com.zt.exception;


import com.zt.enums.ResultCode;

/**
 * 自定义异常类
 * @author zt.赵童
 * @since 2019-01-16
 */
public class MyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private ResultCode retCode;

	public MyException() {}

	public MyException(String message) {
		super(message);
	}

	public MyException(ResultCode retCode) {
		this.retCode = retCode;
	}

	public MyException(String message, ResultCode retCode) {
		super(message);
		retCode.setMessage(message);
		this.retCode = retCode;
		
	}

	public ResultCode getRetCode() {
		return retCode;
	}

}
