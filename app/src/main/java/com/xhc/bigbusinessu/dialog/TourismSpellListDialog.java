package com.xhc.bigbusinessu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
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

public class TourismSpellListDialog extends Dialog {


    RelativeLayout relClose;

    RecyclerView listView;
    MyAdapter myAdapter;
    List<String> dataList;

    public TourismSpellListDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);
        setContentView(R.layout.dialog_toursim_spell_list);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 1.0);
        // 宽度设置为屏幕宽度的80%
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.CENTER);//内围区域底部显示
        setCanceledOnTouchOutside(false);
        initView();
    }


    private void initView() {

        relClose = findViewById(R.id.rel_close);

        listView = findViewById(R.id.list_view);
        listView.setLayoutManager(new LinearLayoutManager(getContext()));
        dataList = new ArrayList<>();
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        dataList.add("1");
        myAdapter = new MyAdapter(R.layout.item_tourism_spell_list, dataList);
        listView.setAdapter(myAdapter);

        relClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
    }


    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

        }
    }

}