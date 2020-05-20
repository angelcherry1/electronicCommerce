package com.xhc.bigbusinessu.Entity;

import java.util.List;

public class ShopOrderDetailsEntity {


    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"order_id":"11","user_id":"50","order_sn":"201910231523015361","order_status":4,"consignee":"收货人","province":"四川省","city":"资阳市","district":"雁江区","address":"天府五街","mobile":"13562365847","goods_price":"35.00","shipping_price":"0.00","total_amount":"35.00","add_time":"1571815381","pay_time":"0","shipping_time":"1571908205","user_note":"","store_id":"6","store":{"store_id":"6","store_name":"成都店铺1","grade_id":"1","company_name":"成都店铺1","province_id":"33007","city_id":"33008","district":"33163","store_address":"天府五街","store_collect":"0","store_logo":"http://jshop.cc/Public/upload/seller/2019/10-24/5db16cba82bd9.jpg","location":"四川省成都市双流县","store_goods_num":"9","grade_name":"系统默认"},"shipping_name":"快递","shipping_no":"123123123123","goods_list":[{"order_goods_id":"442","city_goods_id":"3","goods_name":"五花肉 生鲜土猪肉 生猪肉","goods_sn":"11122d","goods_num":"1","goods_price":"35.00","is_send":"1","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg","goods_status":3,"all_goods_price":"35.00"}]}
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
         * order_id : 11
         * user_id : 50
         * order_sn : 201910231523015361
         * order_status : 4
         * consignee : 收货人
         * province : 四川省
         * city : 资阳市
         * district : 雁江区
         * address : 天府五街
         * mobile : 13562365847
         * goods_price : 35.00
         * shipping_price : 0.00
         * total_amount : 35.00
         * add_time : 1571815381
         * pay_time : 0
         * shipping_time : 1571908205
         * user_note :
         * store_id : 6
         * store : {"store_id":"6","store_name":"成都店铺1","grade_id":"1","company_name":"成都店铺1","province_id":"33007","city_id":"33008","district":"33163","store_address":"天府五街","store_collect":"0","store_logo":"http://jshop.cc/Public/upload/seller/2019/10-24/5db16cba82bd9.jpg","location":"四川省成都市双流县","store_goods_num":"9","grade_name":"系统默认"}
         * shipping_name : 快递
         * shipping_no : 123123123123
         * goods_list : [{"order_goods_id":"442","city_goods_id":"3","goods_name":"五花肉 生鲜土猪肉 生猪肉","goods_sn":"11122d","goods_num":"1","goods_price":"35.00","is_send":"1","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg","goods_status":3,"all_goods_price":"35.00"}]
         */

        private String order_id;
        private String user_id;
        private String order_sn;
        private int order_status;
        private String consignee;
        private String province;
        private String city;
        private String district;
        private String address;
        private String mobile;
        private String goods_price;
        private String shipping_price;
        private String total_amount;
        private String add_time;
        private String pay_time;
        private String shipping_time;
        private String user_note;
        private String store_id;
        private StoreBean store;
        private String shipping_name;
        private String shipping_no;
        private List<GoodsListBean> goods_list;

        public String getOrder_id() {
            return order_id;
        }

        public void setOrder_id(String order_id) {
            this.order_id = order_id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getOrder_sn() {
            return order_sn;
        }

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public int getOrder_status() {
            return order_status;
        }

        public void setOrder_status(int order_status) {
            this.order_status = order_status;
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

        public String getGoods_price() {
            return goods_price;
        }

        public void setGoods_price(String goods_price) {
            this.goods_price = goods_price;
        }

        public String getShipping_price() {
            return shipping_price;
        }

        public void setShipping_price(String shipping_price) {
            this.shipping_price = shipping_price;
        }

        public String getTotal_amount() {
            return total_amount;
        }

        public void setTotal_amount(String total_amount) {
            this.total_amount = total_amount;
        }

        public String getAdd_time() {
            return add_time;
        }

        public void setAdd_time(String add_time) {
            this.add_time = add_time;
        }

        public String getPay_time() {
            return pay_time;
        }

        public void setPay_time(String pay_time) {
            this.pay_time = pay_time;
        }

        public String getShipping_time() {
            return shipping_time;
        }

        public void setShipping_time(String shipping_time) {
            this.shipping_time = shipping_time;
        }

        public String getUser_note() {
            return user_note;
        }

        public void setUser_note(String user_note) {
            this.user_note = user_note;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public String getShipping_name() {
            return shipping_name;
        }

        public void setShipping_name(String shipping_name) {
            this.shipping_name = shipping_name;
        }

        public String getShipping_no() {
            return shipping_no;
        }

        public void setShipping_no(String shipping_no) {
            this.shipping_no = shipping_no;
        }

        public List<GoodsListBean> getGoods_list() {
            return goods_list;
        }

        public void setGoods_list(List<GoodsListBean> goods_list) {
            this.goods_list = goods_list;
        }

        public static class StoreBean {
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

        public static class GoodsListBean {
            /**
             * order_goods_id : 442
             * city_goods_id : 3
             * goods_name : 五花肉 生鲜土猪肉 生猪肉
             * goods_sn : 11122d
             * goods_num : 1
             * goods_price : 35.00
             * is_send : 1
             * original_img : http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg
             * goods_status : 3
             * all_goods_price : 35.00
             */

            private String order_goods_id;
            private String city_goods_id;
            private String goods_name;
            private String goods_sn;
            private String goods_num;
            private String goods_price;
            private String is_send;
            private String original_img;
            private int goods_status;
            private String all_goods_price;

            public String getOrder_goods_id() {
                return order_goods_id;
            }

            public void setOrder_goods_id(String order_goods_id) {
                this.order_goods_id = order_goods_id;
            }

            public String getCity_goods_id() {
                return city_goods_id;
            }

            public void setCity_goods_id(String city_goods_id) {
                this.city_goods_id = city_goods_id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public String getGoods_sn() {
                return goods_sn;
            }

            public void setGoods_sn(String goods_sn) {
                this.goods_sn = goods_sn;
            }

            public String getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(String goods_num) {
                this.goods_num = goods_num;
            }

            public String getGoods_price() {
                return goods_price;
            }

            public void setGoods_price(String goods_price) {
                this.goods_price = goods_price;
            }

            public String getIs_send() {
                return is_send;
            }

            public void setIs_send(String is_send) {
                this.is_send = is_send;
            }

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }

            public int getGoods_status() {
                return goods_status;
            }

            public void setGoods_status(int goods_status) {
                this.goods_status = goods_status;
            }

            public String getAll_goods_price() {
                return all_goods_price;
            }

            public void setAll_goods_price(String all_goods_price) {
                this.all_goods_price = all_goods_price;
            }
        }
    }
}
