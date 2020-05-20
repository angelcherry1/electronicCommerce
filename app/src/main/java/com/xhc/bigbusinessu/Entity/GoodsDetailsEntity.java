package com.xhc.bigbusinessu.Entity;

import java.util.List;

public class GoodsDetailsEntity {

    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"city_goods_id":"4","goods_id":"166","goods_sn":"65756476","goods_name":"上海青 小油菜 小青菜 约400g 火锅食材 新鲜蔬菜","city_goods_price":"13.90","weight":"400","store_count":"4000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg","store":{"store_id":"6","store_name":"成都店铺1","grade_id":"1","company_name":"成都店铺1","province_id":"33007","city_id":MyApplication.getInstance().getCityId(),"district":"33163","store_address":"天府五街","store_collect":"0","store_logo":"http://jshop.cc/Public/upload/seller/2019/10-24/5db16cba82bd9.jpg","location":"四川省成都市双流县","store_goods_num":"9","grade_name":"系统默认"},"gallery":["http://jshop.cc/Public/upload/goods/2019/10-17/5da8231158276.jpg","http://jshop.cc/Public/upload/goods/2019/10-17/5da82310e5046.jpg","http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg"],"content_images":["http://jshop.cc/Public/upload/goods/2019/10-24/5db1741073f2d.jpg","http://jshop.cc/Public/upload/goods/2019/10-24/5db174102748b.jpg","http://jshop.cc/Public/upload/goods/2019/10-24/5db1740fa9a60.jpg"]}
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
         * city_goods_id : 4
         * goods_id : 166
         * goods_sn : 65756476
         * goods_name : 上海青 小油菜 小青菜 约400g 火锅食材 新鲜蔬菜
         * city_goods_price : 13.90
         * weight : 400
         * store_count : 4000
         * sales_sum : 0
         * store_name : 成都店铺1
         * store_id : 6
         * original_img : http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg
         * store : {"store_id":"6","store_name":"成都店铺1","grade_id":"1","company_name":"成都店铺1","province_id":"33007","city_id":MyApplication.getInstance().getCityId(),"district":"33163","store_address":"天府五街","store_collect":"0","store_logo":"http://jshop.cc/Public/upload/seller/2019/10-24/5db16cba82bd9.jpg","location":"四川省成都市双流县","store_goods_num":"9","grade_name":"系统默认"}
         * gallery : ["http://jshop.cc/Public/upload/goods/2019/10-17/5da8231158276.jpg","http://jshop.cc/Public/upload/goods/2019/10-17/5da82310e5046.jpg","http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg"]
         * content_images : ["http://jshop.cc/Public/upload/goods/2019/10-24/5db1741073f2d.jpg","http://jshop.cc/Public/upload/goods/2019/10-24/5db174102748b.jpg","http://jshop.cc/Public/upload/goods/2019/10-24/5db1740fa9a60.jpg"]
         */

        private String city_goods_id;
        private String goods_id;
        private String goods_sn;
        private String goods_name;
        private String city_goods_price;
        private String weight;
        private String store_count;
        private String sales_sum;
        private String store_name;
        private String store_id;
        private String original_img;
        private StoreBean store;
        private List<String> gallery;
        private List<String> content_images;

        public String getCity_goods_id() {
            return city_goods_id;
        }

        public void setCity_goods_id(String city_goods_id) {
            this.city_goods_id = city_goods_id;
        }

        public String getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(String goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_sn() {
            return goods_sn;
        }

        public void setGoods_sn(String goods_sn) {
            this.goods_sn = goods_sn;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public String getCity_goods_price() {
            return city_goods_price;
        }

        public void setCity_goods_price(String city_goods_price) {
            this.city_goods_price = city_goods_price;
        }

        public String getWeight() {
            return weight;
        }

        public void setWeight(String weight) {
            this.weight = weight;
        }

        public String getStore_count() {
            return store_count;
        }

        public void setStore_count(String store_count) {
            this.store_count = store_count;
        }

        public String getSales_sum() {
            return sales_sum;
        }

        public void setSales_sum(String sales_sum) {
            this.sales_sum = sales_sum;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public String getStore_id() {
            return store_id;
        }

        public void setStore_id(String store_id) {
            this.store_id = store_id;
        }

        public String getOriginal_img() {
            return original_img;
        }

        public void setOriginal_img(String original_img) {
            this.original_img = original_img;
        }

        public StoreBean getStore() {
            return store;
        }

        public void setStore(StoreBean store) {
            this.store = store;
        }

        public List<String> getGallery() {
            return gallery;
        }

        public void setGallery(List<String> gallery) {
            this.gallery = gallery;
        }

        public List<String> getContent_images() {
            return content_images;
        }

        public void setContent_images(List<String> content_images) {
            this.content_images = content_images;
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
    }
}
