package com.xhc.bigbusinessu.activity;

import android.widget.EditText;
import android.widget.TextView;

import com.xhc.bigbusinessu.Entity.RegisterEntity;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_pwd2)
    EditText etPwd2;
    @BindView(R.id.tv_do_register)
    TextView tvDoRegister;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_register);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("注册");

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

        tvDoRegister.setOnClickListener(view -> {
            doRegister();
        });
    }

    @Override
    protected void startFunction() {

    }

    private void doRegister() {

        if (etPhone.getText().toString().trim().length() != 11) {

            ToastMessage("请输入正确的手机号");
            return;
        }
        if (etPwd.getText().toString().trim().length() < 6) {
            ToastMessage("密码长度不足6位");
            return;
        }
        if (!etPwd.getText().toString().trim().equals(etPwd2.getText().toString().trim())) {
            ToastMessage("两次密码输入不一致");
            return;
        }
        showProgressDialog("注册中");
        UserApi.getInstance().doRegister(new BaseCallback<RegisterEntity>(RegisterEntity.class) {
            @Override
            protected void onError(Exception e) {

                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(RegisterEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {
                    ToastMessage(response.getMsg());
                    finish();
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, etPhone.getText().toString().trim(), etPwd.getText().toString().trim(), etPwd2.getText().toString().trim());
    }

}
