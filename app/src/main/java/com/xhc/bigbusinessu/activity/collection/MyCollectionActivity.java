package com.xhc.bigbusinessu.activity.collection;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.fragment.collection.GoodsCollectionFragment;
import com.xhc.bigbusinessu.fragment.collection.ShopCollectionFragment;
import com.xhc.bigbusinessu.fragment.order.ShopGoodsOrderFragment;

import java.util.ArrayList;
import java.util.List;

public class MyCollectionActivity extends BaseActivity {

    private static final String[] CHANNELS = new String[]{"商品", "店铺"};
    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;

    List<Fragment> fragmentList = new ArrayList<>();

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_my_collection);

    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("收藏");
        setTitleRightText("管理", view -> {

        });

        ViewPager viewPager = findViewById(R.id.fragment_tabmain_viewPager);
        Indicator indicator = findViewById(R.id.fragment_tabmain_indicator);
        indicator.setScrollBar(new ColorBar(getApplicationContext(), Color.parseColor("#FFB333"), 3));

        float unSelectSize = 16;
        float selectSize = unSelectSize * 1.0f;
        indicator.setOnTransitionListener(new OnTransitionTextListener().setColor(Color.parseColor("#333333"), Color.parseColor("#333333")).setSize(selectSize, unSelectSize));

        viewPager.setOffscreenPageLimit(4);

        indicatorViewPager = new IndicatorViewPager(indicator, viewPager);
        inflate = LayoutInflater.from(getApplicationContext());
        // 注意这里 的FragmentManager 是 getChildFragmentManager(); 因为是在Fragment里面
        // 而在activity里面用FragmentManager 是 getSupportFragmentManager()
        indicatorViewPager.setAdapter(new MyAdapter(getSupportFragmentManager()));


        fragmentList.add(new GoodsCollectionFragment());
        fragmentList.add(new ShopCollectionFragment());
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

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
            Fragment fragment = fragmentList.get(position);
            Bundle bundle = new Bundle();
            bundle.putInt("type", position);
            fragment.setArguments(bundle);
            return fragment;
        }


    }
}