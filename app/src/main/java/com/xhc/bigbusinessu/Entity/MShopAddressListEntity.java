package com.xhc.bigbusinessu.Entity;

import java.io.Serializable;
import java.util.List;

public class MShopAddressListEntity {

    /**
     * status : 1
     * msg : 成功
     * code :
     * data : [{"address_id":"36","user_id":"50","consignee":"收货人","province":"33007","city":"36497","district":"36499","address":"天府五街","mobile":"13562365847","is_default":"0","province_name":"四川省","city_name":"资阳市","district_name":"雁江区"}]
     */

    private String status;
    private String msg;
    private String code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        /**
         * address_id : 36
         * user_id : 50
         * consignee : 收货人
         * province : 33007
         * city : 36497
         * district : 36499
         * address : 天府五街
         * mobile : 13562365847
         * is_default : 0
         * province_name : 四川省
         * city_name : 资阳市
         * district_name : 雁江区
         */

        private String address_id;
        private String user_id;
        private String consignee;
        private String province;
        private String city;
        private String district;
        private String address;
        private String mobile;
        private String is_default;
        private String province_name;
        private String city_name;
        private String district_name;

        public String getAddress_id() {
            return address_id;
        }

        public void setAddress_id(String address_id) {
            this.address_id = address_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getConsignee() {
            return consignee;
        }

        public void setConsignee(String consignee) {
            this.consignee = consignee;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getDistrict() {
            return district;
        }

        public void setDistrict(String district) {
            this.district = district;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getIs_default() {
            return is_default;
        }

        public void setIs_default(String is_default) {
            this.is_default = is_default;
        }

        public String getProvince_name() {
            return province_name;
        }

        public void setProvince_name(String province_name) {
            this.province_name = province_name;
        }

        public String getCity_name() {
            return city_name;
        }

        public void setCity_name(String city_name) {
            this.city_name = city_name;
        }

        public String getDistrict_name() {
            return district_name;
        }

        public void setDistrict_name(String district_name) {
            this.district_name = district_name;
        }
    }
}
