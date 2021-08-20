package com.bw.mvvm_core.common;

/**
 * @ClassName MVVMModelException
 * @Description TODO
 * @Author 张海旭
 * @Date 2021/8/17 15:51
 * @Version 1.0
 * Created by Android Studio.
 * User: 张海旭
 */
public class MVVMModelException extends RuntimeException{
    public MVVMModelException(String errorMsg) {
        super(errorMsg);
    }
}
