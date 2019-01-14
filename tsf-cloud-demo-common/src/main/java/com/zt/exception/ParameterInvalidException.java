package com.zt.exception;


import com.zt.enums.ResultCode;

/**
 * 
 */
public class ParameterInvalidException extends BizException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ParameterInvalidException(String message) {
		super(message, ResultCode.PARAM_IS_INVALID);
	}

	public ParameterInvalidException(String message, Throwable cause) {
		super(message, cause, ResultCode.PARAM_IS_INVALID);
	}

	public ParameterInvalidException(Throwable cause) {
		super(cause);
	}

	public ParameterInvalidException(ResultCode retCode) {
		super(retCode);
	}

	public ParameterInvalidException(String message, ResultCode retCode) {
		super(message, retCode);
	}

	public ParameterInvalidException(String message, Throwable cause, ResultCode retCode) {
		super(message, cause, retCode);
	}
}
