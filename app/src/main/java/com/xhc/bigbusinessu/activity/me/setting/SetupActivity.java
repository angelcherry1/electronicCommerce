package com.xhc.bigbusinessu.activity.me.setting;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.android.library.YLCircleImageView;
import com.xhc.bigbusinessu.Entity.UserInfoEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.MainActivity;
import com.xhc.bigbusinessu.activity.me.MyShopGoodsAddressListActivity;
import com.xhc.bigbusinessu.appmanager.AppManager;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;

import butterknife.BindView;
import butterknife.OnClick;

public class SetupActivity extends BaseActivity {

    @BindView(R.id.img_avatar)
    YLCircleImageView imgAvatar;
    @BindView(R.id.tv_mobile)
    TextView tvMobile;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_setup);
    }

    @Override
    protected void initUI() {

        setTitleText("设置");
        showTitleBack();
    }

    @Override
    protected void initData() {

        getUserInfo();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }

    @OnClick({R.id.rel_user_info, R.id.rel_my_address,R.id.rel_account, R.id.tv_logout})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.rel_user_info:
                mystartActivity(PersonalInfoActivity.class);
                break;

            case R.id.rel_my_address:
                mystartActivity(MyShopGoodsAddressListActivity.class);
                break;

            case R.id.rel_account:
                mystartActivity(ChangePwdActivity.class);
                break;

            case R.id.tv_logout:

                showAlertDialogMessage("提示", "是否要退出登录?", (dialogInterface, i) -> {

                    MyApplication.getInstance().logout();

                    AppManager.getAppManager().finishAllActivity();
                    mystartActivity(MainActivity.class);
                });
                break;
        }
    }

    private void getUserInfo() {

        UserApi.getInstance().getUserInfo(new BaseCallback<UserInfoEntity>(UserInfoEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(UserInfoEntity response) {

                if (response.getData() != null) {
                    GlideUtils.loadImg(imgAvatar, response.getData().getHead_pic());
                    tvMobile.setText(response.getData().getNickname());
                } else {

                }

            }
        }, "");
    }
}
