package com.xhc.bigbusinessu.activity.me.order.takeOut;

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
import com.xhc.bigbusinessu.fragment.order.ErrandsOrderFragment;
import com.xhc.bigbusinessu.fragment.order.TakeOutOrderFragment;

public class AllTakeoutOrderActivity extends BaseActivity {

    private static final String[] CHANNELS = new String[]{"全部", "待付款", "待使用", "待评价", "退款"};

    private IndicatorViewPager indicatorViewPager;
    private LayoutInflater inflate;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_all_take_out_order);

    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("外卖订单");

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
            TakeOutOrderFragment mainFragment = new TakeOutOrderFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("type", position);
            mainFragment.setArguments(bundle);
            return mainFragment;
        }


    }
}
