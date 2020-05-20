package com.xhc.bigbusinessu.fragment.takeOutDetails;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.takeOut.TakeOutBusinessQualificationActivity;
import com.xhc.bigbusinessu.base.BaseFragment;
import com.xhc.bigbusinessu.dialog.TakeOutShopMobileDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TakeOutDetailsBusinessFragment extends BaseFragment {


    @BindView(R.id.list_view)
    RecyclerView listView;


    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_take_out_details_business);
    }

    @Override
    protected void initUI() {

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

    @OnClick({R.id.img_call_shop, R.id.rel_business_qualification})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.img_call_shop:

                new TakeOutShopMobileDialog(getActivity()).show();

                break;

            case R.id.rel_business_qualification:

                mystartActivity(TakeOutBusinessQualificationActivity.class);

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
