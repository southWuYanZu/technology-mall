package com.sxx.common.utils;

import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author shenxianxin
 */
public class ResponseEntity extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public ResponseEntity() {
		put("code", 0);
		put("msg", "success");
	}
	
	public static ResponseEntity error() {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, "未知异常，请联系管理员");
	}
	
	public static ResponseEntity error(String msg) {
		return error(HttpStatus.SC_INTERNAL_SERVER_ERROR, msg);
	}
	
	public static ResponseEntity error(int code, String msg) {
		ResponseEntity r = new ResponseEntity();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static ResponseEntity ok(String msg) {
		ResponseEntity r = new ResponseEntity();
		r.put("msg", msg);
		return r;
	}
	
	public static ResponseEntity ok(Map<String, Object> map) {
		ResponseEntity r = new ResponseEntity();
		r.putAll(map);
		return r;
	}
	
	public static ResponseEntity ok() {
		return new ResponseEntity();
	}

	@Override
	public ResponseEntity put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
