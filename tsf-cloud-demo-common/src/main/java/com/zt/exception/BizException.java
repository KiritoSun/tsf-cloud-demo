package com.zt.exception;


import com.zt.enums.ResultCode;

/**
 * 
 */
public class BizException extends RuntimeException {

	private static final long serialVersionUID = 8363790981037455105L;
	
	private ResultCode retCode;

	public BizException() {
	}

	public BizException(String message) {
		super(message);
	}

	public BizException(String message, Throwable cause) {
		super(message, cause);
	}

	public BizException(Throwable cause) {
		super(cause);
	}

	public BizException(ResultCode retCode) {
		this.retCode = retCode;
	}

	public BizException(String message, ResultCode retCode) {
		super(message);
		retCode.setMessage(message);
		this.retCode = retCode;
		
	}

	public BizException(String message, Throwable cause, ResultCode retCode) {
		super(message, cause);
		retCode.setMessage(message);
		this.retCode = retCode;
	}

	public ResultCode getRetCode() {
		return retCode;
	}

}
