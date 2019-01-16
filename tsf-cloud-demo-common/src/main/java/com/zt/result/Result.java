package com.zt.result;

import com.zt.enums.ResultCode;

import java.io.Serializable;

/**
 * 自定义客户端响应格式
 * @author zt.赵童
 * @since 2019-01-14
 */
public class Result<T> implements Serializable {

	private static final long serialVersionUID = -3948389268046368059L;

	private Integer code;

	private String msg;

	private T data;

	public Result() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Result(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public void setResultCode(ResultCode code) {
		this.code = code.code();
		this.msg = code.message();
	}

}