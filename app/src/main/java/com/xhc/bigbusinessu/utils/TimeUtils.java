package com.xhc.bigbusinessu.utils;

import java.text.SimpleDateFormat;

/**
 * Created by tuhualong on 2018/9/3.
 */

public class TimeUtils {

    /**
     * GMT(格林威治标准时间)转换当前北京时间
     * 比如：1526217409 -->2018/5/13 21:16:49 与北京时间相差8个小时，调用下面的方法，是在1526217409加上8*3600秒
     * @param GMT 秒单部位
     * @return
     */
    public static String stampToDate(String GMT) {

        long lt = Long.parseLong(GMT)+8*3600;
        String res = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");

            res = simpleDateFormat.format(lt*1000);
        }catch (Exception e){
            e.printStackTrace();
        }

        return res;
    }

}
