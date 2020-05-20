package com.xhc.bigbusinessu.activity.myGoods;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class MyGoodsForSellActivity extends BaseActivity {

    @BindView(R.id.list_view)
    RecyclerView listView;
    List<String> dataList;
    MyAdapter myAdapter;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_my_goods_for_sell);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("我卖出的商品");

        listView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
//        myAdapter = new MyAdapter();
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

    @OnClick({R.id.tv_push})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.tv_push:
                mystartActivity(PushMyGoodsActivity.class);
                break;

        }
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
