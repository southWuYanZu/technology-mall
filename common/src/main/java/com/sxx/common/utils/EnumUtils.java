package com.sxx.common.utils;

import com.sxx.common.exception.SqlException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 枚举工具类
 * 主要作用:键值对查询
 *
 * @author Mr.shen
 * @since 2022/03/09 下午 9:16
 */
public class EnumUtils {

    public static <T extends BaseEnum> int getCodeByValue(String value, Class<T> t) {
        for (T item : t.getEnumConstants()) {
            if (item.getValue().equals(value)) {
                return item.getCode();
            }
        }
        throw new SqlException("枚举转换异常");
    }

    public static <T extends BaseEnum> String getValueByCode(int code, Class<T> t) {
        List<T> value = Arrays.stream(t.getEnumConstants())
                .filter(en -> en.getCode() == code).collect(Collectors.toList());
        return value.get(0).getValue();
    }

    private EnumUtils() {

    }
}
