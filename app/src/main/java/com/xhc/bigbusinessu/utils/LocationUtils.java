package com.xhc.bigbusinessu.utils;

import android.app.Activity;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.xhc.bigbusinessu.Entity.CityNameToIDEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.HomeApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.shop.HometownGoodsListActivity;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import java.util.ArrayList;
import java.util.List;

public class LocationUtils {


    private static LocationUtils instance;
    public LocationClient mLocationClient = null;
    private MyLocationListener myListener = new MyLocationListener();

    OnMyLocationListener onMyLocationListener;


    public LocationUtils() {


        mLocationClient = new LocationClient(MyApplication.getInstance());
        //声明LocationClient类
        mLocationClient.registerLocationListener(myListener);

        LocationClientOption option = new LocationClientOption();
        option.setIsNeedAddress(true);
        //可选，是否需要地址信息，默认为不需要，即参数为false
        //如果开发者需要获得当前点的地址信息，此处必须为true
        mLocationClient.setLocOption(option);
        //mLocationClient为第二步初始化过的LocationClient对象
        //需将配置好的LocationClientOption对象，通过setLocOption方法传递给LocationClient对象使用
        //更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
    }

    public synchronized static LocationUtils getInstance() {
        if (null == instance) {
            instance = new LocationUtils();
        }
        return instance;
    }


    private class MyLocationListener extends BDAbstractLocationListener {

        @Override
        public void onReceiveLocation(BDLocation location) {
            String addr = location.getAddrStr();    //获取详细地址信息
            String country = location.getCountry();    //获取国家
            String province = location.getProvince();    //获取省份
            String city = location.getCity();    //获取城市
            String district = location.getDistrict();    //获取区县
            String street = location.getStreet();    //获取街道信息

            Log.e("Test", "city:" + city);
            Log.e("Test", "activity:" + activity);
            if (activity != null) {
                CityPicker.from(activity).locateComplete(new LocatedCity(location.getCity(), location.getProvince(), location.getCityCode()), LocateState.SUCCESS);
                activity = null;//只用一次
            }

            if (onMyLocationListener != null) {
                HomeApi.getInstance().getCityIdByCityName(new BaseCallback<CityNameToIDEntity>(CityNameToIDEntity.class) {
                    @Override
                    protected void onError(Exception e) {

                    }
                    @Override
                    protected void onSuccess(CityNameToIDEntity response) {

                        if (response.getData() != null) {
                            if (response.getData().getCity_id() != null) {
                                MyApplication.getInstance().saveCityId(response.getData().getCity_id());
                                MyApplication.getInstance().saveCityName(response.getData().getCity_name());
                                onMyLocationListener.onLocationSuccess(location);
                            }
                        }
                    }
                }, location.getCity());

            }

            mLocationClient.stop();

        }
    }

    FragmentActivity activity;

    private void startLocationForDialog(FragmentActivity activity) {

        if (mLocationClient != null) {
            this.activity = activity;
            mLocationClient.start();
        }
    }


    public void startLocationForText(OnMyLocationListener onMyLocationListener) {

        if (mLocationClient != null) {
            this.onMyLocationListener = onMyLocationListener;
            mLocationClient.start();
        }
    }




    /**
     *
     * @param activity 界面
     * @param textView 需要显示位置的textView
     */
    public void openCityChoose(FragmentActivity activity, TextView textView) {

        List<HotCity> hotCities = new ArrayList<>();
        hotCities.add(new HotCity("北京", "北京", "101010100")); //code为城市代码
        hotCities.add(new HotCity("上海", "上海", "101020100"));
        hotCities.add(new HotCity("广州", "广东", "101280101"));
        hotCities.add(new HotCity("深圳", "广东", "101280601"));
        hotCities.add(new HotCity("杭州", "浙江", "101210101"));

        CityPicker.from(activity) //activity或者fragment
                .enableAnimation(true)    //启用动画效果，默认无
                .setAnimationStyle(R.style.DefaultCityPickerAnimation)    //自定义动画
                //.setLocatedCity(new LocatedCity("杭州", "浙江", "101210101"))  //APP自身已定位的城市，传null会自动定位（默认）
                .setHotCities(hotCities)    //指定热门城市
                .setOnPickListener(new OnPickListener() {
                    @Override
                    public void onPick(int position, City data) {

                        if (textView != null) {
                            textView.setText(data.getName());
                        }
                        HomeApi.getInstance().getCityIdByCityName(new BaseCallback<CityNameToIDEntity>(CityNameToIDEntity.class) {
                            @Override
                            protected void onError(Exception e) {

                            }

                            @Override
                            protected void onSuccess(CityNameToIDEntity response) {

                                if (response.getData() != null) {
                                    if (response.getData().getCity_id() != null) {
                                        MyApplication.getInstance().saveCityId(response.getData().getCity_id());
                                        MyApplication.getInstance().saveCityName(response.getData().getCity_name());
                                    }
                                }
                            }
                        }, data.getName());
                    }

                    @Override
                    public void onCancel() {
//                        Toast.makeText(getApplicationContext(), "取消选择", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLocate() {
//                        //定位接口，需要APP自身实现，这里模拟一下定位
                        LocationUtils.getInstance().startLocationForDialog(activity);

                    }
                })
                .show();
    }

    /**
     * 自定义回调
     */
    public interface OnMyLocationListener {

        void onLocationSuccess(BDLocation location);
    }
}
