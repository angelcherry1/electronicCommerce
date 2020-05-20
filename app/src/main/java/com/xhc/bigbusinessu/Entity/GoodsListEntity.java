package com.xhc.bigbusinessu.Entity;

import java.util.List;

public class GoodsListEntity {

    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"page":{"totalRows":"9","totalPages":"5","p":"1"},"list":[{"city_goods_id":"2","goods_id":"168","goods_sn":"343434111","goods_name":"精选肥牛卷 500g/盒 原切 谷饲牛肉","city_goods_price":"69.80","store_count":"2000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da8245ada3e6.jpg"},{"city_goods_id":"3","goods_id":"167","goods_sn":"11122d","goods_name":"五花肉 生鲜土猪肉 生猪肉","city_goods_price":"35.00","store_count":"10000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg"}]}
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
         * page : {"totalRows":"9","totalPages":"5","p":"1"}
         * list : [{"city_goods_id":"2","goods_id":"168","goods_sn":"343434111","goods_name":"精选肥牛卷 500g/盒 原切 谷饲牛肉","city_goods_price":"69.80","store_count":"2000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da8245ada3e6.jpg"},{"city_goods_id":"3","goods_id":"167","goods_sn":"11122d","goods_name":"五花肉 生鲜土猪肉 生猪肉","city_goods_price":"35.00","store_count":"10000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg"}]
         */

        private PageBean page;
        private List<ListBean> list;

        public PageBean getPage() {
            return page;
        }

        public void setPage(PageBean page) {
            this.page = page;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class PageBean {
            /**
             * totalRows : 9
             * totalPages : 5
             * p : 1
             */

            private String totalRows;
            private String totalPages;
            private String p;

            public String getTotalRows() {
                return totalRows;
            }

            public void setTotalRows(String totalRows) {
                this.totalRows = totalRows;
            }

            public String getTotalPages() {
                return totalPages;
            }

            public void setTotalPages(String totalPages) {
                this.totalPages = totalPages;
            }

            public String getP() {
                return p;
            }

            public void setP(String p) {
                this.p = p;
            }
        }

        public static class ListBean {
            /**
             * city_goods_id : 2
             * goods_id : 168
             * goods_sn : 343434111
             * goods_name : 精选肥牛卷 500g/盒 原切 谷饲牛肉
             * city_goods_price : 69.80
             * store_count : 2000
             * sales_sum : 0
             * store_name : 成都店铺1
             * store_id : 6
             * original_img : http://jshop.cc/Public/upload/goods/2019/10-17/5da8245ada3e6.jpg
             */

            private String city_goods_id;
            private String goods_id;
            private String goods_sn;
            private String goods_name;
            private String city_goods_price;
            private String store_count;
            private String sales_sum;
            private String store_name;
            private String store_id;
            private String original_img;

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
        }
    }
}
