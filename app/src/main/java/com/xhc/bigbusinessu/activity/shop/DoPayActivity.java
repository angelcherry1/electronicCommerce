package com.xhc.bigbusinessu.activity.shop;

import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.xhc.bigbusinessu.Entity.AliPayInfoEntity;
import com.xhc.bigbusinessu.Entity.PayResultEntity;
import com.xhc.bigbusinessu.Entity.WeChatPayInfoEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.PayUtils;
import com.xhc.bigbusinessu.utils.pay.PayEvent;

import butterknife.BindView;

public class DoPayActivity extends BaseActivity {

    @BindView(R.id.cb_type_wechat)
    CheckBox cbWeChat;
    @BindView(R.id.cb_type_ali)
    CheckBox cbAli;
    @BindView(R.id.tv_do_pay)
    TextView tvDoPay;
    @BindView(R.id.tv_total_price)
    TextView tvPrice;
    String order_sn;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_do_pay);
        order_sn = getIntent().getStringExtra("order_sn");
    }

    @Override
    protected void initUI() {
        showTitleBack();
        setTitleText("支付方式");

    }

    @Override
    protected void initData() {
        tvPrice.setText("￥"+getIntent().getStringExtra("price"));
    }

    @Override
    protected void initEvent() {

        PayUtils.getInstance().setOnPayUtilsListener(new PayUtils.OnPayUtilsListener() {
            @Override
            public void onWechatStatus(PayEvent payEvent) {
                if (payEvent.getStatus() == 1) {
                    ToastMessage(payEvent.getMessage());
                    Intent intent = new Intent();
                    intent.putExtra("status",payEvent.getStatus());
                    setResult(1003,intent);
                    finish();
                    mystartActivity(PaySuccessActivity.class);

                } else {
                    ToastMessage(payEvent.getMessage());
                }
            }

            @Override
            public void onAliStatus(PayEvent payEvent) {
                if (payEvent.getStatus() == 1) {
                    ToastMessage(payEvent.getMessage());
                    Intent intent = new Intent();
                    intent.putExtra("status",payEvent.getStatus());
                    setResult(1003,intent);
                    finish();
                    mystartActivity(PaySuccessActivity.class);

                } else {
                    ToastMessage(payEvent.getMessage());
                }
            }
        });

        cbWeChat.setOnClickListener(view -> {
            cbAli.setChecked(false);
            cbWeChat.setChecked(true);
        });
        cbAli.setOnClickListener(view -> {
            cbAli.setChecked(true);
            cbWeChat.setChecked(false);
        });


        tvDoPay.setOnClickListener(view -> {

            if (cbWeChat.isChecked()) {
                doWeChatPay();
            } else {
                doAliPay();
            }
        });
    }

    @Override
    protected void startFunction() {


    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    private void doWeChatPay() {

        showProgressDialog("操作中");
        ShopApi.getInstance().getWxpayinfo(new BaseCallback<WeChatPayInfoEntity>(WeChatPayInfoEntity.class) {
            @Override
            protected void onError(Exception e) {

                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(WeChatPayInfoEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {
                    PayUtils.getInstance().doWeChatPay(DoPayActivity.this, response.getData());
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, order_sn);
    }

    private void doAliPay() {
        showProgressDialog("操作中");
        ShopApi.getInstance().getAlipayinfo(new BaseCallback<AliPayInfoEntity>(AliPayInfoEntity.class) {

            @Override
            protected void onError(Exception e) {
                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(AliPayInfoEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {
                    PayUtils.getInstance().doAliPay(DoPayActivity.this, response.getData());
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, order_sn);
    }
}
