package com.xhc.bigbusinessu.HttpUtils;

import android.text.TextUtils;

import com.xhc.bigbusinessu.utils.MD5Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class HomeApi {



    private static HomeApi instance = null;

    public static HomeApi getInstance() {
        if (instance == null) {
            synchronized (HomeApi.class) {
                if (instance == null) {
                    instance = new HomeApi();
                }
            }
        }
        return instance;
    }

    /**
     * 首页数据
     * @param baseCallback
     * @param city_id
     */
    public  void getHomeData(BaseCallback baseCallback,String city_id){

        Map<String, String> map = new HashMap<>();
        map.put("city_id", "33008");
        HttpUtils.getInstance().post(map, "/api/index/home", baseCallback);

    }

    /**
     *
     * @param baseCallback
     * @param cityName
     */
    public void  getCityIdByCityName(BaseCallback baseCallback,String cityName){

        Map<String, String> map = new HashMap<>();
        map.put("city_name", "成都");
        HttpUtils.getInstance().post(map, "/api/index/getCityIdByCityname", baseCallback);
    }


}
