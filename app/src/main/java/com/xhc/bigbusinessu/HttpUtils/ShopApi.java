package com.xhc.bigbusinessu.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 商城相关API
 */
public class ShopApi {



    private static ShopApi instance = null;

    public static ShopApi getInstance() {
        if (instance == null) {
            synchronized (ShopApi.class) {
                if (instance == null) {
                    instance = new ShopApi();
                }
            }
        }
        return instance;
    }

    /**
     *  商品列表
     * @param baseCallback
     * @param city_id
     * @param cat_id
     * @param keyword
     * @param listRows
     * @param p
     * @param store_id
     * @param sort_type
     * @param sort
     */
    public  void getGoodsList(BaseCallback baseCallback,String city_id,String cat_id,String keyword,String listRows,String p,String store_id,String sort_type,String sort,String type){

//        city_id Y  城市ID
//        cat_id N  分类ID
//        keyword N  搜索关键词
//        listRows N 10 每页显示数量
//        p N 1 当前页码
//        store_id N  店铺ID
//        sort_type N 0 0默认，1新品，2销量，3价格
//        sort N 0 0降序，1升序

        Map<String, String> map = new HashMap<>();
        map.put("city_id", city_id);
        map.put("cat_id", cat_id);
        map.put("keyword", keyword);
        map.put("listRows", listRows);
        map.put("p", p);
        map.put("store_id", store_id);
        map.put("sort_type", sort_type);
        map.put("sort", sort);
        map.put("type", type);
        HttpUtils.getInstance().post(map, "/api/goods/goodsList", baseCallback);

    }



    /**
     *  店铺详情
     * @param baseCallback
     * @param store_id
     */
    public  void getShopDetails(BaseCallback baseCallback,String store_id){
//        store_id Y  店铺ID
        Map<String, String> map = new HashMap<>();
        map.put("store_id", store_id);
        HttpUtils.getInstance().post(map, "/api/store/info", baseCallback);
    }


    /**
     *  获取商品详情
     * @param baseCallback
     * @param city_goods_id
     * @param city_id
     */
    public void getGoodsDetails(BaseCallback baseCallback,String city_goods_id,String city_id){

        Map<String, String> map = new HashMap<>();
        map.put("city_goods_id", city_goods_id);
        map.put("city_id", city_id);
        HttpUtils.getInstance().post(map, "/api/goods/goodsInfo", baseCallback);
    }


    /**
     * 获取商品的分类
     * @param baseCallback
     */
    public void getGoodsClassifyList(BaseCallback baseCallback,String type){

        Map<String, String> map = new HashMap<>();
        map.put("type",type);
        HttpUtils.getInstance().post(map, "/api/goods/getAllCategory", baseCallback);
    }


    /**
     * 确认订单信息
     * @param baseCallback
     * @param city_goods_ids  城市商品Id数组
     * @param goods_nums  购买数量数组
     * @param goods_names 购买商品名称数组
     */
    public void sureOrderInfo(BaseCallback baseCallback,String city_goods_ids,String goods_nums,String goods_names){

        Map<String, String> map = new HashMap<>();
        map.put("city_goods_ids",city_goods_ids);
        map.put("goods_nums",goods_nums);
        map.put("goods_names",goods_names);
        HttpUtils.getInstance().post(map, "/api/order/sureInfo", baseCallback);
    }

    /**
     * 计算订单价格
     * @param baseCallback
     * @param city_goods_ids
     * @param goods_nums
     * @param goods_names
     * @param address_id
     */
    public void getOrderPrice(BaseCallback baseCallback,String city_goods_ids,String goods_nums,String goods_names,String address_id){

//        city_goods_ids Y  城市商品Id 多个商品用英文逗号“,”隔开 如1,2,3
//        goods_nums Y  购买数量 多个商品用英文逗号“,”隔开 如1,2,3
//        goods_names Y  购买商品名称 多个商品用英文逗号“,”隔开 如1,2,3
//        address_id Y  配送地址
        Map<String, String> map = new HashMap<>();
        map.put("city_goods_ids",city_goods_ids);
        map.put("goods_nums",goods_nums);
        map.put("goods_names",goods_names);
        map.put("address_id",address_id);
        HttpUtils.getInstance().post(map, "/api/order/getOrderPrice", baseCallback);
    }


    /**
     * 提交订单
     * @param baseCallback
     * @param city_goods_ids
     * @param goods_nums
     * @param goods_names
     * @param address_id
     */
    public void subOrder(BaseCallback baseCallback,String city_goods_ids,String goods_nums,String goods_names,String address_id,String user_note,String type,String pay_type){

//        city_goods_ids Y  城市商品Id 多个商品用英文逗号“,”隔开 如1,2,3
//        goods_nums Y  购买数量 多个商品用英文逗号“,”隔开 如1,2,3
//        goods_names Y  购买商品名称 多个商品用英文逗号“,”隔开 如1,2,3
//        address_id Y  配送地址
//        user_note N  用户给卖家留言 多个用英文逗号“,”隔开 如1,2,3
//        type N 0 购买方式：0立即购买，1购物车购买
//        pay_type N 0 支付方式：0微信支付，1支付宝支付

        Map<String, String> map = new HashMap<>();
        map.put("city_goods_ids",city_goods_ids);
        map.put("goods_nums",goods_nums);
        map.put("goods_names",goods_names);
        map.put("address_id",address_id);
        map.put("user_note",user_note);
        map.put("type",type);
        map.put("pay_type",pay_type);

        HttpUtils.getInstance().post(map, "/api/order/addOrder", baseCallback);
    }
//    用户订单列表

    public void getShopOrderList(BaseCallback baseCallback,String type,String keyword,String listRows,String p){

//        type N 0 订单类型订单类型，0全部，1待支付，2待发货，3待收货,4待评价，5已完成
//        keyword N  搜索商品/店铺关键字
//        listRows N 10 每页显示数量
//        p N 1 当前页码

        Map<String, String> map = new HashMap<>();
        map.put("type",type);
        map.put("keyword",keyword);
        map.put("listRows",listRows);
        map.put("p",p);

        HttpUtils.getInstance().post(map, "/api/user/orderList", baseCallback);
    }

    /**
     * 获取商品订单的详情
     * @param baseCallback
     * @param order_sn
     */
    public void getShopOrderDetails(BaseCallback baseCallback,String order_sn){

        Map<String, String> map = new HashMap<>();
        map.put("order_sn",order_sn);
        HttpUtils.getInstance().post(map, "/api/user/orderInfo", baseCallback);
    }

    /**
     * 取消订单
     * @param baseCallback
     * @param order_sn
     */
    public void cancelOrder(BaseCallback baseCallback,String order_sn){

        Map<String, String> map = new HashMap<>();
        map.put("order_sn",order_sn);
        HttpUtils.getInstance().post(map, "/api/order/cancelOrder", baseCallback);
    }

    /**
     * 删除订单
     * @param baseCallback
     * @param order_sn
     */
    public void delOrder(BaseCallback baseCallback,String order_sn){

        Map<String, String> map = new HashMap<>();
        map.put("order_sn",order_sn);
        HttpUtils.getInstance().post(map, "/api/order/delOrder", baseCallback);
    }

    /**
     * 确认收货
     * @param baseCallback
     * @param order_sn
     */
    public void confirmOrder(BaseCallback baseCallback,String order_sn){

        Map<String, String> map = new HashMap<>();
        map.put("order_sn",order_sn);
        HttpUtils.getInstance().post(map, "/api/order/confirmOrder", baseCallback);
    }

    /**
     * 微信统一下单
     * @param baseCallback
     * @param order_sn
     */
    public void getWxpayinfo(BaseCallback baseCallback,String order_sn){

        Map<String, String> map = new HashMap<>();
        map.put("order_sn",order_sn);
        HttpUtils.getInstance().post(map, "/api/order/getWxpayinfo", baseCallback);
    }
    /**
     * 支付宝统一下单
     * @param baseCallback
     * @param order_sn
     */
    public void getAlipayinfo(BaseCallback baseCallback,String order_sn){

        Map<String, String> map = new HashMap<>();
        map.put("order_sn",order_sn);
        HttpUtils.getInstance().post(map, "/api/order/getAlipayinfo", baseCallback);
    }

    public String getOrderStatus(int orderStatus){

        String statusStr;
        //order_status: 订单状态   1待支付，2待发货，3待收货,4(已收货)待评价，5已完成， 6已取消,7已作废
        switch (orderStatus){

            case 1:
                statusStr = "待支付";

                break;
            case 2:
                statusStr = "待发货";

                break;
            case 3:
                statusStr = "待收货";

                break;
            case 4:
                statusStr = "(已收货)待评价";

                break;
            case 5:
                statusStr = "已完成";

                break;
            case 6:
                statusStr = "已取消";

                break;
            case 7:
                statusStr = "已作废";

                break;
                default:
                    statusStr = "";
        }
        return statusStr;
    }

}
