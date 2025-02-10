package com.example.demo.exception;

public enum ErrorCode {
    UNCATEGORIZED_EXCEPTION (9999,"UNCATEGORIZED_EXCEPTION"),
    KEY_INVALID (1001, "Key Message ko ton tai"),
    USER_EXISTED (1002, "User da ton tai"),

    USERNAME_INVALID(1003,"Username phai tu 3 ki tu tro len"),
    PASSWORD_INVALID(1004,"password phai tu 8 ki tu tro len"),

    USER_NOT_EXISTED (1005, "User khong ton tai"),

            ;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    private int code;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    private String message;
}
