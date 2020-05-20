package com.xhc.bigbusinessu.base;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;

import butterknife.ButterKnife;
import butterknife.Unbinder;


public abstract class BaseFragment extends Fragment {
    private View mContentView = null;
    protected LayoutInflater mInflater;
    private ProgressDialog mWaitingDialog;
    protected Activity activity;

    Unbinder unbinder;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.activity = activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mContentView == null) {
            this.mInflater = inflater;
            setContentView();
            unbinder = ButterKnife.bind(this, mContentView);
            initUI();
            initData();
            initEvent();
            startFunction();

        }


        return mContentView;
    }

    /**
     * 设置fragment的内容
     */
    protected void setContentView(int id) {
        mContentView = mInflater.inflate(id, null);
    }

    protected abstract void setContentView();

    protected abstract void initUI();

    protected abstract void initData();

    protected abstract void initEvent();

    protected abstract void startFunction();
    protected  void ToastMessage(String Message){

        Toast.makeText(MyApplication.getInstance(),Message, Toast.LENGTH_SHORT).show();
    }
    @Override
    public void onDestroyView() {
        if (mContentView != null) {
            ((ViewGroup) mContentView.getParent()).removeView(mContentView);
        }

        super.onDestroyView();
        unbinder.unbind();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T getID(int id) {
        return (T) mContentView.findViewById(id);

    }

    protected void goBack() {
        activity.finish();
    }

    /**
     * 设置程序标题
     */
    protected void setTitleText(String title) {
        TextView mTvTitle = getID(R.id.app_title);
        mTvTitle.setText(title);
    }

    /**
     * 获取Title高度
     */
    protected int getTitleHeight() {
        int w = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int h = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);

        LinearLayout  mTitleLine = getID(R.id.title_bg);
        mTitleLine.measure(w, h);
        return mTitleLine.getMeasuredHeight();
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
        mImgBack.setImageResource(R.mipmap.icon_title_back);
        mLinBack.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                goBack();
            }
        });
    }

    /**
     * 设置左边的图片 点击
     */
    protected void setTitleLeftImg(int id, OnClickListener listener) {
        LinearLayout mLinBack = getID(R.id.lin_title_left);
        ImageView mImgBack = getID(R.id.img_title_left);
        mImgBack.setImageResource(id);
        mLinBack.setOnClickListener(listener);

    }

    /**
     * 标题右边图片 点击事件
     */
    protected void setTitleRightImg(int id, OnClickListener listener) {
        LinearLayout mLinRight = getID(R.id.lin_title_right);
        ImageView mImgRight = getID(R.id.img_title_right);
        mImgRight.setImageResource(id);
        mLinRight.setOnClickListener(listener);
    }

    /**
     * 标题右边图片
     */
    protected   void setTitleRightImg(int id) {
        ImageView mImgRight = getID(R.id.img_title_right);
        mImgRight.setImageResource(id);

    }

    /**
     * 设置标题右边文字,点击事件
     */
    protected void setTitleRightText(String str, OnClickListener listener) {
        TextView mTvRight = getID(R.id.app_title_right);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);
        mTvRight.setClickable(true);
        mTvRight.setOnClickListener(listener);
    }

    /**
     * 设置标题右边文字
     */
    protected void setTitleRightText(String str) {
        TextView mTvRight = getID(R.id.app_title_right);
        mTvRight.setVisibility(View.VISIBLE);
        mTvRight.setText(str);

    }

    /**
     * 根据id获取string中的数据
     *
     * @param id
     * @return
     */
    protected String getStringValue(int id) {
        return getResources().getString(id);
    }

    protected void showActivity(Class classz) {
        startActivity(new Intent(activity, classz));
    }

//    public void showWaitingDialog() {
//        if (null == getActivity()) {
//            return;
//        }
//        if (mWaitingDialog == null) {
//            mWaitingDialog = new ProgressDialog(activity);
//            mWaitingDialog.setCanceledOnTouchOutside(false);
//            mWaitingDialog.setMessage("获取中。。。");
//            mWaitingDialog.setCancelable(true);
//        }
//        if (!mWaitingDialog.isShowing()) {
//            mWaitingDialog.show();
//        }
//    }
    public void showProgressDialog(String title) {
        if (null == getActivity()) {
            return;
        }
        if (mWaitingDialog == null) {
            mWaitingDialog = new ProgressDialog(activity);
            mWaitingDialog.setCanceledOnTouchOutside(false);
            mWaitingDialog.setMessage(title);
            mWaitingDialog.setCancelable(true);
        }
        if (!mWaitingDialog.isShowing()) {
            mWaitingDialog.show();
        }
    }


    public void disProgressDialog() {
        if (mWaitingDialog != null && mWaitingDialog.isShowing()) {
            mWaitingDialog.dismiss();
        }
    }


    /**
     * 弹出消息提示框
     *
     * @param Title
     * @param Message
     * @param onClickListener
     */
    protected void showAlertDialogMessage(String Title, String Message, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
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
     * 通过Class跳转界面
     **/
    protected void mystartActivity(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        startActivity(intent);
    }

    /**
     * 含有Bundle通过Class跳转界面
     **/
    protected void mystartActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(getActivity(), cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

}
