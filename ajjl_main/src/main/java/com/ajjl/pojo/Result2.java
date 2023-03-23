package com.ajjl.pojo;

public class Result2 {
    private Boolean success;
    private String message;
    private Object result;

    public Result2() {
    }

    public Result2(Boolean success, String message, Object result) {
        this.success = success;
        this.message = message;
        this.result = result;
    }

    public Result2(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Result2{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", result=" + result +
                '}';
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
