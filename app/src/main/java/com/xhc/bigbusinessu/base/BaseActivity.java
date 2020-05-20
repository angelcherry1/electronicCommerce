package com.xhc.bigbusinessu.base;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.FragmentActivity;

import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.appmanager.AppManager;

import butterknife.ButterKnife;

public abstract class BaseActivity extends FragmentActivity {
//    protected SpotsDialog dialog;

    public final String TAG = this.getClass().getSimpleName();

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        // 将activity对象添加到程序堆栈
        AppManager.getAppManager().addActivity(this);
//        dialog = new SpotsDialog(this);
        setContentView();
        ButterKnife.bind(this);

//        NotificationManagerCompat notification = NotificationManagerCompat.from(this);
//        boolean isEnabled = notification.areNotificationsEnabled();
//        goToNotificationSetting(isEnabled);


        initUI();
        initData();
        initEvent();
        startFunction();
    }

    /**
     * 打开允许通知的设置页
     *
     * @param isEnabled
     */
    private void goToNotificationSetting(boolean isEnabled) {
        if (isEnabled) {
            return;
        } else {
            Intent intent = new Intent();
            if (Build.VERSION.SDK_INT >= 26) {
                // android 8.0引导
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("android.provider.extra.APP_PACKAGE", this.getPackageName());
            } else if (Build.VERSION.SDK_INT >= 21) {
                // android 5.0-7.0
                intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
                intent.putExtra("app_package", this.getPackageName());
                intent.putExtra("app_uid", this.getApplicationInfo().uid);
            } else {
                // 其他
                intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent.setData(Uri.fromParts("package", this.getPackageName(), null));
            }
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);
        }

    }

    @Override
    protected void onPause() {
        hideKeyboard();
        super.onPause();

    }

    /**
     * hide
     */
    protected void hideKeyboard() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(),
                    0);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 将activity对象移出堆栈

        AppManager.getAppManager().finishActivity(this);
    }

    // 设置头像的内容界面
    protected abstract void setContentView();

    // 实例化UI控件
    protected abstract void initUI();

    // 初始化UI数据
    protected abstract void initData();

    // 初始化事件
    protected abstract void initEvent();

    // 开始执行功能
    protected abstract void startFunction();

    /**
     * 弹出消息提示框
     *
     * @param Title
     * @param Message
     * @param onClickListener
     */
    protected void showAlertDialogMessage(String Title, String Message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(Title);
        builder.setMessage(Message);
        builder.setPositiveButton("好", onClickListener);
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.show();
    }

    /**
     * 返回该类的对象
     */
    protected FragmentActivity getActivity() {
        return this;
    }

    /**
     * 返回上一个界面
     */
    protected void goBack() {
        this.finish();
    }

    /**
     * 获取组建的实例
     */
    protected <T extends View> T getID(int id) {
        return (T) findViewById(id);
    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if(!BackPressed)
//            goBack();
//            return true;
//        } else if (keyCode == KeyEvent.KEYCODE_MENU) {
//            return true;
//        } else {
//            return super.onKeyDown(keyCode, event);
//        }
//    }


    protected void ToastMessage(String message) {
        if (null == MyApplication.getInstance()) {
            return;
        } else {
            Toast.makeText(MyApplication.getInstance(), message, Toast.LENGTH_SHORT).show();
        }

    }

    protected void ToastMessageLong(String Message) {
        Toast.makeText(MyApplication.getInstance(), Message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 设置程序标题
     */
    protected void setTitleText(String title) {
        TextView mTvTitle = getID(R.id.app_title);
        mTvTitle.setText(title);
    }


    /**
     * 设置title的中间View
     *
     * @param v
     * @return
     */

    protected View setTitleCenter(View v) {
        LinearLayout mCenterLin = getID(R.id.lin_title_center);
        mCenterLin.removeAllViews();
        mCenterLin.addView(v);
        return mCenterLin;
    }

    /**
     * 返回上级界面
     */
    protected void showTitleBack() {
        LinearLayout mLinBack = getID(R.id.lin_title_left);
        ImageView mImgBack = getID(R.id.img_title_left);
        mImgBack.setVisibility(View.VISIBLE);
        mLinBack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    /**
     * 返回上级界面
     */
    protected void showTitleBack(OnClickListener onClickListener) {
        LinearLayout mLinBack = getID(R.id.lin_title_left);
        ImageView mImgBack = getID(R.id.img_title_left);
        mImgBack.setImageResource(R.mipmap.icon_title_back);
        mLinBack.setOnClickListener(onClickListener);
    }


    /**
     * 标题右边图片
     */
    protected void setTitleRightImg(int id, OnClickListener listener) {
        LinearLayout mLinRight = getID(R.id.lin_title_right);
        ImageView mImgRight = getID(R.id.img_title_right);
        mImgRight.setImageResource(id);
        mLinRight.setOnClickListener(listener);

    }

    /**
     * 设置Title右边的文字 图片 点击事件
     *
     * @param str
     * @param image_id
     * @param listener
     */
    protected void setTitleRightText(String str, int image_id,
                                     OnClickListener listener) {
        LinearLayout mLinRight = getID(R.id.lin_title_right);
        TextView mTvRight = getID(R.id.app_title_right);
        ImageView mIvRight = getID(R.id.img_title_right);
        mIvRight.setVisibility(View.VISIBLE);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);
        mIvRight.setBackgroundResource(image_id);
        mLinRight.setOnClickListener(listener);

    }

    /**
     * 设置标题右边文字
     */
    protected void setTitleRightText(String str, OnClickListener listener) {
        TextView mTvRight = getID(R.id.app_title_right);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);
        mTvRight.setOnClickListener(listener);

    }

    /**
     * 隐藏标题右边文字
     */
    protected void setTitleRightTextIsVisible(boolean isVisible) {
        TextView mTvRight = getID(R.id.app_title_right);
        if (isVisible) {
            mTvRight.setVisibility(View.VISIBLE);
        } else {
            mTvRight.setVisibility(View.GONE);
        }

    }

    /**
     * 设置标题右边文字
     *
     * @param str
     */
    public void setTitleRightTextName(String str) {
        TextView mTvRight = getID(R.id.app_title_right);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);

    }

    /**
     * 设置标题右边文字颜色
     *
     * @param txtColor
     */
    public void setTitleRightTextColor(int txtColor) {
        TextView mTvRight = getID(R.id.app_title_right);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setTextColor(txtColor);

    }

    public void showActivity(Class<?> classz, boolean finish) {
        startActivity(new Intent(this, classz));
        if (finish) {
            BaseActivity.this.finish();
        }
    }

    protected ProgressDialog progressDialog;

    protected void showProgressDialog(String str) {
        progressDialog = getProgressDialog();
        progressDialog.setMessage(str);
        progressDialog.show();
    }

    protected void disProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private ProgressDialog getProgressDialog() {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                @Override
                public void onCancel(DialogInterface dialog) {
//                    progressShow = false;
                }
            });
        }
        return progressDialog;
    }

    /**
     * 通过Class跳转界面
     **/
    protected void mystartActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        startActivity(intent);
    }


    /**
     * 含有Bundle通过Class跳转界面
     **/
    protected void mystartActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 通过Action跳转界面
     **/
    protected void mystartActivity(String action, Uri uri) {
        Intent intent = new Intent(action, uri);
        startActivity(intent);
    }

    /**
     * 全透状态栏和字体颜色
     */
    public static void setStatusBarFullTransparent(Activity activity) {
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            Window window = activity.getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        View decor = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);//字体颜色
        }
    }
}
