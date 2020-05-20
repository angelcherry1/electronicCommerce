package com.xhc.bigbusinessu.Entity;

public class WeChatPayInfoEntity {

    private int status;
    private String msg;
    private String code;
    private PayResultEntity.DataBean.WxpayBean data;

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

    public PayResultEntity.DataBean.WxpayBean getData() {
        return data;
    }

    public void setData(PayResultEntity.DataBean.WxpayBean data) {
        this.data = data;
    }
}
