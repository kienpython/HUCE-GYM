package com.example.hucegym.model;

import java.util.List;

public class FeedBackModel {
    private boolean success;
    private String message;
    private List<FeedBack> result;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<FeedBack> getResult() {
        return result;
    }

    public void setResult(List<FeedBack> result) {
        this.result = result;
    }
}
