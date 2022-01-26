package com.sxx.common.validate;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * 自定义是否注解校验器
 *
 * @author Mr.shen
 * @since 2022/01/19 下午 3:06
 */
public class StatusConstraintValidator implements ConstraintValidator<Status, Integer> {

    private final Set<Integer> set = new HashSet<>();

    @Override
    public void initialize(Status constraintAnnotation) {
        for (int value : constraintAnnotation.values()) {
            set.add(value);
        }
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return set.contains(value);
    }
}
