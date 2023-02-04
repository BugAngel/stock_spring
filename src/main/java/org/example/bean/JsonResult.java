package org.example.bean;

import lombok.Data;

@Data
public class JsonResult<T> {
    private int status;
    private T data;
    private String msg;

    public JsonResult(int status, T data, String msg) {
        this.status = status;
        this.data = data;
        this.msg = msg;
    }

    public JsonResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }
}
