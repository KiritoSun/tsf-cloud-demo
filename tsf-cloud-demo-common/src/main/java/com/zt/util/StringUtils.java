package com.zt.util;

/**
 * 字符串校验帮助类
 */
public class StringUtils {

	/**
	 * 判断字符串是否为空
	 * @param str 字符串
	 * @return boolean
	 */
	public static boolean isEmpty(String str){
		return str == null || str.trim().length() == 0;
	}

	/**
	 * 判断字符串是否不为空
	 * @param str 字符串
	 * @return boolean
	 */
	public static boolean isNotEmpty(String str){
		return str != null && str.trim().length() > 0;
	}
	
}
