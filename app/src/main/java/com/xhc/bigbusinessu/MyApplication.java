package com.xhc.bigbusinessu;

import android.app.Application;
import android.content.SharedPreferences;
import android.text.TextUtils;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.xhc.bigbusinessu.utils.SharedPreferencesUtils;

/**
 * Created by XXW on 2018/5/10.
 */

public class MyApplication  extends Application {

    private static MyApplication instance;

    public final static String APP_ID = "wxfae2440f97a3738a";

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        SDKInitializer.initialize(this);
        //自4.3.0起，百度地图SDK所有接口均支持百度坐标和国测局坐标，用此方法设置您使用的坐标类型.
        //包括BD09LL和GCJ02两种坐标，默认是BD09LL坐标。
        SDKInitializer.setCoordType(CoordType.BD09LL);
    }

    public synchronized static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }




    public void saveToken(String token){
        SharedPreferencesUtils.setParam("token",token);
    }
    public String getToken(){
        return (String) SharedPreferencesUtils.getParam("token","");
    }

    public void saveUserId(String userId){
        SharedPreferencesUtils.setParam("userId",userId);
    }
    public String getUserId(){
        return (String) SharedPreferencesUtils.getParam("userId","");

    }


    /**
     * 用户是否登录
     * @return
     */
    public boolean isLogin(){
        if(TextUtils.isEmpty(getToken()) || TextUtils.isEmpty(getUserId())){
            return false;
        }
        return true;
    }


    public String getCityId(){
        return (String) SharedPreferencesUtils.getParam("cityId","");
    }

    public void saveCityId(String cityId){
        SharedPreferencesUtils.setParam("cityId",cityId);
    }


    public String getCityName(){
        return (String) SharedPreferencesUtils.getParam("cityName","请选择位置");
    }

    public void saveCityName(String saveCityName){
        SharedPreferencesUtils.setParam("cityName",saveCityName);
    }

    /**
     * 退出登录
     */
    public void logout(){
        saveToken("");
        saveUserId("");
    }
}
