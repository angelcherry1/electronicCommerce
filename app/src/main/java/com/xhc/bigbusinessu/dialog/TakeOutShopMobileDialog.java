package com.xhc.bigbusinessu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.xhc.bigbusinessu.R;

public class TakeOutShopMobileDialog extends Dialog {

    public void show() {
        super.show();
    }

    public TakeOutShopMobileDialog(@NonNull Context context) {
        super(context,R.style.CustomDialog);
        setContentView(R.layout.dialog_take_out_shop_mobile);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 1.0);
        // 宽度设置为屏幕宽度的80%
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.BOTTOM);//内围区域底部显示
        setCanceledOnTouchOutside(true);
        initView();
    }


    private void initView(){

    }

}
