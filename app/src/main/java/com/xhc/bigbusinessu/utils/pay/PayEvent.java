package com.xhc.bigbusinessu.utils.pay;

public class PayEvent {


    private int type;
    private int status;
    private String message;


    public PayEvent(int type, int status, String message) {
        this.type = type;
        this.status = status;
        this.message = message;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
