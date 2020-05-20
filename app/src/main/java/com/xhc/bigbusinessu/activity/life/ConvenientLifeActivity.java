package com.xhc.bigbusinessu.activity.life;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;
import com.ms.banner.holder.BannerViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.life.push.LifePushNeedActivity;
import com.xhc.bigbusinessu.activity.life.push.LifePushSkillActivity;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ConvenientLifeActivity extends BaseActivity {

    Banner banner;

    LinearLayout linType1, linType2;
    TextView tvType1, tvType2;
    View vType1, vType2;

    @BindView(R.id.list_view)
    RecyclerView listView;
    List<MyBean> dataList;
    MyAdapter myAdapter;

    private List<CustomData> mList;

    LinearLayout linFun1, linFun2, linFun3, linFun4, linFun5, linFun6, linFun7, linFun8, linFun9, linFun10;


    int type = 1;


    @BindView(R.id.tv_push_xu)
    TextView tvPushXu;
    @BindView(R.id.tv_push_ji)
    TextView tvPushJi;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_convenient_life);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("便捷生活");

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = new ArrayList<>();

        dataList.add(new MyBean(1));
        dataList.add(new MyBean(1));
        dataList.add(new MyBean(1));
        dataList.add(new MyBean(1));
        dataList.add(new MyBean(1));

        myAdapter = new MyAdapter(dataList);


        listView.setAdapter(myAdapter);

        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.view_service_home_head, null, false);
        View footView = LayoutInflater.from(getActivity()).inflate(R.layout.view_list_view_nor_foot_60, null, false);
        banner = headView.findViewById(R.id.banner);
        linType1 = headView.findViewById(R.id.lin_type_1);
        linType2 = headView.findViewById(R.id.lin_type_2);
        tvType1 = headView.findViewById(R.id.tv_type_1);
        tvType2 = headView.findViewById(R.id.tv_type_2);
        vType1 = headView.findViewById(R.id.view_type_1);
        vType2 = headView.findViewById(R.id.view_type_2);

        linFun1 = headView.findViewById(R.id.lin_fun_1);
        linFun2 = headView.findViewById(R.id.lin_fun_2);
        linFun3 = headView.findViewById(R.id.lin_fun_3);
        linFun4 = headView.findViewById(R.id.lin_fun_4);
        linFun5 = headView.findViewById(R.id.lin_fun_5);
        linFun6 = headView.findViewById(R.id.lin_fun_6);
        linFun7 = headView.findViewById(R.id.lin_fun_7);
        linFun8 = headView.findViewById(R.id.lin_fun_8);
        linFun9 = headView.findViewById(R.id.lin_fun_9);
        linFun10 = headView.findViewById(R.id.lin_fun_10);

        myAdapter.addHeaderView(headView);
        myAdapter.addFooterView(footView);
    }

    @Override
    protected void initData() {

        mList = new ArrayList<>();
        mList.add(new CustomData("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1573015540973&di=405c8c7a675c8299f033e889ac611ffb&imgtype=0&src=http%3A%2F%2Fimg.zcool.cn%2Fcommunity%2F0183cb5859e975a8012060c82510f6.jpg"));
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

    }

    @Override
    protected void initEvent() {

        linType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvType1.setTextColor(Color.parseColor("#333333"));
                vType1.setVisibility(View.VISIBLE);

                tvType2.setTextColor(Color.parseColor("#999999"));
                vType2.setVisibility(View.INVISIBLE);
                type = 1;
                dataList.clear();
                dataList.add(new MyBean(1));
                dataList.add(new MyBean(1));
                dataList.add(new MyBean(1));
                dataList.add(new MyBean(1));
                dataList.add(new MyBean(1));
                myAdapter.notifyDataSetChanged();
            }
        });
        linType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvType2.setTextColor(Color.parseColor("#333333"));
                vType2.setVisibility(View.VISIBLE);

                tvType1.setTextColor(Color.parseColor("#999999"));
                vType1.setVisibility(View.INVISIBLE);
                type = 2;
                dataList.clear();
                dataList.add(new MyBean(2));
                dataList.add(new MyBean(2));
                dataList.add(new MyBean(2));
                dataList.add(new MyBean(2));
                dataList.add(new MyBean(2));
                myAdapter.notifyDataSetChanged();
            }
        });

        linFun1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });
        linFun9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(ConvenientLifeListActivity.class);
            }
        });

        linFun10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mystartActivity(AllLifeClassListActivity.class);
            }
        });

        //发布需求
        tvPushXu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mystartActivity(LifePushNeedActivity.class);
            }
        });
        //发布技能
        tvPushJi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mystartActivity(LifePushSkillActivity.class);
            }
        });
    }

    @Override
    protected void startFunction() {

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

    public class CustomData {

        private String url;

        public CustomData(String url) {
            this.url = url;
        }

        public String getUrl() {
            return url;
        }
    }


    class MyAdapter extends BaseMultiItemQuickAdapter<MyBean, BaseViewHolder> {


        public MyAdapter(List data) {
            super(data);
            addItemType(1, R.layout.item_service_home_1);
            addItemType(2, R.layout.item_service_home_2);
        }


        @Override
        protected void convert(BaseViewHolder helper, MyBean item) {

            switch (helper.getItemViewType()) {
                case 1:
                    //helper.setImageUrl(R.id.tv, item.getContent());
                    break;
                case 2:
                    //helper.setImageUrl(R.id.iv, item.getContent());
                    break;
                default:
                    break;
            }
        }

    }

    class MyBean implements MultiItemEntity {


        public MyBean(int viewType) {
            this.viewType = viewType;
        }

        public int viewType = 1;

        @Override
        public int getItemType() {
            return viewType;
        }
    }

}
