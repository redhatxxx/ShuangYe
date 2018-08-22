package org.fun.shuangye.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 通用方法
 * */
public class AbstractCommonFunction {

	/**
	 * 获取当前时间
	 * */
	public static String getNowTimeString(){
		Date date = new Date();// 获得系统时间.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss");
		String nowTime = sdf.format(date);// 将时间格式转换成符合Timestamp要求的格式.
		return nowTime;
	}
	/**
	 * 获取当前时间
	 * */
	public static Date getNowTimeDate(){
		Date date = new Date();// 获得系统时间.
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String nowTime = sdf.format(date);// 将时间格式转换成符合Timestamp要求的格式.
		Date now = null;
		try {
			now = sdf.parse(nowTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return now;
	}
}
