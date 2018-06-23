package com.hbu.live.user.controller;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ReturnMsg {
    EMAIL_OF_PASSWORD_ERROR(1001, "账号或者密码错误"),
    TOKEN_EXPIRED(1002, "Token过期"),
    TOKEN_INVALID(1003, "Token 验证失败"),;
    public int status;
    public String message;
}
