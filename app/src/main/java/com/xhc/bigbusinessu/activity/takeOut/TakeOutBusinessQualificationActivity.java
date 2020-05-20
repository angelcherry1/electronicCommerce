package com.xhc.bigbusinessu.activity.takeOut;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class TakeOutBusinessQualificationActivity extends BaseActivity {

    @BindView(R.id.list_view)
    RecyclerView listView;
    MyAdapter myAdapter;
    List<String> dataList;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_take_out_business_qualification);
    }

    @Override
    protected void initUI() {

        @SuppressLint("WrongConstant")
        GridLayoutManager manager = new GridLayoutManager(this,2, LinearLayoutManager.VERTICAL,false);
        listView.setLayoutManager(manager);
        dataList = new ArrayList<>();

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

    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder>{

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

        }
    }
}
