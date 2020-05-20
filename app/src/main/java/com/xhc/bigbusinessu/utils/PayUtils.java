package com.xhc.bigbusinessu.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;

import com.alipay.sdk.app.PayTask;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xhc.bigbusinessu.Entity.PayResultEntity;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.utils.pay.PayEvent;
import com.xhc.bigbusinessu.utils.pay.PayResult;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Map;

public class PayUtils {


    private static PayUtils instance;

    OnPayUtilsListener onPayUtilsListener;




    private static final int SDK_PAY_FLAG = 1;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    @SuppressWarnings("unchecked")
                    PayResult payResult = new PayResult((Map<String, String>) msg.obj);
                    /**
                     * 对于支付结果，请商户依赖服务端的异步通知结果。同步通知结果，仅作为支付结束的通知。
                     */
                    String resultInfo = payResult.getResult(); //同步返回需要验证的信息
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为9000则代表支付成功
                    Log.e("Test","支付宝回调："+resultStatus);
                    if (TextUtils.equals(resultStatus, "9000")) {
                        // 该笔订单是否真实支付成功，需要依赖服务端的异步通知。
                        EventBus.getDefault().post(new PayEvent(0,1,"支付宝支付成功"));
                    } else {
                        // 该笔订单真实的支付结果，需要依赖服务端的异步通知。
                        EventBus.getDefault().post(new PayEvent(0,0,"支付宝支付失败"));
                    }
                    break;
                }

                default:
                    break;
            }
        }

        ;
    };






    public PayUtils() {
        EventBus.getDefault().register(this);

        //更多LocationClientOption的配置，请参照类参考中LocationClientOption类的详细说明
    }

    public synchronized static PayUtils getInstance() {
        if (null == instance) {
            instance = new PayUtils();
        }
        return instance;
    }


    /**
     * 支付宝支付
     * @param activity
     * @param order_info
     */
    public void doAliPay(Activity activity, String order_info) {

        Runnable payRunnable = new Runnable() {

            @Override
            public void run() {
                PayTask alipay = new PayTask(activity);
                Map<String, String> result = alipay.payV2(order_info, true);

                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        // 必须异步调用
        Thread payThread = new Thread(payRunnable);
        payThread.start();

    }


    /**
     * 微信支付
     * @param activity
     * @param bean
     */
    public void doWeChatPay(Activity activity, PayResultEntity.DataBean.WxpayBean bean) {

        IWXAPI msgApi;
        msgApi = WXAPIFactory.createWXAPI(activity, null);
        // 将该app注册到微信
        msgApi.registerApp(MyApplication.APP_ID);

        PayReq request = new PayReq();

        request.appId = bean.getAppid();//子商户appid

        request.partnerId = bean.getPartnerid();//子商户号

        request.prepayId= bean.getPrepayid();

        request.packageValue = bean.getPackageX();

        request.nonceStr= bean.getNoncestr();

        request.timeStamp= String.valueOf(bean.getTimestamp());

        request.sign= bean.getSign();

        msgApi.sendReq(request);

    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onPayEventMessage(PayEvent payEvent){
        //将数据显示到页面上
        //微信支付
        if(payEvent.getType() == 0){
            if(onPayUtilsListener!=null){
                onPayUtilsListener.onWechatStatus(payEvent);
            }
        }
        //支付宝支付
        else if(payEvent.getType() == 1){
            if(onPayUtilsListener!=null){
                onPayUtilsListener.onAliStatus(payEvent);
            }
        }
    }

//    public void onDestroy(){
//        //注销事件
//        EventBus.getDefault().unregister(this);
//    }

    public void setOnPayUtilsListener(PayUtils.OnPayUtilsListener onPayUtilsListener) {
        this.onPayUtilsListener = onPayUtilsListener;
    }

    public interface  OnPayUtilsListener{
        void onWechatStatus(PayEvent payEvent);
        void onAliStatus(PayEvent payEvent);
    }

}
