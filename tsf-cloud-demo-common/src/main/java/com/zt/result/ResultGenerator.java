/**
 * 
 */
package com.zt.result;

import com.zt.enums.ResultCode;

/**
 * Result构造器
 * @author zt.赵童
 * @since 2019-01-14
 */
public class ResultGenerator {
	
	public static<T> Result<T> success() {
		Result<T> result = new Result<T>();
		result.setResultCode(ResultCode.SUCCESS);
		return result;
	}

	public static<T> Result<T> success(T data) {
		Result<T> result = new Result<T>();
		result.setResultCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	public static<T> Result<T> success(Integer code, String msg,T data) {
		Result<T> result = new Result<T>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
	
	public static<T> Result<T> failure(ResultCode resultCode) {
		Result<T> result = new Result<T>();
		result.setResultCode(resultCode);
		return result;
	}

	public static<T> Result<T> failure(ResultCode resultCode, T data) {
		Result<T> result = new Result<T>();
		result.setResultCode(resultCode);
		result.setData(data);
		return result;
	}

	public static<T> Result<T> failure(Integer code, String msg) {
		Result<T> result = new Result<T>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	public static<T> Result<T> failure(Integer code, String msg,T data) {
		Result<T> result = new Result<T>();
		result.setCode(code);
		result.setMsg(msg);
		result.setData(data);
		return result;
	}
}
