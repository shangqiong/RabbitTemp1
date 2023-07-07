package com.security_1.respons;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponsResult<T>{
    private Integer code; // 状态码
    private String msg;  // 提示信息
    private T data;  // 数据
    public ResponsResult(Integer code, String msg){
        this.code = code;
        this.msg = msg;
    }
    public ResponsResult(Integer code, T data){
        this.code = code;
        this.data = data;
    }
    public ResponsResult(Integer code, String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
