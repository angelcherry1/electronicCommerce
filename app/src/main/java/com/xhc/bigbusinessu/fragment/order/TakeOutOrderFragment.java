package com.xhc.bigbusinessu.fragment.order;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.me.order.errands.ErrandsOrderDetailsActivity;
import com.xhc.bigbusinessu.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TakeOutOrderFragment extends BaseFragment {

    @BindView(R.id.list_view)
    RecyclerView listView;

    MyAdapter adapter;
    List<String> dataList;

    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_take_out_order);
    }

    @Override
    protected void initUI() {

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        adapter = new MyAdapter(R.layout.item_take_out_order_list, dataList);
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
                public void onClick(View v) {
                    mystartActivity(ErrandsOrderDetailsActivity.class);
                }
            });
        }
    }

}
