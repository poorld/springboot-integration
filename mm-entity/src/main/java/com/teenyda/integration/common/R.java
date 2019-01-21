package com.teenyda.integration.common;

import java.io.Serializable;

/**
 * @Author Administrator
 * @Date 2019-01-20.
 * @Email teenyda@gmail.com
 */
public class R<T> implements Serializable {

    private static final int OK = 0;

    private static final int FAIL = 1;

    private static final int UNAUTHORIZED = 2;

    //服务端数据
    private T data;

    //状态码
    private int status = OK;

    //描述信息
    private String msg = "";

    public R() {

    }

    public static R isOk() {
        return new R();
    }

    public static R isFail() {
        return new R().status(FAIL);
    }

    public static R isFail(Throwable e) {
        return isFail().msg(e);
    }

    public R msg(Throwable e) {
        this.setMsg(e.toString());
        return this;
    }

    public R data(T data) {
        this.setData(data);
        return this;
    }

    public R status(int status) {
        this.setStatus(status);
        return this;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
