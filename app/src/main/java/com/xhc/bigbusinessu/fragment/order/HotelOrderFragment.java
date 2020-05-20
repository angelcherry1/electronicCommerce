package com.xhc.bigbusinessu.fragment.order;

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
import com.xhc.bigbusinessu.activity.me.order.hotel.HotelOrderDetailsActivity;
import com.xhc.bigbusinessu.activity.shop.ShopOrderDetailsActivity;
import com.xhc.bigbusinessu.base.BaseFragment;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class HotelOrderFragment extends BaseFragment {

    @BindView(R.id.list_view)
    RecyclerView listView;


    MyAdapter adapter;
    List<String> dataList;

    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_hotel_order);
    }

    @Override
    protected void initUI() {

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        adapter = new MyAdapter(R.layout.item_hotel_order, dataList);
        listView.setAdapter(adapter);
        adapter.setEmptyView(R.layout.view_list_order_empty, listView);

    }

    @Override
    protected void initData() {

//        int type = getArguments().getInt("type", 0);
//        getMyShopOrderList(type);
//        setTypeData(type);
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
                    mystartActivity(HotelOrderDetailsActivity.class);
                }
            });

        }
    }


}
