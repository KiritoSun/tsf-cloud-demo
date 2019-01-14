package com.zt.exception;


import com.zt.enums.ResultCode;

/**
 * 
 */
public class DataOperateException extends BizException {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DataOperateException(ResultCode retCode) {
		super(retCode);
	}

	public DataOperateException(String message, ResultCode retCode) {
		super(message, retCode);
	}

	public DataOperateException(String message, Throwable cause, ResultCode retCode) {
		super(message, cause, retCode);
	}
}
