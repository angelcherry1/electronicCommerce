package com.xhc.bigbusinessu.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.xhc.bigbusinessu.R;

public class LifeConditionScreenSortPop extends PopupWindow {


    RelativeLayout relChoose;
    ImageView imgChoose;

    OnLifeConditionScreenSortPopListener onLifeConditionScreenPopListener;

    public LifeConditionScreenSortPop(Context context, OnLifeConditionScreenSortPopListener onLifeConditionScreenPopListener) {
        super(context);

        this.onLifeConditionScreenPopListener = onLifeConditionScreenPopListener;

        View mContent = LayoutInflater.from(context).inflate(R.layout.pop_life_condition_screen_sort, null);
        relChoose = mContent.findViewById(R.id.rel_choose);
        imgChoose = mContent.findViewById(R.id.img_choose);

        this.setContentView(mContent);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        //this.setAnimationStyle(R.style.DetailAnimation);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明
        this.setOutsideTouchable(true);

        relChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(imgChoose.getVisibility() == View.VISIBLE){
                    imgChoose.setVisibility(View.INVISIBLE);
                    if(onLifeConditionScreenPopListener!=null){
                        onLifeConditionScreenPopListener.onChoose(0);
                    }
                }
                else{
                    imgChoose.setVisibility(View.VISIBLE);
                    if(onLifeConditionScreenPopListener!=null){
                        onLifeConditionScreenPopListener.onChoose(1);
                    }
                }



            }
        });
    }

    @Override
    public void dismiss() {
        super.dismiss();
        if(onLifeConditionScreenPopListener!=null){
            onLifeConditionScreenPopListener.onDismiss();
        }
    }

    public void showAsDropDown(View anchor ) {
        super.showAsDropDown(anchor);
    }

    public interface OnLifeConditionScreenSortPopListener {
        void onDismiss();
        void onChoose(int type);
    }
}
