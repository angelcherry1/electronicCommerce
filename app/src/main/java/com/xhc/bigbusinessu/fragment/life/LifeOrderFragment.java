package com.xhc.bigbusinessu.fragment.life;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.ShopOrderListEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.life.order.LifeOrderDetailsActivity;
import com.xhc.bigbusinessu.activity.shop.ShopOrderDetailsActivity;
import com.xhc.bigbusinessu.base.BaseFragment;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class LifeOrderFragment extends BaseFragment {
    @BindView(R.id.list_view)
    RecyclerView listView;

    MyAdapter adapter;
    List<String> dataList;

    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_shop_goods_order);
    }

    @Override
    protected void initUI() {

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = new ArrayList<>();
        dataList.add("123");
        dataList.add("123");
        dataList.add("123");
        adapter = new MyAdapter(R.layout.item_life_order, dataList);
        listView.setAdapter(adapter);
        adapter.setEmptyView(R.layout.view_list_order_empty, listView);

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

    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mystartActivity(LifeOrderDetailsActivity.class);
                }
            });
        }
    }


}
