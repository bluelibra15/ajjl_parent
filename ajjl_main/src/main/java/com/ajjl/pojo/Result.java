package com.ajjl.pojo;

public class Result {
    private String message;
    private Boolean flag;
    private Object data;

    public Result() {
    }

    public Result(Boolean flag,String message) {
        this.message = message;
        this.flag = flag;
    }

    public Result(Boolean flag, String message, Object data) {
        this.message = message;
        this.flag = flag;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "message='" + message + '\'' +
                ", flag=" + flag +
                ", data=" + data +
                '}';
    }
}
