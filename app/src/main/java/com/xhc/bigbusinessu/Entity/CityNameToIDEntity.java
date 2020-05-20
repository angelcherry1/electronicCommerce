package com.xhc.bigbusinessu.Entity;

public class CityNameToIDEntity {

    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"city_id":MyApplication.getInstance().getCityId(),"city_name":"成都"}
     */

    private String status;
    private String msg;
    private String code;
    private DataBean data;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
         * city_id : 33008
         * city_name : 成都
         */

        private String city_id;
        private String city_name;

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }
    }
}
