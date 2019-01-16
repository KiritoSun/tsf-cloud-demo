/**
 * 
 */
package com.zt.advice;

import java.util.List;

import com.zt.enums.ResultCode;
import com.zt.exception.AuthException;
import com.zt.exception.MyException;
import com.zt.result.Result;
import com.zt.result.ResultGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageConversionException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常类捕捉
 * @author zt.赵童
 * @since 2019-01-14
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 校验错误拦截处理
	 * @param exception 错误信息集合
	 * @return 错误信息
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Result validationBodyException(MethodArgumentNotValidException exception) {
		BindingResult result = exception.getBindingResult();
		StringBuffer sb=new StringBuffer();
		if (result.hasErrors()) {
			List<ObjectError> errors = result.getAllErrors();
			errors.forEach(p -> {
				FieldError fieldError = (FieldError) p;
				String msg= "参数校验提示 : " + fieldError.getDefaultMessage();
				logger.error(msg);
				sb.append(msg).append(";");

			});
		}
		return ResultGenerator.failure(ResultCode.PARAM_IS_INVALID.code(),sb.toString());
	}

	/**
	 * 参数类型转换错误
	 * @param exception 错误
	 * @return 错误信息
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(HttpMessageConversionException.class)
	public Result parameterTypeException(HttpMessageConversionException exception) {
		logger.error(exception.getCause().getLocalizedMessage());
		return ResultGenerator.failure(ResultCode.PARAM_IS_INVALID);

	}

	/**
	 * MyException异常捕捉
	 * @param exception 错误
	 * @return 错误信息
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = MyException.class)
	public Result errorHandler(MyException exception) {
		Result result = new Result();
		result.setCode(exception.getRetCode().code());
		result.setMsg(exception.getRetCode().message());
		return result;
	}

	/**
	 * 权限异常捕捉
	 * @param exception 错误
	 * @return 错误信息
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = AuthException.class)
	public Result errorHandler(AuthException exception) {
		logger.debug("error",exception);
		Result result = new Result();
		result.setCode(exception.getRetCode().code());
		result.setMsg(exception.getRetCode().message());
		return result;
	}
	
	/**
	 * 全局异常捕捉处理
	 * @param exception 错误
	 * @return 错误信息
	 */
	@SuppressWarnings("rawtypes")
	@ExceptionHandler(value = Exception.class)
	public Result errorHandler(Exception exception) {
		logger.debug("error",exception);
		Result result = new Result();
		result.setCode(ResultCode.SYSTEM_INNER_ERROR.code());
		result.setMsg(exception.getMessage());
		return result;
	}

}
