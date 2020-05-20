package com.xhc.bigbusinessu.HttpUtils;


import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.CarListEntity;
import com.xhc.bigbusinessu.MyApplication;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Call;
import okhttp3.Response;

public abstract class BaseCallback<T> extends Callback<T> {

    String tag = BaseCallback.class.getSimpleName();
    Class c;


    public BaseCallback(Class c) {
        this.c = c;
    }

    @Override
    public T parseNetworkResponse(Response response) {
        try {
            String content = response.body().string();
            Log.d(tag, content);

            BaseEntity baseEntity = (BaseEntity)new Gson().fromJson(content, BaseEntity.class);

            if(baseEntity!=null){
                if("token已失效".equals(baseEntity.getMsg())){
                    Log.e("Test","-----------------------------------需要退出登录");
                }
            }
            return (T) new Gson().fromJson(content, c);


        } catch (Exception e) {
            Log.e(tag, e.getMessage());
            return null;
        }
    }

    @Override
    public void onError(Call call, Exception e) {

        onError(e);
    }

    @Override
    public void onResponse(T response) {
        if(null==response){
            //onDataError(response);
            Toast.makeText(MyApplication.getInstance(),"数据异常",Toast.LENGTH_SHORT).show();
            onError(null);
        }
        else{

            onSuccess(response);
        }

    }

    protected abstract void onError(Exception e);


    protected abstract void onSuccess(T response);

//    public interface OnBaseCallbackListener<T>{
//        void onError(Exception e);
//        void onDataError(String errorMsg);
//        void onSuccess(T response);
//    }
}
