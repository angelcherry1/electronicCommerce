package com.xhc.bigbusinessu.activity.hotel;

import android.view.View;
import android.widget.LinearLayout;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.hotel.order.ChooseCheckInUserDialog;

import butterknife.BindView;
import butterknife.OnClick;

public class HotelSubOrderActivity extends BaseActivity {

    ChooseCheckInUserDialog chooseCheckInUserDialog;

    @BindView(R.id.lin_order_details)
    LinearLayout mLinOrderDetail;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_hotel_sub_order);
    }

    @Override
    protected void initUI() {
        showTitleBack();
        setTitleText("订单填写");

        chooseCheckInUserDialog = new ChooseCheckInUserDialog(this);

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

    @OnClick({R.id.rel_choose_user, R.id.lin_show_details, R.id.tv_do_sub_order})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.rel_choose_user:
                chooseCheckInUserDialog.show();
                break;

            //显示明细
            case R.id.lin_show_details:
                mLinOrderDetail.setVisibility(mLinOrderDetail.getVisibility() == View.GONE ? View.VISIBLE : View.GONE);
                break;
            case R.id.tv_do_sub_order:
                mystartActivity(HotelDoPayOrderActivity.class);
                break;
        }
    }
}
