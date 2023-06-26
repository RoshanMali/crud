package com.example.crud;

import org.springframework.http.HttpStatus;


public class Response {
    private int status;
    private Object data;
    private Object error;

    public Response() {
        status = HttpStatus.OK.value();
    }

    public int getStatus() {
        return status;
    }

    public Object getData() {
        return data;
    }

    public Object getError() {
        return error;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setError(Object error) {
        this.error = error;
    }
}