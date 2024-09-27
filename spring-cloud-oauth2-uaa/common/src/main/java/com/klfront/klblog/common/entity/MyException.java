package com.klfront.klblog.common.entity;

/**
 * @Description 自定义异常类
 * @Author BinXiang
 * @Date 2020/4/28 17:03
 **/

public class MyException extends RuntimeException {
    private Integer code;
    private String msg;

    public MyException() {
        super();
    }

    public MyException(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
