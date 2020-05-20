package com.xhc.bigbusinessu.Entity;

import java.io.Serializable;
import java.util.List;

public class SureOrderInfoEntity {

    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"store_list":[{"store_id":"6","store_name":"成都店铺1","all_goods_price":"35.00","all_weight":500,"goods_list":[{"city_goods_id":"3","goods_id":"167","goods_name":"五花肉 生鲜土猪肉 生猪肉","city_goods_price":"35.00","weight":"500","store_count":"10000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg","buy_num":1}]},{"store_id":"9","store_name":"昆明店","all_goods_price":"186.00","all_weight":6000,"goods_list":[{"city_goods_id":"18","goods_id":"170","goods_name":"新奇士Sunkist澳洲一级脐橙 12粒澳橙 单果约140-190g 生鲜进口水果橙子","city_goods_price":"62.00","weight":"2000","store_count":"2000","sales_sum":"0","store_name":"昆明店","store_id":"9","original_img":"http://jshop.cc/Public/upload/goods/2019/10-22/5daeac37b6867.jpg","buy_num":3}]}],"all_price":"221.00"}
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

    public static class DataBean implements Serializable {
        /**
         * store_list : [{"store_id":"6","store_name":"成都店铺1","all_goods_price":"35.00","all_weight":500,"goods_list":[{"city_goods_id":"3","goods_id":"167","goods_name":"五花肉 生鲜土猪肉 生猪肉","city_goods_price":"35.00","weight":"500","store_count":"10000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg","buy_num":1}]},{"store_id":"9","store_name":"昆明店","all_goods_price":"186.00","all_weight":6000,"goods_list":[{"city_goods_id":"18","goods_id":"170","goods_name":"新奇士Sunkist澳洲一级脐橙 12粒澳橙 单果约140-190g 生鲜进口水果橙子","city_goods_price":"62.00","weight":"2000","store_count":"2000","sales_sum":"0","store_name":"昆明店","store_id":"9","original_img":"http://jshop.cc/Public/upload/goods/2019/10-22/5daeac37b6867.jpg","buy_num":3}]}]
         * all_price : 221.00
         */

        private String all_price;
        private String all_shipping_price;
        private List<StoreListBean> store_list;


        public String getAll_shipping_price() {
            return all_shipping_price;
        }

        public void setAll_shipping_price(String all_shipping_price) {
            this.all_shipping_price = all_shipping_price;
        }

        public String getAll_price() {
            return all_price;
        }

        public void setAll_price(String all_price) {
            this.all_price = all_price;
        }

        public List<StoreListBean> getStore_list() {
            return store_list;
        }

        public void setStore_list(List<StoreListBean> store_list) {
            this.store_list = store_list;
        }

        public static class StoreListBean implements Serializable{
            /**
             * store_id : 6
             * store_name : 成都店铺1
             * all_goods_price : 35.00
             * all_weight : 500
             * goods_list : [{"city_goods_id":"3","goods_id":"167","goods_name":"五花肉 生鲜土猪肉 生猪肉","city_goods_price":"35.00","weight":"500","store_count":"10000","sales_sum":"0","store_name":"成都店铺1","store_id":"6","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg","buy_num":1}]
             */

            private String store_id;
            private String store_name;
            private String all_goods_price;
            private int all_weight;
            private List<GoodsListBean> goods_list;

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

            public String getAll_goods_price() {
                return all_goods_price;
            }

            public void setAll_goods_price(String all_goods_price) {
                this.all_goods_price = all_goods_price;
            }

            public int getAll_weight() {
                return all_weight;
            }

            public void setAll_weight(int all_weight) {
                this.all_weight = all_weight;
            }

            public List<GoodsListBean> getGoods_list() {
                return goods_list;
            }

            public void setGoods_list(List<GoodsListBean> goods_list) {
                this.goods_list = goods_list;
            }

            public static class GoodsListBean implements Serializable{
                /**
                 * city_goods_id : 3
                 * goods_id : 167
                 * goods_name : 五花肉 生鲜土猪肉 生猪肉
                 * city_goods_price : 35.00
                 * weight : 500
                 * store_count : 10000
                 * sales_sum : 0
                 * store_name : 成都店铺1
                 * store_id : 6
                 * original_img : http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg
                 * buy_num : 1
                 */

                private String city_goods_id;
                private String goods_id;
                private String goods_name;
                private String city_goods_price;
                private String weight;
                private String store_count;
                private String sales_sum;
                private String store_name;
                private String store_id;
                private String original_img;
                private int buy_num;

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

                public int getBuy_num() {
                    return buy_num;
                }

                public void setBuy_num(int buy_num) {
                    this.buy_num = buy_num;
                }
            }
        }
    }
}
