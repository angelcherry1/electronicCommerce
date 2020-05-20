package com.xhc.bigbusinessu.HttpUtils;


import android.util.Log;

import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.utils.MD5Utils;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.builder.PostFormBuilder;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by THL on 2016/7/4.
 * 网络缓存 实体类必须实现 继承 Serializable类
 */
public class HttpUtils {
    private final String key = "jushangshop123key";
    private String tag = HttpUtils.class.getSimpleName();

    private static HttpUtils instance = null;

    public static HttpUtils getInstance() {
        if (instance == null) {
            synchronized (HttpUtils.class) {
                if (instance == null) {
                    instance = new HttpUtils();
                }
            }
        }
        return instance;
    }

    public String Url = "http://192.168.31.68"; //测试

//    public String Url = "http://134.175.141.117"; //正式


    public void post(Map<String, String> params, final String act, BaseCallback a) {

        if (params == null) {
            params = new HashMap<>();
        }
        long time = System.currentTimeMillis() / 1000;
        Log.d(tag, "Url:" + Url + act);
        Log.d(tag, "params:" + params.toString());
        OkHttpUtils
                .post()
                .url(Url + act)
                .params(params)
                .addHeader("time", String.valueOf(time))
                .addHeader("sign", MD5Utils.md5Decode32(time + key))
                .addHeader("token", MyApplication.getInstance().getToken())
                .build()
                .execute(a);
    }

    public void get(Map<String, String> params, final String act, BaseCallback a) {

        if (params == null) {
            params = new HashMap<>();
        }
        long time = System.currentTimeMillis() / 1000;
        Log.d(tag, "Url:" + Url + "/" + act);
        Log.d(tag, "params:" + params.toString());
        OkHttpUtils
                .get()
                .url(Url + act)
                .params(params)
                .addHeader("time", String.valueOf(time))
                .addHeader("sign", MD5Utils.md5Decode32(time + key))
                .addHeader("token", MyApplication.getInstance().getToken())
                .build()
                .execute(a);
    }


    public void postFile(Map<String, String> params, Map<String, File> fileParams, final String act, BaseCallback a) {

        if (params == null) {
            params = new HashMap<>();
        }
        long time = System.currentTimeMillis() / 1000;
        Log.d(tag, "Url:" + Url + act);
        Log.d(tag, "params:" + params.toString());

        PostFormBuilder builder = OkHttpUtils
                .post();
        builder.url(Url + act);
        builder.params(params);
        builder.addHeader("time", String.valueOf(time));
        builder.addHeader("sign", MD5Utils.md5Decode32(time + key));
        builder.addHeader("token", MyApplication.getInstance().getToken());
        if (fileParams != null){
            for (Map.Entry<String, File> entry : fileParams.entrySet()) {

                if(entry.getValue()!=null){
                    System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue().getName());
                    builder.addFile(entry.getKey(), entry.getValue().getName(), entry.getValue());
                }

            }
        }
        builder.build().execute(a);
    }


    /**
     * 上传文件
     * @param fileParams
     * @param act
     * @param a
     */
    public void updateFile( Map<String, File> fileParams, final String act, BaseCallback a) {

        if (fileParams == null) {
            fileParams = new HashMap<>();
        }
        long time = System.currentTimeMillis() / 1000;
        Log.d(tag, "Url:" + Url + act);
        Log.d(tag, "params:" + fileParams.toString());

        PostFormBuilder builder = OkHttpUtils
                .post();
        builder.url(Url + act);
        builder.addHeader("time", String.valueOf(time));
        builder.addHeader("sign", MD5Utils.md5Decode32(time + key));
        builder.addHeader("token", MyApplication.getInstance().getToken());
        if (fileParams != null){
            for (Map.Entry<String, File> entry : fileParams.entrySet()) {

                if(entry.getValue()!=null){
                    System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
                    builder.addFile(entry.getKey(), entry.getValue().getName(), entry.getValue());
                }

            }
        }
        builder.build().execute(a);
    }

}
