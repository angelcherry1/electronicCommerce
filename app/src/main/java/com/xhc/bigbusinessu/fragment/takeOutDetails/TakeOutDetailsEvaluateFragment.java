package com.xhc.bigbusinessu.fragment.takeOutDetails;

import android.view.LayoutInflater;
import android.view.View;

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

public class TakeOutDetailsEvaluateFragment extends BaseFragment {


    @BindView(R.id.list_view)
    RecyclerView listView;

    MyAdapter myAdapter;

    List<String> dataList = new ArrayList<>();

    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_take_out_details_evaluate);
    }

    @Override
    protected void initUI() {

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));

        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");

        myAdapter = new MyAdapter(R.layout.item_take_out_details_evaluate, dataList);
        listView.setAdapter(myAdapter);
        View headView = LayoutInflater.from(getActivity()).inflate(R.layout.view_take_out_details_evaluate_head,null);
        myAdapter.addHeaderView(headView);
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
