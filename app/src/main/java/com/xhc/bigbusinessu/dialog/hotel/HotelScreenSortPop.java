package com.xhc.bigbusinessu.dialog.hotel;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xhc.bigbusinessu.R;

public class HotelScreenSortPop extends PopupWindow {


    TextView tvChoose1;
    RelativeLayout relChoose1;
    ImageView imgChoose1;


    TextView tvChoose2;
    RelativeLayout relChoose2;
    ImageView imgChoose2;

    TextView tvChoose3;
    RelativeLayout relChoose3;
    ImageView imgChoose3;

    OnLifeConditionScreenSortPopListener onLifeConditionScreenPopListener;

    public HotelScreenSortPop(Activity context, OnLifeConditionScreenSortPopListener onLifeConditionScreenPopListener) {
        super(context);

        this.onLifeConditionScreenPopListener = onLifeConditionScreenPopListener;

        View mContent = LayoutInflater.from(context).inflate(R.layout.pop_hotel_screen_sort, null);
        
        tvChoose1 = mContent.findViewById(R.id.tv_choose_1);
        relChoose1 = mContent.findViewById(R.id.rel_choose_1);
        imgChoose1 = mContent.findViewById(R.id.img_choose_1);

        tvChoose2 = mContent.findViewById(R.id.tv_choose_2);
        relChoose2 = mContent.findViewById(R.id.rel_choose_2);
        imgChoose2 = mContent.findViewById(R.id.img_choose_2);

        tvChoose3 = mContent.findViewById(R.id.tv_choose_3);
        relChoose3 = mContent.findViewById(R.id.rel_choose_3);
        imgChoose3 = mContent.findViewById(R.id.img_choose_3);

        this.setContentView(mContent);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        //this.setAnimationStyle(R.style.DetailAnimation);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0xB3000000));// 设置背景透明

        this.setOutsideTouchable(true);



        relChoose1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                imgChoose1.setVisibility(View.VISIBLE);
                imgChoose2.setVisibility(View.GONE);
                imgChoose3.setVisibility(View.GONE);
            }
        });
        relChoose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgChoose2.setVisibility(View.VISIBLE);
                imgChoose1.setVisibility(View.GONE);
                imgChoose3.setVisibility(View.GONE);
            }
        });
        relChoose3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imgChoose3.setVisibility(View.VISIBLE);
                imgChoose2.setVisibility(View.GONE);
                imgChoose1.setVisibility(View.GONE);
            }
        });

    }

    @Override
    public void dismiss() {
        super.dismiss();
        if (onLifeConditionScreenPopListener != null) {
            onLifeConditionScreenPopListener.onDismiss();
        }
    }

    public void showAsDropDown(View anchor) {
        super.showAsDropDown(anchor);
    }

    public interface OnLifeConditionScreenSortPopListener {
        void onDismiss();
        void onChoose(int type);
    }

}