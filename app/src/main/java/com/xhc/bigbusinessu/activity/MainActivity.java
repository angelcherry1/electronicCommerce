package com.xhc.bigbusinessu.activity;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.joker.api.Permissions4M;
import com.joker.api.wrapper.ListenerWrapper;
import com.joker.api.wrapper.Wrapper;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.adapter.FragmentTabAdapter;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.fragment.BBSFragment;
import com.xhc.bigbusinessu.fragment.CarFragment;
import com.xhc.bigbusinessu.fragment.HomeFragment;
import com.xhc.bigbusinessu.fragment.MeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity {


    @BindView(R.id.main_bottom_tabs)
    RadioGroup mainBottomTabs;

    private List<Fragment> fragments;
    FragmentTabAdapter tabAdapter;

    HomeFragment homeFragment;

    CarFragment carFragment;

    BBSFragment bbsFragment;

    MeFragment meFragment;

    @Override
    protected void setContentView() {


        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initUI() {
//判断用户是否登录
        if (!MyApplication.getInstance().isLogin()) {
            mystartActivity(LoginActivity.class);
        }
    }

    @Override
    protected void initData() {

        homeFragment = new HomeFragment();
        carFragment = new CarFragment();
        bbsFragment = new BBSFragment();
        meFragment = new MeFragment();

        fragments = new ArrayList<>();
        fragments.add(homeFragment);
        fragments.add(carFragment);
        fragments.add(bbsFragment);
        fragments.add(meFragment);

        tabAdapter = new FragmentTabAdapter(this, fragments, R.id.main_content, mainBottomTabs);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

        handler.sendEmptyMessageDelayed(1101, 1000);


    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1101) {

                Permissions4M.get(MainActivity.this)
                        .requestPermissions(Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                        .requestCodes(4, 1, 2, 3)
                        .requestListener(new ListenerWrapper.PermissionRequestListener() {
                            @Override
                            public void permissionGranted(int code) {
                                Log.e(TAG, "permissionGranted " + code);
                                Log.e("Test", "11111111111111：" + code);
                                if (code == 1 || code == 4) {
                                    Log.e("Test", "222222");
                                    if (homeFragment != null) {
                                        homeFragment.getLocation();
                                    } else {
                                        Log.e("Test", "3333333333333333");
                                    }

                                }
                            }

                            @Override
                            public void permissionDenied(int code) {
                                Log.e(TAG, "permissionDenied " + code);
                                switch (code) {
                                    case 1:
                                    case 4:
                                        ToastMessage("定位权限被禁止");
                                        break;
                                    case 2:
                                        ToastMessage("拍照权限被禁止");
                                        break;
                                    case 3:
                                        ToastMessage("文件权限被禁止");
                                        break;
                                }
                            }

                            @Override
                            public void permissionRationale(int code) {
                                Log.e(TAG, "permissionRationale " + code);
                                switch (code) {
                                    case 1:
                                    case 4:
                                        ToastMessage("申请定位权限被拒绝");
                                        break;
                                    case 2:
                                        ToastMessage("申请拍照权限被拒绝");
                                        break;
                                    case 3:
                                        ToastMessage("申请文件权限被拒绝");
                                        break;
                                }
                            }
                        })
                        .requestPageType(Permissions4M.PageType.MANAGER_PAGE)
                        .requestPage(new Wrapper.PermissionPageListener() {
                            @Override
                            public void pageIntent(int code, final Intent intent) {
                                new AlertDialog.Builder(MainActivity.this)
                                        .setMessage("App需要开启定位权限：\n请点击前往设置页面")
                                        .setPositiveButton("前往设置页面", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                startActivity(intent);
                                            }
                                        })
                                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                                            @Override
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                            }
                                        })
                                        .show();
                            }
                        })
                        .request();
            }
        }
    };


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        Permissions4M.onRequestPermissionsResult(MainActivity.this, requestCode, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }


    private long mExitTime;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        //判断用户是否点击了“返回键”
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            //与上次点击返回键时刻作差
            if ((System.currentTimeMillis() - mExitTime) > 2000) {
                //大于2000ms则认为是误操作，使用Toast进行提示
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                //并记录下本次点击“返回键”的时刻，以便下次进行判断
                mExitTime = System.currentTimeMillis();
            } else {
                //小于2000ms则认为是用户确实希望退出程序-调用System.exit()方法进行退出
//                System.exit(0);
                finish();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }


}
