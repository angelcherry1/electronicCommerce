package com.xhc.bigbusinessu.fragment.ruralTourism;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class RuralTourismFragment extends BaseFragment {
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

        listView.setLayoutManager(new GridLayoutManager(getActivity(), 2, LinearLayoutManager.VERTICAL, false));
        dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        adapter = new MyAdapter(R.layout.item_rural_tourism, dataList);
        listView.setAdapter(adapter);

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

        }
    }

    @Override
    public void onResume() {
        super.onResume();
        int type = getArguments().getInt("type", 0);
        //getMyShopOrderList(type);
    }


}
