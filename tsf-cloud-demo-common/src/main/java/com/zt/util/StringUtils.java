package com.zt.util;

public class StringUtils {

	/**
	 * 判断字符串是否为空。
	 */
	public static boolean isEmpty(String str){
		if(str == null || str.trim().length() == 0){
			return true;
		}
		return false;
	}
	
	/**
	 * 判断字符串是否不为空。
	 */
	public static boolean isNotEmpty(String str){
		if(str != null && str.trim().length() > 0){
			return true;
		}
		return false;
	}
	
}
