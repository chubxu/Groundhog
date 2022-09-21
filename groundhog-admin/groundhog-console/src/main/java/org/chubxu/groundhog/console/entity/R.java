package org.chubxu.groundhog.console.entity;

import java.io.Serializable;

public class R<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public static <T> R<T> success(T data) {
        return new R<>(10000, "success", data);
    }

    public static <T> R<T> fail(T msg) {
        return new R<>(20000, "fail", msg);
    }

    public R() {
    }

    public R(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        return "R{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
