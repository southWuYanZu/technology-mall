package com.sxx.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 统一返回实体类
 *
 * @author shenxianxin
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class ResponseEntity extends HashMap<String, Object> implements Serializable {
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

    public ResponseEntity ok(Object data) {
        put("data", data);
        return this;
    }

    /**
     * 利用fastjson进行反序列化
     */
    public <T> T getData(TypeReference<T> typeReference) {
        //默认是map
        Object data = get("data");
        String jsonString = JSON.toJSONString(data);
        return JSON.parseObject(jsonString, typeReference);
    }

    public <T> T getData(String key, TypeReference<T> typeReference) {
        //默认是map
        Object data = get(key);
        String jsonString = JSON.toJSONString(data);
        return JSON.parseObject(jsonString, typeReference);

    }

    public static ResponseEntity ok(Map<String, Object> map) {
        ResponseEntity r = new ResponseEntity();
        r.putAll(map);
        return r;
    }

    public static ResponseEntity ok(String key, Object value) {
        ResponseEntity r = new ResponseEntity();
        r.put(key, value);
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

    public Integer getCode() {
        return (Integer) this.get("code");
    }

    public ResponseEntity setData(Object data) {
        put("data", data);
        return this;
    }

}
