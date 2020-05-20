package com.xhc.bigbusinessu.Entity;

public class UploadAvatarEntity {


    /**
     * status : 1
     * msg : 上传成功
     * code :
     * data : {"url":"/Public/upload/images/20191017/5da7d5ab242b6.png","httpurl":"http://jshop.cc/Public/upload/images/20191017/5da7d5ab242b6.png"}
     */

    private int status;
    private String msg;
    private String code;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * url : /Public/upload/images/20191017/5da7d5ab242b6.png
         * httpurl : http://jshop.cc/Public/upload/images/20191017/5da7d5ab242b6.png
         */

        private String url;
        private String httpurl;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getHttpurl() {
            return httpurl;
        }

        public void setHttpurl(String httpurl) {
            this.httpurl = httpurl;
        }
    }
}
