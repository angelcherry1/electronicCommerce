package com.xhc.bigbusinessu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.utils.BigDecimalUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChoosePhotoDialog extends Dialog {



    TextView tvCamera,tvAlbum,tvClose;

    OnChoosePhotoListener onChoosePhotoListener;

    public void show(OnChoosePhotoListener onChoosePhotoListener) {
        super.show();
        this.onChoosePhotoListener = onChoosePhotoListener;
    }

    public ChoosePhotoDialog(@NonNull Context context) {
        super(context,R.style.CustomDialog);
        setContentView(R.layout.dialog_choose_photo);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 1.0);
        // 宽度设置为屏幕宽度的80%
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.BOTTOM);//内围区域底部显示
        setCanceledOnTouchOutside(false);
        initView();
    }


    private void initView(){

        tvCamera = findViewById(R.id.tv_type_camera);
        tvAlbum = findViewById(R.id.tv_type_album);
        tvClose = findViewById(R.id.tv_close);
        tvClose.setOnClickListener(view -> dismiss());
        tvCamera.setOnClickListener(view -> {
            if(onChoosePhotoListener!=null){
                onChoosePhotoListener.onChooseType(1);
            }
            dismiss();
        });
        tvAlbum.setOnClickListener(view -> {
            if(onChoosePhotoListener!=null){
                onChoosePhotoListener.onChooseType(2);
            }
            dismiss();
        });
    }

    public interface OnChoosePhotoListener{

        void onChooseType(int type);
    }
}
