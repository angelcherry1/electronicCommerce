package com.xhc.bigbusinessu.activity.takeOut;

import android.content.ClipData;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.hotel.HotelDetailsActivity;
import com.xhc.bigbusinessu.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class TakeOutHomeActivity extends BaseActivity {

    @BindView(R.id.list_view)
    RecyclerView listView;

    MyAdapter myAdapter;

    List<String> dataList = new ArrayList<>();

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_take_out_home);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("");

        listView.setLayoutManager(new LinearLayoutManager(this));
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        myAdapter = new MyAdapter(R.layout.item_take_out_home, dataList);
        listView.setAdapter(myAdapter);

        View headView = LayoutInflater.from(this).inflate(R.layout.view_take_out_home_head,null);
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

            String[] list3 = new String[]{"12减12", "12减12", "12减12"};

            TagContainerLayout  mTagContainerLayout = helper.getView(R.id.tagcontainerLayout3);
            mTagContainerLayout.setTags(list3);

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mystartActivity(TakeOutGoodsListActivity.class);
                }
            });
        }
    }
}
