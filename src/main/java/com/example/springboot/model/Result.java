package com.example.springboot.model;

import com.example.springboot.model.enums.ResultCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> ok(){
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(),ResultCodeEnum.SUCCESS.getDescribe(),null);
    }
    public static <T> Result<T> ok(T data){
        return new Result<>(ResultCodeEnum.SUCCESS.getCode(),ResultCodeEnum.SUCCESS.getDescribe(),data);
    }
    public static <T> Result<T> fail(){
        return new Result<>(ResultCodeEnum.FAIL.getCode(),ResultCodeEnum.FAIL.getDescribe(),null);
    }
    public static <T> Result<T> fail(ResultCodeEnum resultCodeEnum){
        return new Result<>(resultCodeEnum.getCode(),resultCodeEnum.getDescribe(),null);
    }
}
