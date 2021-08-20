package com.bw.mvvm_core.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @ClassName Model
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/17 15:35
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Model {
}
