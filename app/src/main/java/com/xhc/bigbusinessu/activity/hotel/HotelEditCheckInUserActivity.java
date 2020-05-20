package com.xhc.bigbusinessu.activity.hotel;

import android.view.View;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

public class HotelEditCheckInUserActivity extends BaseActivity {
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_hotel_edit_check_in_user);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("编辑入住人");
        setTitleRightText("确定", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
            }
        });
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
}
