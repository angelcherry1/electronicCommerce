package com.xhc.bigbusinessu.activity;

import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.SharedPreferencesUtils;

public class LogoActivity extends BaseActivity {

    @Override
    protected void setContentView() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /*set it to be full screen*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.aty_logo);
    }

    @Override
    protected void initUI() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                doStartActivity();

            }
        }).start();
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

    /**
     * 跳转
     */
    private void doStartActivity() {
        String userToken = (String) SharedPreferencesUtils.getParam("userToken", "");
        if (!TextUtils.isEmpty(userToken)) {
            mystartActivity(MainActivity.class);
        } else {
            mystartActivity(LoginActivity.class);
        }
        finish();
    }
}
