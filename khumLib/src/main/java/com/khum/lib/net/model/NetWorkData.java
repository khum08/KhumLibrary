package com.khum.lib.net.model;

/**
 * <pre>
 *     author : khum
 *     time   : 2018/5/10
 *     desc   :
 * </pre>
 */
public class NetWorkData<T> {

    private int code;
    private String message;
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
