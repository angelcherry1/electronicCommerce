package com.xhc.bigbusinessu.HttpUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:lixiaobiao
 * @date:On 2020/4/1
 * @Desriptiong: 23231
 */
public class RunningSheetApi {
    /**
     * 跑单下单
     * @param baseCallback
     * @param start_address 开始地址
     * @param phone1 开始联系方式
     * @param end_address 结束地址
     * @param phone2 结束联系方式
     * @param type 1 帮我送 2帮我取 3帮我买
     */
    public void addRunningOrder(BaseCallback baseCallback,String start_address,String phone1,String end_address,String phone2,String type){
        Map<String,String> map=new HashMap<>();
        map.put("start_address",start_address);
        map.put("phone1",phone1);
        map.put("end_address",end_address);
        map.put("phone2",phone2);
        map.put("type",type);
        HttpUtils.getInstance().post(map,"/api/order/errand",baseCallback);
    }
}
