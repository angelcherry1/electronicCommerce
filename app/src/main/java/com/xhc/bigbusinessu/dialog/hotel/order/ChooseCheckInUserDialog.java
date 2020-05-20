package com.xhc.bigbusinessu.dialog.hotel.order;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.hotel.HotelEditCheckInUserActivity;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class ChooseCheckInUserDialog extends Dialog {

    RecyclerView listView;
    MyAdapter myAdapter;
    List<String> dataList;

    Context context;

    public ChooseCheckInUserDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);

        this.context = context;
        setContentView(R.layout.dialog_choose_check_in_user);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 1.0);
        // 宽度设置为屏幕宽度的80%
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.BOTTOM);//内围区域底部显示
        setCanceledOnTouchOutside(true);
        initView(context);
    }


    private void initView(Context context) {

        listView = findViewById(R.id.list_view);
        listView.setLayoutManager(new LinearLayoutManager(context));
        dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        myAdapter = new MyAdapter(R.layout.item_choose_check_in_user, dataList);
        listView.setAdapter(myAdapter);
    }


    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            helper.getView(R.id.rel_edit).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, HotelEditCheckInUserActivity.class);
                    context.startActivity(intent);
                }
            });
        }
    }
}

