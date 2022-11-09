package com.example.springboot.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResultCodeEnum {
    SUCCESS(200,"成功"),
    FAIL(400,"失败"),
    NO_LOGIN(401,"未登录");

    private final Integer code;
    private final String describe;
}
