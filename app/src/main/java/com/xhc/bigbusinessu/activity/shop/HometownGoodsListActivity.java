package com.xhc.bigbusinessu.activity.shop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.baidu.location.BDLocation;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.CityNameToIDEntity;
import com.xhc.bigbusinessu.Entity.GoodsClassifyEntity;
import com.xhc.bigbusinessu.Entity.GoodsListEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.HomeApi;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.adapter.HometownGoodsListAdapter;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.fragment.HomeFragment;
import com.xhc.bigbusinessu.utils.LocationUtils;
import com.zaaach.citypicker.CityPicker;
import com.zaaach.citypicker.adapter.OnPickListener;
import com.zaaach.citypicker.model.City;
import com.zaaach.citypicker.model.HotCity;
import com.zaaach.citypicker.model.LocateState;
import com.zaaach.citypicker.model.LocatedCity;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HometownGoodsListActivity extends BaseActivity {

    @BindView(R.id.list_view)
    RecyclerView listView;
    @BindView(R.id.h_list_view)
    RecyclerView hListView;
    @BindView(R.id.tv_city)
    TextView tvCity;

    HometownGoodsListAdapter adapter;

    List<GoodsListEntity.DataBean.ListBean> dataList;


    MyCategoryAdapter myCategoryAdapter;
    List<GoodsClassifyEntity.DataBean> categoryList;


    int viewType;
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_home_town_goods_list);
        //页面来源
        viewType = getIntent().getIntExtra("view_type",0);

    }

    @Override
    protected void initUI() {

        dataList = new ArrayList<>();
        adapter = new HometownGoodsListAdapter(R.layout.item_home_town_godos_list, dataList,viewType);

        GridLayoutManager manager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        listView.setLayoutManager(manager);
        listView.setAdapter(adapter);

        categoryList = new ArrayList<>();
        myCategoryAdapter = new MyCategoryAdapter(R.layout.item_category_text, categoryList);

        LinearLayoutManager manager1 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        hListView.setLayoutManager(manager1);
        hListView.setAdapter(myCategoryAdapter);

    }

    @Override
    protected void initData() {

        LocationUtils.getInstance().startLocationForText(location -> {

            if (location != null && !TextUtils.isEmpty(location.getCity())) {
                tvCity.setText(location.getCity());
            } else {
                tvCity.setText("请选择城市");
            }
        });
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

        getGoodsClassifyList(String.valueOf(viewType));
        getGoodsList(MyApplication.getInstance().getCityId(), "",String.valueOf(viewType));
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1003) {
            int subId = data.getIntExtra("subId", 0);
            getGoodsList(MyApplication.getInstance().getCityId(), subId + "",String.valueOf(viewType));
        }
    }

    @OnClick({R.id.lin_search, R.id.rel_back, R.id.lin_choose_city, R.id.tv_classify})
    public void onViewClicked(View v) {
        switch (v.getId()) {
            case R.id.lin_search:

                Bundle bundle = new Bundle();
                bundle.putInt("view_type", HomeFragment.MainViewType.BenDi);
                mystartActivity(SearchForGoodsActivity.class,bundle);

                break;

            case R.id.rel_back:
                goBack();
                break;

            case R.id.lin_choose_city:

                LocationUtils.getInstance().openCityChoose(this,tvCity);
                break;
            case R.id.tv_classify:
                Intent intent = new Intent(this, AllGoodsClassActivity.class);
                intent.putExtra("view_type", viewType);
                startActivityForResult(intent, 1001);
                break;

        }
    }

    private void getGoodsClassifyList(String type) {


        ShopApi.getInstance().getGoodsClassifyList(new BaseCallback<GoodsClassifyEntity>(GoodsClassifyEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(GoodsClassifyEntity response) {

                if (response.getStatus() == 1) {

                    categoryList.clear();
                    categoryList.addAll(response.getData());
                    myCategoryAdapter.notifyDataSetChanged();
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        },type);
    }

    private void getGoodsList(String city_id, String cat_id,String type) {

        showProgressDialog("获取中");
        ShopApi.getInstance().getGoodsList(new BaseCallback<GoodsListEntity>(GoodsListEntity.class) {
            @Override
            protected void onError(Exception e) {

                disProgressDialog();
                ToastMessage("网路异常");
            }

            @Override
            protected void onSuccess(GoodsListEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {

                    if (response.getData() != null) {

                        if (response.getData().getList() != null) {
                            dataList.clear();
                            dataList.addAll(response.getData().getList());
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, city_id, cat_id, "", "", "", "", "", "",type);
    }

    int chooseClassIndex = -1;

    class MyCategoryAdapter extends BaseQuickAdapter<GoodsClassifyEntity.DataBean, BaseViewHolder> {

        public MyCategoryAdapter(int layoutResId, @Nullable List<GoodsClassifyEntity.DataBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, GoodsClassifyEntity.DataBean item) {

            TextView tvTitle = helper.getView(R.id.tv_title);
            tvTitle.setText(item.getName());

            if (chooseClassIndex == helper.getAdapterPosition()) {
                tvTitle.setTextColor(Color.parseColor("#FFFFFF"));
                tvTitle.setBackgroundResource(R.drawable.shape_goods_categroy_tv_tag_bg);
            } else {
                tvTitle.setTextColor(Color.parseColor("#333333"));
                tvTitle.setBackgroundResource(0);
            }

            helper.itemView.setOnClickListener(view -> {
                if (chooseClassIndex == helper.getAdapterPosition()) {
                    chooseClassIndex = -1;
                    getGoodsList(MyApplication.getInstance().getCityId(), "",String.valueOf(viewType));
                    notifyDataSetChanged();
                } else {
                    chooseClassIndex = helper.getAdapterPosition();
                    getGoodsList(MyApplication.getInstance().getCityId(), item.getId(),String.valueOf(viewType));
                    notifyDataSetChanged();
                }


            });

        }
    }

}
