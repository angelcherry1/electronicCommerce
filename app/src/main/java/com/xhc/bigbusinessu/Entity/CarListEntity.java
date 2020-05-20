package com.xhc.bigbusinessu.Entity;

import java.util.List;

public class CarListEntity {


    /**
     * status : 1
     * msg : 成功
     * code :
     * data : [{"store_id":6,"store_name":"成都店铺1","goodsList":[{"id":"1","city_goods_id":"2","goods_name":"精选肥牛卷 500g/盒 原切 谷饲牛肉","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg","goods_num":"5","city_goods_price":"69.80","store_id":"6"},{"id":"2","city_goods_id":"3","goods_name":"五花肉 生鲜土猪肉 生猪肉","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg","goods_num":"6","city_goods_price":"35.00","store_id":"6"}]}]
     */

    private int status;
    private String msg;
    private String code;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * store_id : 6
         * store_name : 成都店铺1
         * goodsList : [{"id":"1","city_goods_id":"2","goods_name":"精选肥牛卷 500g/盒 原切 谷饲牛肉","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg","goods_num":"5","city_goods_price":"69.80","store_id":"6"},{"id":"2","city_goods_id":"3","goods_name":"五花肉 生鲜土猪肉 生猪肉","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg","goods_num":"6","city_goods_price":"35.00","store_id":"6"}]
         */

        private int store_id;
        private String store_name;
        private List<GoodsListBean> goodsList;


        public int getStore_id() {
            return store_id;
        }

        public void setStore_id(int store_id) {
            this.store_id = store_id;
        }

        public String getStore_name() {
            return store_name;
        }

        public void setStore_name(String store_name) {
            this.store_name = store_name;
        }

        public List<GoodsListBean> getGoodsList() {
            return goodsList;
        }

        public void setGoodsList(List<GoodsListBean> goodsList) {
            this.goodsList = goodsList;
        }

        public static class GoodsListBean {
            /**
             * id : 1
             * city_goods_id : 2
             * goods_name : 精选肥牛卷 500g/盒 原切 谷饲牛肉
             * original_img : http://jshop.cc/Public/upload/goods/2019/10-17/5da822fd1cca0.jpg
             * goods_num : 5
             * city_goods_price : 69.80
             * store_id : 6
             */

            private String id;
            private String city_goods_id;
            private String goods_name;
            private String original_img;
            private String goods_num;
            private String city_goods_price;
            private String store_id;


            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
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

            public String getOriginal_img() {
                return original_img;
            }

            public void setOriginal_img(String original_img) {
                this.original_img = original_img;
            }

            public String getGoods_num() {
                return goods_num;
            }

            public void setGoods_num(String goods_num) {
                this.goods_num = goods_num;
            }

            public String getCity_goods_price() {
                return city_goods_price;
            }

            public void setCity_goods_price(String city_goods_price) {
                this.city_goods_price = city_goods_price;
            }

            public String getStore_id() {
                return store_id;
            }

            public void setStore_id(String store_id) {
                this.store_id = store_id;
            }
        }
    }
}
