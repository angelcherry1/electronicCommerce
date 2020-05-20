package com.xhc.bigbusinessu.activity.me.setting;
import android.widget.EditText;
import android.widget.TextView;

import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import butterknife.BindView;

public class ChangePwdActivity extends BaseActivity {
    @BindView(R.id.et_old_pwd)
    EditText etOldPwd;
    @BindView(R.id.et_pwd)
    EditText etPwd;
    @BindView(R.id.et_pwd2)
    EditText etPwd2;
    @BindView(R.id.tv_do_change)
    TextView tvDoChange;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_change_pwd);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("修改密码");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

        tvDoChange.setOnClickListener(view -> {

//            if (etOldPwd.getText().toString().trim().length() != 11) {
//                ToastMessage("请输入原密码");
//                return;
//            }
            if (etPwd.getText().toString().trim().length() < 6) {
                ToastMessage("新密码长度不足6位");
                return;
            }
            if (!etPwd.getText().toString().trim().equals(etPwd2.getText().toString().trim())) {
                ToastMessage("两次新密码输入不一致");
                return;
            }

            showProgressDialog("修改中");
            UserApi.getInstance().changePwd(new BaseCallback<BaseEntity>(BaseEntity.class) {
                @Override
                protected void onError(Exception e) {
                    disProgressDialog();
                    ToastMessage("网络异常");
                }

                @Override
                protected void onSuccess(BaseEntity response) {
                    disProgressDialog();
                    if(response.getStatus() ==1){
                        ToastMessage(response.getMsg());
                        finish();
                    }else{
                        ToastMessage(response.getMsg());
                    }
                }
            },etOldPwd.getText().toString().trim(),etPwd.getText().toString().trim(),etPwd2.getText().toString().trim());
        });
    }

    @Override
    protected void startFunction() {

    }



}
