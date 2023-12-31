package com.phil.headline.common;

/**
 * @author Admin
 * @version 1.0
 * @description TODO
 * @create 2023/11/19 16:58
 */
public enum ResultCodeEnum {
    SUCCESS(200, "success"),
    USERNAME_ERROR(501,"usernameError"),
    PASSWORD_ERROR(503,"passwordError"),
    NOTLOGIN(504,"notLogin"),
    USERNAME_USED(505,"userNameUsed"),
    UNKNOW_ERROR(444, "unknowError");
    private Integer code;
    private String message;

    ResultCodeEnum(Integer code, String message){
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
