package com.xhc.bigbusinessu.Entity;

public class ShopDetails {

    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"store_id":"6","store_name":"成都店铺1","grade_id":"1","company_name":"成都店铺1","province_id":"33007","city_id":MyApplication.getInstance().getCityId(),"district":"33163","store_address":"天府五街","store_collect":"0","store_logo":"http://jshop.cc/Public/upload/seller/2019/10-24/5db16cba82bd9.jpg","location":"四川省成都市双流县","store_goods_num":"9","grade_name":"系统默认"}
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
         * store_id : 6
         * store_name : 成都店铺1
         * grade_id : 1
         * company_name : 成都店铺1
         * province_id : 33007
         * city_id : 33008
         * district : 33163
         * store_address : 天府五街
         * store_collect : 0
         * store_logo : http://jshop.cc/Public/upload/seller/2019/10-24/5db16cba82bd9.jpg
         * location : 四川省成都市双流县
         * store_goods_num : 9
         * grade_name : 系统默认
         */

        private String store_id;
        private String store_name;
        private String grade_id;
        private String company_name;
        private String province_id;
        private String city_id;
        private String district;
        private String store_address;
        private String store_collect;
        private String store_logo;
        private String location;
        private String store_goods_num;
        private String grade_name;

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getGrade_id() {
            return grade_id;
        }

        public void setGrade_id(String grade_id) {
            this.grade_id = grade_id;
        }

        public String getCompany_name() {
            return company_name;
        }

        public void setCompany_name(String company_name) {
            this.company_name = company_name;
        }

        public String getProvince_id() {
            return province_id;
        }

        public void setProvince_id(String province_id) {
            this.province_id = province_id;
        }

        public String getCity_id() {
            return city_id;
        }

        public void setCity_id(String city_id) {
            this.city_id = city_id;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getStore_address() {
            return store_address;
        }

        public void setStore_address(String store_address) {
            this.store_address = store_address;
        }

        public String getStore_collect() {
            return store_collect;
        }

        public void setStore_collect(String store_collect) {
            this.store_collect = store_collect;
        }

        public String getStore_logo() {
            return store_logo;
        }

        public void setStore_logo(String store_logo) {
            this.store_logo = store_logo;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getStore_goods_num() {
            return store_goods_num;
        }

        public void setStore_goods_num(String store_goods_num) {
            this.store_goods_num = store_goods_num;
        }

        public String getGrade_name() {
            return grade_name;
        }

        public void setGrade_name(String grade_name) {
            this.grade_name = grade_name;
        }
    }
}
