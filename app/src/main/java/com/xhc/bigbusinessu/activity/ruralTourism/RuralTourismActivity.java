package com.xhc.bigbusinessu.activity.ruralTourism;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;
import com.ms.banner.holder.BannerViewHolder;
import com.shizhefei.view.indicator.Indicator;
import com.shizhefei.view.indicator.IndicatorViewPager;
import com.shizhefei.view.indicator.slidebar.ColorBar;
import com.shizhefei.view.indicator.transition.OnTransitionTextListener;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.life.ConvenientLifeActivity;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.fragment.ruralTourism.RuralTourismFragment;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * 乡村旅游
 */
public class RuralTourismActivity extends BaseActivity {


    @BindView(R.id.list_view)
    RecyclerView listView;
    MyAdapter adapter;

    List<String> dataList;

    Banner banner;
    private List<CustomData> mList;




    RecyclerView hListView;
    TitleAdapter titleAdapter;
    List<String> titleList = new ArrayList<>();

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_rural_tourism);

    }

    @Override
    protected void initUI() {

        listView.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));

    }

    @Override
    protected void initData() {

        dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        adapter = new MyAdapter(R.layout.item_rural_tourism, dataList);
        listView.setAdapter(adapter);

        View headView = LayoutInflater.from(this).inflate(R.layout.view_rural_tourism_head,null,false);
        adapter.addHeaderView(headView);
        banner = headView.findViewById(R.id.banner);
        hListView = headView.findViewById(R.id.h_list_view);

        mList = new ArrayList<>();
        mList.add(new CustomData("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573015540971&di=7059340c3105e5705be80df79eb81113&imgtype=0&src=http%3A%2F%2Fhbimg.b0.upaiyun.com%2F8c2a0d13b152d1c55f9f5642578ca2b92ee0da848e9f-VpMnCL_fw658"));
        mList.add(new CustomData("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573015540971&di=3780378755d1dd7a10406d5a46969041&imgtype=0&src=http%3A%2F%2Fpic25.nipic.com%2F20121114%2F8115219_221201296000_2.jpg"));
        mList.add(new CustomData("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573015540971&di=2d0f88640be0d0bb39a77f976a9eb4aa&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0118cf5837d75ea801219c77f35e67.jpg"));
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

        titleList.add("推荐");
        titleList.add("亲子同游");
        titleList.add("陪爸妈");
        titleList.add("拍照");
        titleList.add("自驾游");
        hListView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        titleAdapter = new TitleAdapter(R.layout.item_rural_tourism_title,titleList);
        hListView.setAdapter(titleAdapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }


    @OnClick({R.id.lin_title_left})
    public void onClicked(View v){
        switch (v.getId()){

            case R.id.lin_title_left:
                finish();
                break;
        }
    }

    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mystartActivity(RuralTourismDetailsActivity.class);
                }
            });
        }
    }

    int chooseTitle;
    class TitleAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public TitleAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            TextView tvTitle = helper.getView(R.id.tv_title);
            tvTitle.setText(item);
            int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
            tvTitle.measure(w, h);
            int width = tvTitle.getMeasuredWidth();

            View viewBottom = helper.getView(R.id.view_bottom);
            viewBottom.setMinimumWidth(width);
            if(helper.getAdapterPosition() == chooseTitle){
                viewBottom.setVisibility(View.VISIBLE);
            }else{
                viewBottom.setVisibility(View.INVISIBLE);
            }
            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chooseTitle = helper.getAdapterPosition();
                    notifyDataSetChanged();
                }
            });

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
    public class CustomViewHolder implements BannerViewHolder<CustomData> {

        @SuppressLint("InflateParams")
        @Override
        public View createView(Context context, int position, CustomData data) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item_2, null);
            ImageView img = view.findViewById(R.id.img);
            GlideUtils.loadImg(img, data.getUrl());
            return view;
        }

    }

}
