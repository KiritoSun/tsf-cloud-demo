package com.zt.exception;


import com.zt.enums.ResultCode;

/**
 * 自定义参数异常类
 * @author zt.赵童
 * @since 2019-01-16
 */
public class ParameterInvalidException extends MyException {

	private static final long serialVersionUID = 1L;

	public ParameterInvalidException(String message) {
		super(message, ResultCode.PARAM_IS_INVALID);
	}

	public ParameterInvalidException(ResultCode retCode) {
		super(retCode);
	}

	public ParameterInvalidException(String message, ResultCode retCode) {
		super(message, retCode);
	}

}
