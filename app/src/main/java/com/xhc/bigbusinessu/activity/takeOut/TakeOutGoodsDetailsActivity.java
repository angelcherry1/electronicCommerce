package com.xhc.bigbusinessu.activity.takeOut;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.viewpager.widget.ViewPager;

import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;
import com.ms.banner.holder.BannerViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TakeOutGoodsDetailsActivity extends BaseActivity {


    @BindView(R.id.banner)
    Banner banner;


    private List<CustomData> mList;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_take_out_goods_details);
    }

    @Override
    protected void initUI() {

        showTitleBack();
    }

    @Override
    protected void initData() {
        mList = new ArrayList<>();
        mList.add(new CustomData("http://thumbs.dreamstime.com/b/%E5%AF%BC%E8%88%AA%E6%A6%82%E8%BF%B0-%E5%85%B8%E6%B1%89%E5%A0%A1%E5%8C%85%E7%9A%84%E4%BE%8B%E8%AF%81%E7%94%A8%E7%83%A4%E7%89%9B%E8%82%89%E3%80%81%E8%95%83%E8%8C%84%E3%80%81-%E8%8B%A3%E3%80%81%E8%91%B1%E5%92%8C%E5%9C%A8%E7%99%BD%E8%89%B2%E9%9A%94-%E7%9A%84%E8%8A%9D-%E7%B1%BD-83834225.jpg"));
        banner.setAutoPlay(true)
                .setOffscreenPageLimit(mList.size())
                .setPages(mList, new CustomViewHolder())
                .setBannerStyle(BannerConfig.CIRCLE_INDICATOR)
                .setDelayTime(2500)
                .setBannerAnimation(Transformer.Default)
                .start();
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }

    public class CustomViewHolder implements BannerViewHolder<CustomData> {
        @SuppressLint("InflateParams")
        @Override
        public View createView(Context context, int position, CustomData data) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item_take_out, null);
            ImageView img = view.findViewById(R.id.img);
            GlideUtils.loadImg(img, data.getUrl());
            return view;
        }
    }

    public class CustomData {

        private String url;

        public CustomData(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }
}
