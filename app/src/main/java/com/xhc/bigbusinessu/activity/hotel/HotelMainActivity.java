package com.xhc.bigbusinessu.activity.hotel;

import android.view.View;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import butterknife.BindView;
import butterknife.OnClick;

public class HotelMainActivity extends BaseActivity {


    @BindView(R.id.view_type_1)
    View viewType1;
    @BindView(R.id.view_type_2)
    View viewType2;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_hotel_main);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("酒店住宿");
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

    @OnClick({R.id.lin_type_1, R.id.lin_type_2, R.id.tv_find})
    public void onViewClicked(View v) {

        switch (v.getId()) {

            case R.id.lin_type_1:
                viewType1.setVisibility(View.VISIBLE);
                viewType2.setVisibility(View.INVISIBLE);
                break;

            case R.id.lin_type_2:
                viewType2.setVisibility(View.VISIBLE);
                viewType1.setVisibility(View.INVISIBLE);
                break;

            case R.id.tv_find:
                mystartActivity(HotelListActivity.class);
                break;

        }
    }
}
