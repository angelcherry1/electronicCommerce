package com.xhc.bigbusinessu.activity.invoice;

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

public class InvoiceListActivity extends BaseActivity {

    @BindView(R.id.list_view)
    RecyclerView listView;

    List<String> dataList;
    MyAdapter myAdapter;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_invoice_list);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("发票抬头");

        listView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();

        dataList.add("");
        dataList.add("");
        dataList.add("");

        myAdapter = new MyAdapter(R.layout.item_invoice_list, dataList);
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

            helper.itemView.setOnClickListener(view -> {
                mystartActivity(EditInvoiceDetailsActivity.class);
            });
        }
    }
}
