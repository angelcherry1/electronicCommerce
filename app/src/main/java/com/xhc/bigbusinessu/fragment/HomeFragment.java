package com.xhc.bigbusinessu.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.baidu.location.BDLocation;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;
import com.ms.banner.holder.BannerViewHolder;
import com.tuhualong.policylibrary.Policy;
import com.xhc.bigbusinessu.Entity.HomeDataEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.HomeApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.errands.ErrandsHomeActivity;
import com.xhc.bigbusinessu.activity.hotel.HotelMainActivity;
import com.xhc.bigbusinessu.activity.life.ConvenientLifeActivity;
import com.xhc.bigbusinessu.activity.ruralTourism.RuralTourismActivity;
import com.xhc.bigbusinessu.activity.shop.HometownGoodsListActivity;
import com.xhc.bigbusinessu.activity.takeOut.TakeOutHomeActivity;
import com.xhc.bigbusinessu.adapter.HomeAdapter;
import com.xhc.bigbusinessu.base.BaseFragment;
import com.xhc.bigbusinessu.utils.GlideUtils;
import com.xhc.bigbusinessu.utils.LocationUtils;
import com.xhc.bigbusinessu.view.MyRecyclerView;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static androidx.recyclerview.widget.RecyclerView.VERTICAL;

/**
 * Created by XXW on 2018/8/19.
 * 首页
 */

public class HomeFragment extends BaseFragment {

    @BindView(R.id.list_view)
    RecyclerView listView;

    @BindView(R.id.lin_location)
    LinearLayout linLocation;
    @BindView(R.id.tv_location)
    TextView tvLocation;


    HomeAdapter homeAdapter;
    List<HomeDataEntity.DataBean.RecommendBean> data;

    private List<CustomData> mList;

    LinearLayout mLinBtn1, mLinBtn2, mLinBtn3, mLinBtn4, mLinBtn5, mLinBtn6, mLinBtn7, mLinBtn8, mLinBtn9, mLinBtn10;
    Banner banner;


    private String text = "欢迎使用XX应用！我们将通过XXXXXX《用户协议》和《隐私政策》帮助您了解我们收集、使用、存储和共享个人信息的情况，以及您所享有的相关权利。\n\n" +
            "• 为了向您提供XX音频文件生成存储、头像上传、用户注册等功能服务，我们需要使用您的一些存储权限、音视频录制权限、相机权限、获取设备信息等权限及信息。\n" +
            "• 您可以在个人中心修改、更正您的信息，也可以自己注销账户。\n" +
            "• 我们会采用业界领先的安全技术保护好您的个人信息。\n\n" +
            "您可以通过阅读完整版用户隐私政策，了解个人信息类型与用途的对应关系等更加详尽的个人信息处理规则。\n" +
            "如您同意，请点击“同意”开始接受我们的服务。";

    public class MainViewType {
        public static final int TeSe = 1;//特色家乡
        public static final int ChengXiang = 2;//城乡优购
        public static final int HuiYuan = 3;//会员商家
        public static final int BenDi = 4;//本地商城
    }


    @Override
    protected void setContentView() {
        setContentView(R.layout.frag_tab_home);
    }

    @Override
    protected void initUI() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(VERTICAL);
        listView.setLayoutManager(layoutManager);

        data = new ArrayList<>();
        homeAdapter = new HomeAdapter(R.layout.item_tab_home, data);
        listView.setAdapter(homeAdapter);


        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.head_tab_home_view, null, false);
        homeAdapter.addHeaderView(headView);
        banner = headView.findViewById(R.id.banner);
        mLinBtn1 = headView.findViewById(R.id.lin_fun_1);
        mLinBtn2 = headView.findViewById(R.id.lin_fun_2);
        mLinBtn3 = headView.findViewById(R.id.lin_fun_3);
        mLinBtn4 = headView.findViewById(R.id.lin_fun_4);
        mLinBtn5 = headView.findViewById(R.id.lin_fun_5);
        mLinBtn6 = headView.findViewById(R.id.lin_fun_6);
        mLinBtn7 = headView.findViewById(R.id.lin_fun_7);
        mLinBtn8 = headView.findViewById(R.id.lin_fun_8);
        mLinBtn9 = headView.findViewById(R.id.lin_fun_9);
        mLinBtn10 = headView.findViewById(R.id.lin_fun_10);


        mList = new ArrayList<>();
        banner.setAutoPlay(true)
                .setOffscreenPageLimit(mList.size())
                .setPages(mList, new CustomViewHolder())
                .setBannerStyle(BannerConfig.NOT_INDICATOR)
                .setBannerAnimation(Transformer.Scale)
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


        Policy.getInstance().showRuleDialog(getActivity(), "用户协议和隐私政策概要", text, R.color.link, new Policy.RuleListener() {
            @Override
            public void rule(boolean agree) {

            }

            @Override
            public void oneClick() {

            }

            @Override
            public void twoClick() {

            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    protected void initData() {
        addListener();
        getLocation();
    }

    private void addListener() {

    }

    @Override
    protected void initEvent() {

        mLinBtn1.setOnClickListener(view -> {

            mystartActivity(ErrandsHomeActivity.class);
        });
        mLinBtn2.setOnClickListener(view -> {

            Bundle bundle = new Bundle();
            bundle.putInt("view_type", MainViewType.TeSe);
            mystartActivity(HometownGoodsListActivity.class, bundle);
        });
        mLinBtn3.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("view_type", MainViewType.ChengXiang);
            mystartActivity(HometownGoodsListActivity.class, bundle);
        });
        mLinBtn4.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("view_type", MainViewType.HuiYuan);
            mystartActivity(HometownGoodsListActivity.class, bundle);
        });
        mLinBtn5.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putInt("view_type", MainViewType.BenDi);
            mystartActivity(HometownGoodsListActivity.class, bundle);
        });
        mLinBtn6.setOnClickListener(view -> {
            //酒店住宿
            mystartActivity(HotelMainActivity.class);
        });
        mLinBtn7.setOnClickListener(view -> {
            mystartActivity(RuralTourismActivity.class);
        });
        mLinBtn8.setOnClickListener(view -> {

            mystartActivity(TakeOutHomeActivity.class);

        });
        mLinBtn9.setOnClickListener(view -> {

        });
        mLinBtn10.setOnClickListener(view -> {
            mystartActivity(ConvenientLifeActivity.class);
        });


        linLocation.setOnClickListener(view -> {

            LocationUtils.getInstance().openCityChoose(getActivity(), tvLocation);
        });
    }


    @Override
    protected void startFunction() {


    }


    private void getHomeData(String city_id) {

        HomeApi.getInstance().getHomeData(new BaseCallback<HomeDataEntity>(HomeDataEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(HomeDataEntity response) {

                if (response.getStatus() == 1) {

                    if (response.getData() != null) {

                        if (response.getData().getAd() != null) {

                            mList.clear();
                            for (HomeDataEntity.DataBean.AdBean adBean : response.getData().getAd()) {
                                mList.add(new CustomData(adBean.getAd_code()));
                            }
                            banner.update(mList);


                        }

                        if (response.getData().getRecommend() != null) {
                            data.clear();
                            data.addAll(response.getData().getRecommend());
                            homeAdapter.notifyDataSetChanged();
                        }
                    } else {

                        ToastMessage("数据异常");
                    }

                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, city_id);
    }

    public class CustomViewHolder implements BannerViewHolder<CustomData> {

        @SuppressLint("InflateParams")
        @Override
        public View createView(Context context, int position, CustomData data) {
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item, null);
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

    public void getLocation() {

        LocationUtils.getInstance().startLocationForText(location -> {

            Log.e("Test", "location:" + location);
            if (location != null && !TextUtils.isEmpty(location.getCity())) {

                String cityCode = location.getCityCode();
                Log.e("Test", "cityCode:" + cityCode);
                tvLocation.setText(location.getCity());
                getHomeData(MyApplication.getInstance().getCityId());

            } else {
                tvLocation.setText("请选择城市");
            }
        });
    }

}
