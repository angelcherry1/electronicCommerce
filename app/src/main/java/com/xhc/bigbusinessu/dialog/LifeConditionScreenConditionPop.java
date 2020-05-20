package com.xhc.bigbusinessu.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xhc.bigbusinessu.R;

public class LifeConditionScreenConditionPop extends PopupWindow {


    TextView tvSex1, tvSex2, tvSex3;
    TextView tvDistance1, tvDistance2;

    OnLifeConditionScreenConditionPopListener onLifeConditionScreenPopListener;

    public LifeConditionScreenConditionPop(Context context, OnLifeConditionScreenConditionPopListener onLifeConditionScreenPopListener) {
        super(context);

        this.onLifeConditionScreenPopListener = onLifeConditionScreenPopListener;

        View mContent = LayoutInflater.from(context).inflate(R.layout.pop_life_condition_screen_condition, null);
        tvSex1 = mContent.findViewById(R.id.tv_sex_1);
        tvSex2 = mContent.findViewById(R.id.tv_sex_2);
        tvSex3 = mContent.findViewById(R.id.tv_sex_3);
        tvDistance1 = mContent.findViewById(R.id.tv_distance_1);
        tvDistance2 = mContent.findViewById(R.id.tv_distance_2);


        this.setContentView(mContent);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        //this.setAnimationStyle(R.style.DetailAnimation);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明
        this.setOutsideTouchable(true);

        tvSex1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvSex1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvSex2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvSex3.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);

                tvSex1.setTextColor(Color.parseColor("#FFB333"));
                tvSex2.setTextColor(Color.parseColor("#666666"));
                tvSex3.setTextColor(Color.parseColor("#666666"));

                if (onLifeConditionScreenPopListener != null) {
                    onLifeConditionScreenPopListener.onChoose(1, 1);
                }

            }
        });
        tvSex2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSex2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvSex1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvSex3.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvSex2.setTextColor(Color.parseColor("#FFB333"));
                tvSex1.setTextColor(Color.parseColor("#666666"));
                tvSex3.setTextColor(Color.parseColor("#666666"));
                if (onLifeConditionScreenPopListener != null) {
                    onLifeConditionScreenPopListener.onChoose(1, 2);
                }
            }
        });
        tvSex3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvSex3.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvSex1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvSex2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvSex3.setTextColor(Color.parseColor("#FFB333"));
                tvSex2.setTextColor(Color.parseColor("#666666"));
                tvSex1.setTextColor(Color.parseColor("#666666"));
                if (onLifeConditionScreenPopListener != null) {
                    onLifeConditionScreenPopListener.onChoose(1, 3);
                }
            }
        });

        tvDistance1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDistance1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvDistance2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvDistance1.setTextColor(Color.parseColor("#FFB333"));
                tvDistance2.setTextColor(Color.parseColor("#666666"));
                if (onLifeConditionScreenPopListener != null) {
                    onLifeConditionScreenPopListener.onChoose(2, 1);
                }
            }
        });

        tvDistance2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvDistance2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvDistance1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvDistance2.setTextColor(Color.parseColor("#FFB333"));
                tvDistance1.setTextColor(Color.parseColor("#666666"));
                if (onLifeConditionScreenPopListener != null) {
                    onLifeConditionScreenPopListener.onChoose(2, 1);
                }
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

    public interface OnLifeConditionScreenConditionPopListener {
        void onDismiss();

        void onChoose(int type, int value);
    }
}
