package com.xhc.bigbusinessu.Entity;

import java.util.List;

public class HomeDataEntity {

    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"ad":[{"ad_link":"","ad_name":"广告1","ad_code":"http://jshop.cc/Public/upload/ad/2019/10-16/5da67c8ad9114.jpg"},{"ad_link":"","ad_name":"广告2","ad_code":"http://jshop.cc/Public/upload/ad/2019/10-21/5dad616a2902b.jpg"}],"recommend":[{"store_id":"6","store_name":"成都店铺1","recommend_goods":[{"city_goods_id":"7","goods_sn":"fawef","goods_name":"休闲零食小吃夹心海苔海味即食芝麻海芝脆36g/袋","city_goods_price":"30.80","store_count":"3000","sales_sum":"0","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da8210cbd183.jpg"},{"city_goods_id":"5","goods_sn":"4353eww","goods_name":"金针菇 蘑菇 菌菇 约400g 火锅烧烤食材 新鲜蔬菜","city_goods_price":"14.90","store_count":"7000","sales_sum":"0","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da82269ccf48.jpg"},{"city_goods_id":"3","goods_sn":"11122d","goods_name":"五花肉 生鲜土猪肉 生猪肉","city_goods_price":"35.00","store_count":"10000","sales_sum":"0","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg"}]}]}
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
        private List<AdBean> ad;
        private List<RecommendBean> recommend;

        public List<AdBean> getAd() {
            return ad;
        }

        public void setAd(List<AdBean> ad) {
            this.ad = ad;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

        public static class AdBean {
            /**
             * ad_link :
             * ad_name : 广告1
             * ad_code : http://jshop.cc/Public/upload/ad/2019/10-16/5da67c8ad9114.jpg
             */

            private String ad_link;
            private String ad_name;
            private String ad_code;

            public String getAd_link() {
                return ad_link;
            }

            public void setAd_link(String ad_link) {
                this.ad_link = ad_link;
            }

            public String getAd_name() {
                return ad_name;
            }

            public void setAd_name(String ad_name) {
                this.ad_name = ad_name;
            }

            public String getAd_code() {
                return ad_code;
            }

            public void setAd_code(String ad_code) {
                this.ad_code = ad_code;
            }
        }

        public static class RecommendBean {
            /**
             * store_id : 6
             * store_name : 成都店铺1
             * recommend_goods : [{"city_goods_id":"7","goods_sn":"fawef","goods_name":"休闲零食小吃夹心海苔海味即食芝麻海芝脆36g/袋","city_goods_price":"30.80","store_count":"3000","sales_sum":"0","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da8210cbd183.jpg"},{"city_goods_id":"5","goods_sn":"4353eww","goods_name":"金针菇 蘑菇 菌菇 约400g 火锅烧烤食材 新鲜蔬菜","city_goods_price":"14.90","store_count":"7000","sales_sum":"0","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da82269ccf48.jpg"},{"city_goods_id":"3","goods_sn":"11122d","goods_name":"五花肉 生鲜土猪肉 生猪肉","city_goods_price":"35.00","store_count":"10000","sales_sum":"0","original_img":"http://jshop.cc/Public/upload/goods/2019/10-17/5da823c1d6e2e.jpg"}]
             */

            private String store_id;
            private String store_name;
            private List<RecommendGoodsBean> recommend_goods;

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

            public List<RecommendGoodsBean> getRecommend_goods() {
                return recommend_goods;
            }

            public void setRecommend_goods(List<RecommendGoodsBean> recommend_goods) {
                this.recommend_goods = recommend_goods;
            }

            public static class RecommendGoodsBean {
                /**
                 * city_goods_id : 7
                 * goods_sn : fawef
                 * goods_name : 休闲零食小吃夹心海苔海味即食芝麻海芝脆36g/袋
                 * city_goods_price : 30.80
                 * store_count : 3000
                 * sales_sum : 0
                 * original_img : http://jshop.cc/Public/upload/goods/2019/10-17/5da8210cbd183.jpg
                 */

                private String city_goods_id;
                private String goods_sn;
                private String goods_name;
                private String city_goods_price;
                private String store_count;
                private String sales_sum;
                private String original_img;

                public String getCity_goods_id() {
                    return city_goods_id;
                }

                public void setCity_goods_id(String city_goods_id) {
                    this.city_goods_id = city_goods_id;
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

                public String getOriginal_img() {
                    return original_img;
                }

                public void setOriginal_img(String original_img) {
                    this.original_img = original_img;
                }
            }
        }
    }
}
