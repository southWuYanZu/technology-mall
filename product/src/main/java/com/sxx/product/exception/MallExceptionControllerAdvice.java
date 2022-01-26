package com.sxx.product.exception;

import com.sxx.common.utils.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mr.shen
 * @since 2022/01/19 上午 10:01
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.sxx")
public class MallExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity validDataException(MethodArgumentNotValidException e) {
        BindingResult bindingResult = e.getBindingResult();
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        Map<String, String> errorMap = new HashMap<>(fieldErrors.size());
        fieldErrors.forEach(fieldError -> {
            String errorField = fieldError.getField();
            String errorMsg = fieldError.getDefaultMessage();
            errorMap.put(errorField, errorMsg);
        });
        return ResponseEntity.error(400, "数据校验出错").put("data", errorMap);
    }
}
