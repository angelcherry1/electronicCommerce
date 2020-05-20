package com.xhc.bigbusinessu.dialog.hotel;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.xhc.bigbusinessu.R;

public class PriceStarSortPop extends PopupWindow {



    public PriceStarSortPop(Activity context) {
        super(context);

        View mContent = LayoutInflater.from(context).inflate(R.layout.pop_price_star_sort, null);

        this.setContentView(mContent);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        //this.setAnimationStyle(R.style.DetailAnimation);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0xB3000000));// 设置背景透明

        this.setOutsideTouchable(true);



    }

    @Override
    public void dismiss() {
        super.dismiss();
//        if (onLifeConditionScreenPopListener != null) {
//            onLifeConditionScreenPopListener.onDismiss();
//        }
    }

}
