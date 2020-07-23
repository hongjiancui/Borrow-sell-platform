package com.neusoft.bsp.common.base;

import java.io.Serializable;

public class R implements Serializable {
    private int status; //状态码，200：成功，500：失败
    private String msg; //描述信息
    private Object data; //服务端数据

    public static R isSuccess() {
        return new R().status(200).msg("Success!");
    }

    public static R isFail() {
        return new R().status(500).msg("Fail!");
    }

    public static R isBlocked() {
        return new R().status(444).msg("Too many request, please try again later");
    }

    public R msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public R msg(Throwable e) {
        this.setMsg(e.toString());
        return this;
    }

    public R data(Object data) {
        this.setData(data);
        return this;
    }

    public R status(int status) {
        this.setStatus(status);
        return this;
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}