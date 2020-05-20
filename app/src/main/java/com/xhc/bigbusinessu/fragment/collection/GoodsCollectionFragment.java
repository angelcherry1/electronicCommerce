package com.xhc.bigbusinessu.fragment.collection;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class GoodsCollectionFragment extends BaseFragment {


    @BindView(R.id.list_view)
    RecyclerView listView;
    List<String> dataList;
    MyAdapter myAdapter;

    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_goods_collection);
    }

    @Override
    protected void initUI() {

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        myAdapter = new MyAdapter(R.layout.item_goods_collection_list, dataList);
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

    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

        }
    }
}
