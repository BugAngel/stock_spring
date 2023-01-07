package org.example.bean;

import lombok.Data;

@Data
public class JsonResult<T> {
    private int code;
    private T data;
    private String msg;

    public JsonResult(int code,T data,String msg){
        this.code=code;
        this.data=data;
        this.msg=msg;
    }

    public JsonResult(int code,String msg){
        this.code=code;
        this.msg=msg;
    }
}
