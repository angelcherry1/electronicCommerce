package com.xhc.bigbusinessu.activity.life.push;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectChangeListener;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

public class LifePushNeedActivity extends BaseActivity {
    @BindView(R.id.server_type)
    ImageView server_type;
    @BindView(R.id.rg_sex)
    RadioGroup rg_sex;
    @BindView(R.id.server_time)
    TextView server_time;
    @BindView(R.id.server_indroction)
    EditText server_indroction;
    @BindView(R.id.tv_do)
    TextView tv_do;

    TimePickerView pvTime;
    private static final int MSG_TIME_DATA = 0x0001;
   String need_type;
   String need_sex;
   String need_time;
   String need_indroction;
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==MSG_TIME_DATA){

            }

        }
    };
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_life_push_need);

    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("发布需求");

    }

    @Override
    protected void initData() {
        initTimePicker();//初始化时间选择器

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }
    @OnClick({R.id.server_type,R.id.server_time,R.id.rg_sex,R.id.tv_do})
    public void onViewClickNeed(View v){
        switch (v.getId()) {
            case R.id.server_type:
                    serverType();
                break;

            case R.id.server_time:
                pvTime.show();
                break;
            case R.id.rg_sex:
                selectSex();
                break;
            case R.id.tv_do:
                subData();
                break;

        }
    }
//性别选择
    private void selectSex() {
        rg_sex.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                RadioButton r=findViewById(i);
                need_sex=r.getText().toString().trim();
            }
        });
    }
//服务类型选择
    private void serverType() {

    }
//提交需求数据
    private void subData() {
        if (TextUtils.isEmpty(need_type)) {
            ToastMessage("请选择服务类型");
            return;
        }
        if (TextUtils.isEmpty(need_sex)) {
            ToastMessage("请选择性别");
            return;
        }
        if (TextUtils.isEmpty(need_time)) {
            ToastMessage("请选择服务时间");
            return;
        }
        if (TextUtils.isEmpty(need_indroction)) {
            ToastMessage("请填写服务内容");
            return;
        }
        //数据提交后台
    }

    private void initTimePicker() {//Dialog 模式下，在底部弹出


        pvTime = new TimePickerBuilder(this, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                ToastMessage(getTime(date));
//                mHandler.sendMessage(MSG_TIME_DATA);
                Log.i("pvTime", "onTimeSelect");

            }
        })
                .setTimeSelectChangeListener(new OnTimeSelectChangeListener() {
                    @Override
                    public void onTimeSelectChanged(Date date) {
                        Log.i("pvTime", "onTimeSelectChanged");
                    }
                })
                .setType(new boolean[]{true, true, true, true, true, true})
                .isDialog(true) //默认设置false ，内部实现将DecorView 作为它的父控件。
                .addOnCancelClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i("pvTime", "onCancelClickListener");
                    }
                })
//                .setItemVisibleCount(5) //若设置偶数，实际值会加1（比如设置6，则最大可见条目为7）
                .setLineSpacingMultiplier(2.0f)
//                .isAlphaGradient(true)
                .build();

        Dialog mDialog = pvTime.getDialog();
        if (mDialog != null) {

            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    Gravity.BOTTOM);

            params.leftMargin = 0;
            params.rightMargin = 0;
            pvTime.getDialogContainerLayout().setLayoutParams(params);

            Window dialogWindow = mDialog.getWindow();
            if (dialogWindow != null) {
                dialogWindow.setWindowAnimations(com.bigkoo.pickerview.R.style.picker_view_slide_anim);//修改动画样式
                dialogWindow.setGravity(Gravity.BOTTOM);//改成Bottom,底部显示
                dialogWindow.setDimAmount(0.3f);
            }
        }
    }

    private String getTime(Date date) {//可根据需要自行截取数据显示
        Log.d("getTime()", "choice date millis: " + date.getTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }

}
