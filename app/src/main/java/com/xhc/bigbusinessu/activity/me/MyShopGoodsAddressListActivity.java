package com.xhc.bigbusinessu.activity.me;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.MShopAddressListEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MyShopGoodsAddressListActivity extends BaseActivity {


    @BindView(R.id.list_view)
    RecyclerView listView;
    MyAdapter myAdapter;
    List<MShopAddressListEntity.DataBean> dataList;

    Boolean isSelect;
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_my_shop_goods_address_list);
        isSelect = getIntent().getBooleanExtra("is_select",false);
    }

    @Override
    protected void initUI() {
        showTitleBack();
        setTitleText("我的地址");
        setTitleRightText("添加新收货地址", view -> {
            mystartActivity(AddNewShopGoodsAddressActivity.class);
        });

        listView.setLayoutManager(new LinearLayoutManager(this));

        dataList = new ArrayList<>();

        myAdapter = new MyAdapter(R.layout.item_my_shop_goods_address_list, dataList);
        listView.setAdapter(myAdapter);
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

    @Override
    protected void onResume() {
        super.onResume();
        UserApi.getInstance().getMyShopList(new BaseCallback<MShopAddressListEntity>(MShopAddressListEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(MShopAddressListEntity response) {

                if(response.getData()!=null){
                    dataList.clear();
                    dataList.addAll(response.getData());
                    myAdapter.notifyDataSetChanged();
                }
            }
        });
    }

    class MyAdapter extends BaseQuickAdapter<MShopAddressListEntity.DataBean, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<MShopAddressListEntity.DataBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, MShopAddressListEntity.DataBean item) {

            helper.setText(R.id.tv_consignee, item.getConsignee());
            helper.setText(R.id.tv_mobile, item.getMobile());
            helper.setText(R.id.tv_address, item.getProvince_name() + item.getCity_name() + item.getDistrict_name() + item.getAddress());

            helper.getView(R.id.lin_edit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("bean",item);
                    mystartActivity(AddNewShopGoodsAddressActivity.class,bundle);
                }
            });
            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(isSelect){
                        Intent intent = new Intent();
                        intent.putExtra("address_bean",item);
                        setResult(1003,intent);
                        finish();
                    }
                }
            });
        }
    }
}
