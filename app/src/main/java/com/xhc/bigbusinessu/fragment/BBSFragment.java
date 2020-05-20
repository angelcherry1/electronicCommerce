package com.xhc.bigbusinessu.fragment;

import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.adapter.BbsAdapter;
import com.xhc.bigbusinessu.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by XXW on 2018/8/19.
 * 首页
 */

public class BBSFragment extends BaseFragment {

    @BindView(R.id.list_view)
    RecyclerView listView;

    BbsAdapter bbsAdapter;
    List<String> dataList;

    @Override
    protected void setContentView() {
        setContentView(R.layout.frag_tab_home);
    }

    @Override
    protected void initUI() {
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = new ArrayList<>();

        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");


        bbsAdapter = new BbsAdapter(R.layout.item_tab_bbs,dataList);
        listView.setAdapter(bbsAdapter);

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


    public void onViewClicked(View view) {


    }


}
