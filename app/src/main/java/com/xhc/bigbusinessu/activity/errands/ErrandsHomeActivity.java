package com.xhc.bigbusinessu.activity.errands;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.baidu.location.BDLocation;
import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.BitmapDescriptor;
import com.baidu.mapapi.map.BitmapDescriptorFactory;
import com.baidu.mapapi.map.InfoWindow;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationConfiguration;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.me.order.shop.AllShopOrderActivity;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.fragment.errandsHome.ErrandsHomeFragment1;
import com.xhc.bigbusinessu.fragment.errandsHome.ErrandsHomeFragment2;
import com.xhc.bigbusinessu.fragment.errandsHome.ErrandsHomeFragment3;
import com.xhc.bigbusinessu.fragment.order.ShopGoodsOrderFragment;
import com.xhc.bigbusinessu.utils.LocationUtils;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ErrandsHomeActivity extends BaseActivity {

    MapView mMapView = null;
    BaiduMap mBaiduMap;

    MyLocationData locData;
    BitmapDescriptor mCurrentMarker;


    private static final String[] CHANNELS = new String[]{"帮我送", "帮我取", "帮我买"};

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;

    List<Fragment> fragmentList = new ArrayList<>();
    @Override
    protected void setContentView() {


        setContentView(R.layout.aty_errands_home);
        mMapView = findViewById(R.id.map_view);

        fragmentList.add(new ErrandsHomeFragment1());
        fragmentList.add(new ErrandsHomeFragment2());
        fragmentList.add(new ErrandsHomeFragment3());
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("快递跑腿");

        mBaiduMap = mMapView.getMap();
        mBaiduMap.setMyLocationEnabled(true);

        mCurrentMarker = BitmapDescriptorFactory.fromResource(R.mipmap.icon_location_my);
        MyLocationConfiguration mLocationConfiguration = new MyLocationConfiguration(MyLocationConfiguration.LocationMode.NORMAL, true, mCurrentMarker, 0XFFB333, 0X60FFB333);
        mBaiduMap.setMyLocationConfiguration(mLocationConfiguration);


        ViewPager viewPager = findViewById(R.id.fragment_tabmain_viewPager);
        Indicator indicator = findViewById(R.id.fragment_tabmain_indicator);
        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.parseColor("#FFB333"), 3));

        float unSelectSize = 16;
        float selectSize = unSelectSize * 1.0f;
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.parseColor("#FFB333"), Color.parseColor("#333333")).setSize(selectSize, unSelectSize));

        viewPager.setOffscreenPageLimit(4);

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        // 注意这里 的FragmentManager 是 getChildFragmentManager(); 因为是在Fragment里面
        // 而在activity里面用FragmentManager 是 getSupportFragmentManager()
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

        LocationUtils.getInstance().startLocationForText(location -> {

            locData = new MyLocationData.Builder()
                    .accuracy(location.getRadius())
                    // 此处设置开发者获取到的方向信息，顺时针0-360
                    .direction(location.getDirection()).latitude(location.getLatitude())
                    .longitude(location.getLongitude()).build();

            mBaiduMap.setMyLocationData(locData);

            LatLng ll = new LatLng(location.getLatitude(),
                    location.getLongitude());
            MapStatus.Builder builder = new MapStatus.Builder();
            builder.target(ll).zoom(18.0f);
            mBaiduMap.animateMapStatus(MapStatusUpdateFactory.newMapStatus(builder.build()));

            //用来构造InfoWindow的Button
            TextView button = new TextView(getApplicationContext());
            button.setBackgroundResource(R.mipmap.icon_map_info_dialog_bg);
            button.setText("InfoWindow");
            button.setTextSize(14);
            button.setGravity(Gravity.CENTER);
            button.setTextColor(Color.parseColor("#333333"));

            //构造InfoWindow
            //point 描述的位置点
            //-100 InfoWindow相对于point在y轴的偏移量
            InfoWindow mInfoWindow = new InfoWindow(button, new LatLng(location.getLatitude(), location.getLongitude()), -50);
            //使InfoWindow生效
            mBaiduMap.showInfoWindow(mInfoWindow);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }

    private class MyAdapter extends IndicatorViewPager.IndicatorFragmentPagerAdapter {

        public MyAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override
        public int getCount() {
            return CHANNELS.length;
        }

        @Override
        public View getViewForTab(int position, View convertView, ViewGroup container) {
            if (convertView == null) {
                convertView = inflate.inflate(R.layout.tab_top, container, false);
            }
            TextView textView = (TextView) convertView;
            textView.setText(CHANNELS[position]);
            return convertView;
        }

        @Override
        public Fragment getFragmentForPage(int position) {

            Bundle bundle = new Bundle();
            bundle.putInt("type", position);
            fragmentList.get(position).setArguments(bundle);
            return fragmentList.get(position);
        }


    }
}
