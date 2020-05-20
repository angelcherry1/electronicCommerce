package com.xhc.bigbusinessu.activity.wallet;

import android.view.View;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import butterknife.OnClick;

public class MyWalletActivity extends BaseActivity {


    @Override
    protected void setContentView() {
        setContentView(R.layout.aty_my_wallet);
    }

    @Override
    protected void initUI() {
        showTitleBack();
        setTitleText("钱包");
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


    @OnClick({R.id.rel_money_out,R.id.rel_money_list})
    public void onViewClicked(View v){

        switch (v.getId()){
            case R.id.rel_money_out:
                mystartActivity(ApplyMoneyOutActivity.class);
                break;
            case R.id.rel_money_list:
                mystartActivity(OutMoneyListActivity.class);
                break;
        }
    }
}
