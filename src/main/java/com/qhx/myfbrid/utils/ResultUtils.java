/**
 * @author QIUHX 
 * 2017年10月31日
 */
package com.qhx.myfbrid.utils;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ResultUtils {
	private static Map<String, Object> resultMap = new HashMap<>();
	
	/**
	 * 方法说明:putMessageMap
	 * @param object
	 * @return
	 * 消息结果
	 */
	public static Map<String, Object> putMessageMap(Object object){
		resultMap.put("Message", object);
		return resultMap;
	}
	
	/**
	 * 方法说明:putStateMap
	 * @param object
	 * @return
	 * 返回消息状态
	 */
	public static Map<String, Object> putStateMap(Object object){
		resultMap.put("State", object);
		return resultMap;
	}
	
	
	/**
	 * 方法说明:putStateMap
	 * @param object
	 * @return 地址
	 */
	public static Map<String, Object> putUrlMap(Object object){
		resultMap.put("Url", object);
		return resultMap;
	}
	
	/**
	 * 
	 * 方法说明:clearMap
	 * @param object
	 * 清空集合
	 */
	public static void clearMap(Object object){
		resultMap.clear();
	}
	
	public static String getJson(String message){
		resultMap.clear();
		resultMap.put("message", message);
		return toJson(resultMap);
	}

	/**
	 * 方法说明:toJson
	 * @param resultMap2
	 * @return
	 */
	private static String toJson(Object object) {
		return new Gson().toJson(object);
	}
}
