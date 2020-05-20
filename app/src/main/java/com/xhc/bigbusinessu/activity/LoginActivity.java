package com.xhc.bigbusinessu.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.xhc.bigbusinessu.Entity.LoginEntity;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;

import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity {


    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.tv_register)
    TextView tvRegister;

    @Override
    protected void setContentView() {
        setContentView(R.layout.aty_login);
    }

    @Override
    protected void initUI() {

        setTitleText("登录");
    }

    @Override
    protected void initData() {

//        countdownTimer = new CountDownTimer((60) * 1000, 1000) {
//            @Override
//            public void onTick(long millisUntilFinished) {
//
//                tvGetCode.setText(millisUntilFinished / 1000 + "s");
//            }
//
//            @Override
//            public void onFinish() {
//                tvGetCode.setText("获取验证码");
//                tvGetCode.setEnabled(true);
//            }
//        };
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }


    @OnClick({R.id.tv_login, R.id.tv_register})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.tv_login:

                if (etPhone.getText().toString().trim().length() != 11) {

                    ToastMessage("请输入正确的手机号");
                    return;
                }
                if (etPwd.getText().toString().trim().length() <= 0) {
                    ToastMessage("请输入密码");
                    return;
                }

                doLogin(etPhone.getText().toString().trim(), etPwd.getText().toString().trim());
                break;
            case R.id.tv_register:
                mystartActivity(RegisterActivity.class);
                break;
        }
    }

    private void doLogin(String phone, String pwd) {

        showProgressDialog("登录中");
        UserApi.getInstance().doLogin(new BaseCallback<LoginEntity>(LoginEntity.class) {
            @Override
            protected void onError(Exception e) {
                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(LoginEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {
                    ToastMessage(response.getMsg());
                    MyApplication.getInstance().saveToken(response.getData().getToken());
                    MyApplication.getInstance().saveUserId(response.getData().getUser_id());

                    finish();

                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, phone, pwd);
    }
}
