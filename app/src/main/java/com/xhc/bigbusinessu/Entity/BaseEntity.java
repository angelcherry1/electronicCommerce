package com.xhc.bigbusinessu.Entity;

public class BaseEntity {


    /**
     * status : 1
     * msg : 成功
     * code :
     * data : []
     */

    private int status;
    private String msg;
    private String code;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
