package com.xhc.bigbusinessu.dialog.hotel;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;

import java.util.ArrayList;
import java.util.List;

public class RegionalLocationSortPop extends PopupWindow {


    RecyclerView leftListView;
    RecyclerView rightListView;

    LeftAdapter leftAdapter;
    RightAdapter rightAdapter;

    List<String> leftDataList = new ArrayList<>();
    List<String> rightDataList = new ArrayList<>();

    public RegionalLocationSortPop(Activity context) {
        super(context);

        View mContent = LayoutInflater.from(context).inflate(R.layout.pop_regional_location_sort, null);
        leftListView = mContent.findViewById(R.id.left_list_view);
        rightListView = mContent.findViewById(R.id.right_list_view);
        this.setContentView(mContent);// 设置View
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);// 设置弹出窗口的宽
        this.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);// 设置弹出窗口的高
        this.setFocusable(true);// 设置弹出窗口可
        //this.setAnimationStyle(R.style.DetailAnimation);// 设置动画
        this.setBackgroundDrawable(new ColorDrawable(0xB3000000));// 设置背景透明

        this.setOutsideTouchable(true);

        leftDataList.add("热门");
        leftDataList.add("商业区");
        leftDataList.add("热门景点");
        leftDataList.add("机场车站");
        leftDataList.add("地铁线路");
        leftDataList.add("大学周边");
        leftDataList.add("医院周边");

        leftAdapter = new LeftAdapter(R.layout.item_regional_location_left, leftDataList);
        leftListView.setLayoutManager(new LinearLayoutManager(context));
        leftListView.setAdapter(leftAdapter);

        rightDataList.add("天安门");
        rightDataList.add("首都机场");
        rightDataList.add("北京西站");
        rightDataList.add("古北冰镇");
        rightDataList.add("北京南站");
        rightDataList.add("北京站");
        rightDataList.add("北京大学");

        rightAdapter = new RightAdapter(R.layout.item_regional_location_right, rightDataList);
        rightListView.setLayoutManager(new LinearLayoutManager(context));
        rightListView.setAdapter(rightAdapter);


    }

    @Override
    public void dismiss() {
        super.dismiss();
//        if (onLifeConditionScreenPopListener != null) {
//            onLifeConditionScreenPopListener.onDismiss();
//        }
    }

    int chooseIndex;

    class LeftAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public LeftAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            LinearLayout linBg = helper.getView(R.id.lin_bg);
            TextView tvChoose = helper.getView(R.id.tv_title);
            tvChoose.setText(item);

            if(chooseIndex == helper.getAdapterPosition()){
                linBg.setBackgroundColor(Color.parseColor("#FFFFFF"));
                tvChoose.setTextColor(Color.parseColor("#FFB333"));
            }
            else{
                linBg.setBackgroundColor(Color.parseColor("#f0f0f0"));
                tvChoose.setTextColor(Color.parseColor("#666666"));
            }
            helper.itemView.setOnClickListener(view -> {

                chooseIndex = helper.getAdapterPosition();
                notifyDataSetChanged();

            });

        }
    }

    class RightAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public RightAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            TextView tvChoose = helper.getView(R.id.tv_title);
            tvChoose.setText(item);

//            if(chooseIndex == helper.getAdapterPosition()){
//                tvChoose.setTextColor(Color.parseColor("#FFB333"));
//            }
//            else{
//                tvChoose.setTextColor(Color.parseColor("#FFB333"));
//            }
        }
    }

}
