package com.xhc.bigbusinessu.Entity;

import com.google.gson.annotations.SerializedName;

public class PayResultEntity {


    /**
     * status : 1
     * msg : 成功
     * code :
     * data : {"alipay":"alipay_sdk=alipay-sdk-php-20180705&app_id=2019102968728753&biz_content=%7B%22body%22%3A%22pay%22%2C%22subject%22%3A%22web%22%2C%22out_trade_no%22%3A%22201911051024201198%22%2C%22timeout_express%22%3A%222h%22%2C%22total_amount%22%3A0.01%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22store_id%22%3A%22001%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F47.111.170.54%3A1003%2Fapi%2Fpayment%2FalipayNotify&sign_type=RSA2&timestamp=2019-11-05+10%3A24%3A20&version=1.0&sign=O4Bk4iUjbA2MQOv31Ai94aTqiWpvUrVIdyj%2BclZp06%2B%2FHonM%2F4Jwg35pUA%2FuiZxsFFtXtBQIONRus2f4E1SOqIdGiFLUYZ84lbmYxGSbR9wO4zT9r%2BUQWBUwOlMEqRZ5pEgnNLZM9cKxoo02s5ictWmnpVFcabvKZyK%2BvkHODtqUZ7k6DdR%2BBX46N8ZJRN0Vpxr4md3nmwDuVgTb8La9N4AVOFOAQHNrGcFpNqGdOHWNT1JGIl%2BK2b%2BjNyH95E5%2FBY38kv5gdde4K20FBLX%2BwYwAI6ErWjrGbcvEW880wvRMuxMYHsOodOJEpSJEksNk2gJimsWiBcXGhy5R6ztMCQ%3D%3D","wxpay":{"appid":"wxfae2440f97a3738a","noncestr":"mPDn6jqjZ6K3pRzt","package":"Sign=WXPay","partnerid":"1426701502","prepayid":"wx0510242058694677f5178a8b1924538800","timestamp":1572920660,"sign":"18E02C002948AF6DF25D89D5A8C79867"}}
     */

    private int status;
    private String msg;
    private String code;
    private DataBean data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * alipay : alipay_sdk=alipay-sdk-php-20180705&app_id=2019102968728753&biz_content=%7B%22body%22%3A%22pay%22%2C%22subject%22%3A%22web%22%2C%22out_trade_no%22%3A%22201911051024201198%22%2C%22timeout_express%22%3A%222h%22%2C%22total_amount%22%3A0.01%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22store_id%22%3A%22001%22%7D&charset=utf-8&format=json&method=alipay.trade.app.pay&notify_url=http%3A%2F%2F47.111.170.54%3A1003%2Fapi%2Fpayment%2FalipayNotify&sign_type=RSA2&timestamp=2019-11-05+10%3A24%3A20&version=1.0&sign=O4Bk4iUjbA2MQOv31Ai94aTqiWpvUrVIdyj%2BclZp06%2B%2FHonM%2F4Jwg35pUA%2FuiZxsFFtXtBQIONRus2f4E1SOqIdGiFLUYZ84lbmYxGSbR9wO4zT9r%2BUQWBUwOlMEqRZ5pEgnNLZM9cKxoo02s5ictWmnpVFcabvKZyK%2BvkHODtqUZ7k6DdR%2BBX46N8ZJRN0Vpxr4md3nmwDuVgTb8La9N4AVOFOAQHNrGcFpNqGdOHWNT1JGIl%2BK2b%2BjNyH95E5%2FBY38kv5gdde4K20FBLX%2BwYwAI6ErWjrGbcvEW880wvRMuxMYHsOodOJEpSJEksNk2gJimsWiBcXGhy5R6ztMCQ%3D%3D
         * wxpay : {"appid":"wxfae2440f97a3738a","noncestr":"mPDn6jqjZ6K3pRzt","package":"Sign=WXPay","partnerid":"1426701502","prepayid":"wx0510242058694677f5178a8b1924538800","timestamp":1572920660,"sign":"18E02C002948AF6DF25D89D5A8C79867"}
         */

        private String alipay;
        private WxpayBean wxpay;

        public String getAlipay() {
            return alipay;
        }

        public void setAlipay(String alipay) {
            this.alipay = alipay;
        }

        public WxpayBean getWxpay() {
            return wxpay;
        }

        public void setWxpay(WxpayBean wxpay) {
            this.wxpay = wxpay;
        }

        public static class WxpayBean {
            /**
             * appid : wxfae2440f97a3738a
             * noncestr : mPDn6jqjZ6K3pRzt
             * package : Sign=WXPay
             * partnerid : 1426701502
             * prepayid : wx0510242058694677f5178a8b1924538800
             * timestamp : 1572920660
             * sign : 18E02C002948AF6DF25D89D5A8C79867
             */

            private String appid;
            private String noncestr;
            @SerializedName("package")
            private String packageX;
            private String partnerid;
            private String prepayid;
            private int timestamp;
            private String sign;

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public int getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(int timestamp) {
                this.timestamp = timestamp;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }
        }
    }
}
