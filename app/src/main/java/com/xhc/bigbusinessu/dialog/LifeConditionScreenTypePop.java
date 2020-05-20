package com.xhc.bigbusinessu.dialog;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.xhc.bigbusinessu.R;

public class LifeConditionScreenTypePop extends PopupWindow {


    TextView tvType1,tvType2,tvType3;

    OnLifeConditionScreenPopListener onLifeConditionScreenPopListener;

    public LifeConditionScreenTypePop(Context context,OnLifeConditionScreenPopListener onLifeConditionScreenPopListener) {
        super(context);

        this.onLifeConditionScreenPopListener = onLifeConditionScreenPopListener;

        View mContent = LayoutInflater.from(context).inflate(R.layout.pop_life_condition_screen, null);
        tvType1 = mContent.findViewById(R.id.tv_type_1);
        tvType2 = mContent.findViewById(R.id.tv_type_2);
        tvType3 = mContent.findViewById(R.id.tv_type_3);

        this.setContentView(mContent);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        //this.setAnimationStyle(R.style.DetailAnimation);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0x00000000));// 设置背景透明
        this.setOutsideTouchable(true);

        tvType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tvType1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvType2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvType3.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);

                tvType1.setTextColor(Color.parseColor("#FFB333"));
                tvType2.setTextColor(Color.parseColor("#666666"));
                tvType3.setTextColor(Color.parseColor("#666666"));

                if(onLifeConditionScreenPopListener!=null){
                    onLifeConditionScreenPopListener.onChoose(1);
                }

            }
        });
        tvType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvType2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvType1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvType3.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvType2.setTextColor(Color.parseColor("#FFB333"));
                tvType1.setTextColor(Color.parseColor("#666666"));
                tvType3.setTextColor(Color.parseColor("#666666"));
                if(onLifeConditionScreenPopListener!=null){
                    onLifeConditionScreenPopListener.onChoose(2);
                }
            }
        });
        tvType3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvType3.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_ed);
                tvType1.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvType2.setBackgroundResource(R.drawable.shape_screen_tv_tag_bg_nor);
                tvType3.setTextColor(Color.parseColor("#FFB333"));
                tvType2.setTextColor(Color.parseColor("#666666"));
                tvType1.setTextColor(Color.parseColor("#666666"));
                if(onLifeConditionScreenPopListener!=null){
                    onLifeConditionScreenPopListener.onChoose(3);
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

    public interface OnLifeConditionScreenPopListener {
        void onDismiss();
        void onChoose(int type);
    }
}
