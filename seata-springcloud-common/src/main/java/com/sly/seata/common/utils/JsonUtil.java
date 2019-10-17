package com.sly.seata.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.Map.Entry;

/**
 * JSON工具类，使用的阿里巴巴fastjson
 */

@Component
public class JsonUtil {

	/**
	 * json字符串转Map对象
	 * @param json json字符串
	 */
	public Map<String, Object> toMap(String json) {
		return toMap(JSON.parseObject(json));
	}

	/**
	 * 将JSONObject对象转换成Map集合
	 * @param json JSONObject对象
	 */
	public Map<String, Object> toMap(JSONObject json) {
		Map<String, Object> map = new HashMap<>();
		Set<Entry<String, Object>> entrySet = json.entrySet();
		for (Entry<String, Object> entry : entrySet) {
			String key = entry.getKey();
			Object value = entry.getValue();
			if (value instanceof JSONArray) {
				map.put(key, toList((JSONArray) value));
			} else if (value instanceof JSONObject) {
				map.put(key, toMap((JSONObject) value));
			} else {
				map.put(key, value);
			}
		}
		return map;
	}

	/**
	 * 将JSONArray对象转换成List集合
	 * @param json JSONArray对象
	 */
	public List<Object> toList(JSONArray json) {
		List<Object> list = new ArrayList<>();
		for (Object value : json) {
			if (value instanceof JSONArray) {
				list.add(toList((JSONArray) value));
			} else if (value instanceof JSONObject) {
				list.add(toMap((JSONObject) value));
			} else {
				list.add(value);
			}
		}
		return list;
	}

	/**
	 * 将JSONArray对象转换成List集合
	 * @param json JSONArray对象
	 */
	public <T> List<T> toList(JSONArray json, Class<T> classname) {
		return null == json ? null : json.toJavaList(classname);
	}

	/**
	 * json的Object对象转json字符串
	 * @param object json的Object对象
	 */
	public String toJson(Object object) {
		return JSON.toJSONStringWithDateFormat(object, DateFormatUtil.FORMAT_yyyy_MM_dd_HH_mmss_cn, SerializerFeature.MapSortField);
	}

	/**
	 * 校验是否是json数组
	 * @param str
	 * @return
	 */
	public boolean isJsonArray(String str) {
		return JSON.isValidArray(str);
	}

	/**
	 * 转换称Json数组
	 * @param str
	 * @return
	 */
	public JSONArray parseArray(String str) {
		return JSON.parseArray(str);
	}


	
	public <T> T fromJson(String json, Class<T> clazz) {
		return JSON.parseObject(json, clazz);
	}
	
	
	
	
}
