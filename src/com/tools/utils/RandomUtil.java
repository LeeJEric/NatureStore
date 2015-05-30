package com.tools.utils;

import java.util.UUID;

/**
 * ID工具类
 * 
 * @author LeeJEric
 * 
 */
public class RandomUtil {
	/**
	 * 获取32位随机唯一码
	 * 
	 * @return
	 */
	public static String get32RandomUUID() {
		return UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
	}
	
	/**
	 * 获取指定长度的随机字符串
	 * @param len
	 * @return
	 */
	public static String getRandomeStringForLength(int len){
		int l = len;
		StringBuffer sb = new StringBuffer();
		while(l >= 32){
			sb.append(get32RandomUUID());
			l -= 32;
		}
		return sb.append(get32RandomUUID().substring(0, l)).toString();
	}
}
