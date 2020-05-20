package com.xhc.bigbusinessu.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xhc.bigbusinessu.MyApplication;

public class GlideUtils {


    public static void loadImg(ImageView imageView,String url){

        Glide.with(MyApplication.getInstance()).load(url).into(imageView);
    }
}
