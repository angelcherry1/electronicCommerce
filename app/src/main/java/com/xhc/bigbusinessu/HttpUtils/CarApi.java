package com.xhc.bigbusinessu.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 商城相关API
 */
public class CarApi {



    private static CarApi instance = null;

    public static CarApi getInstance() {
        if (instance == null) {
            synchronized (CarApi.class) {
                if (instance == null) {
                    instance = new CarApi();
                }
            }
        }
        return instance;
    }


    /**
     * 增加商品到购物车
     * @param baseCallback
     * @param city_goods_id
     * @param goods_num
     */
    public  void addCart(BaseCallback baseCallback,String city_goods_id,String goods_num){

//        city_goods_id Y  城市商品ID
//        goods_num Y  数量

        Map<String, String> map = new HashMap<>();
        map.put("city_goods_id", city_goods_id);
        map.put("goods_num", goods_num);
        HttpUtils.getInstance().post(map, "/api/cart/addCart", baseCallback);

    }


    /**
     * 获取购物车列表
     * @param baseCallback
     * @param city_id 城市id
     */
    public void getCartList(BaseCallback baseCallback,String city_id){
        Map<String, String> map = new HashMap<>();
        map.put("city_id", city_id);
        HttpUtils.getInstance().post(map, "/api/cart/cartList", baseCallback);
    }

    /**
     *  删除购物车的商品
     * @param baseCallback
     * @param ids
     */
    public void delCartGoods(BaseCallback baseCallback,String ids){

        Map<String, String> map = new HashMap<>();
        map.put("ids", ids);
        HttpUtils.getInstance().post(map, "/api/cart/delCart", baseCallback);
    }

    /**
     *  修改购物车商品的数量
     * @param baseCallback
     * @param
     */
    public void changeCartGoodsNum(BaseCallback baseCallback,String id,String city_goods_id,String goods_num){

//        id Y  ID
//        city_goods_id Y  城市商品ID
//        goods_num Y  数量

        Map<String, String> map = new HashMap<>();
        map.put("id", id);
        map.put("city_goods_id", city_goods_id);
        map.put("goods_num", goods_num);
        HttpUtils.getInstance().post(map, "/api/cart/editCart ", baseCallback);


    }
}
