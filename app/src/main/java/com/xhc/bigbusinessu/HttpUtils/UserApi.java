package com.xhc.bigbusinessu.HttpUtils;

import android.text.TextUtils;

import com.xhc.bigbusinessu.utils.MD5Utils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class UserApi {



    private static UserApi instance = null;

    public static UserApi getInstance() {
        if (instance == null) {
            synchronized (UserApi.class) {
                if (instance == null) {
                    instance = new UserApi();
                }
            }
        }
        return instance;
    }

    /**
     * 用户注册
     * @param baseCallback
     * @param phone
     * @param pwdStr
     * @param pwd2Str
     */
    public  void doRegister(BaseCallback baseCallback,String phone,String pwdStr,String pwd2Str){

        String pwd1 = String.format("SHOP"+pwdStr);
        String pwd2 = String.format("SHOP"+pwd2Str);
        Map<String, String> map = new HashMap<>();
        map.put("username", phone);
//        map.put("password",  pwdStr);
//        map.put("password2",  pwd2Str);
        map.put("password",  MD5Utils.md5Decode32(pwd1));
        map.put("password2",  MD5Utils.md5Decode32(pwd2));
        HttpUtils.getInstance().post(map, "/api/user/reg", baseCallback);


    }

    /**
     * 用户登录
     * @param baseCallback
     * @param phone
     * @param pwdStr
     */
    public  void doLogin(BaseCallback baseCallback,String phone,String pwdStr){

        String pwd1 = String.format("SHOP"+pwdStr);
        Map<String, String> map = new HashMap<>();
        map.put("username", phone);
        map.put("password", MD5Utils.md5Decode32(pwd1));
//        map.put("password", pwdStr);
        HttpUtils.getInstance().post(map, "/api/user/login", baseCallback);

    }

    /**
     * 获取用户信息
     * @param baseCallback
     * @param userId 不传或0则查询当前用户信息，大于0则查询对应ID用户信息
     */
    public void getUserInfo(BaseCallback baseCallback,String userId){

        Map<String, String> map = new HashMap<>();
        map.put("user_id", userId);
        HttpUtils.getInstance().post(map, "/api/user/userinfo", baseCallback);
    }

    /**
     * 更新用户信息
     * @param baseCallback
     * @param nickName
     * @param headPic
     */
    public void updateUserInfo(BaseCallback baseCallback, String nickName, String headPic){

        Map<String, String> map = new HashMap<>();

        if(!TextUtils.isEmpty(nickName))
        map.put("nickname", nickName);
        if(!TextUtils.isEmpty(headPic))
        map.put("head_pic", headPic);

        HttpUtils.getInstance().post(map,"/api/user/updateuser",baseCallback);

    }

    /**
     * 上传用户头像
     * @param baseCallback
     * @param file
     */
    public void uploadAvatar(BaseCallback baseCallback,File file){
        Map<String, File> map = new HashMap<>();
        map.put("img",file);
        HttpUtils.getInstance().updateFile(map,"/api/index/uploadone",baseCallback);
    }

    /**
     * 修改用户登录密码
     * @param baseCallback
     * @param old_password
     * @param new_password
     * @param confirm_password
     */
    public void changePwd(BaseCallback baseCallback,String old_password,String new_password,String confirm_password){

        Map<String, String> map = new HashMap<>();
        String pwd1 = String.format("SHOP"+old_password);
        String pwd2 = String.format("SHOP"+new_password);
        String pwd3 = String.format("SHOP"+confirm_password);
        map.put("old_password", MD5Utils.md5Decode32(pwd1));
        map.put("new_password", MD5Utils.md5Decode32(pwd2));
        map.put("confirm_password", MD5Utils.md5Decode32(pwd3));
//        map.put("old_password", old_password);
//        map.put("new_password", new_password);
//        map.put("confirm_password", confirm_password);
        HttpUtils.getInstance().post(map, "/api/user/password", baseCallback);
    }

    /**
     * 获取商城购物的收货地址列表
     * @param baseCallback
     */
    public void getMyShopList(BaseCallback baseCallback){
        Map<String, String> map = new HashMap<>();
        HttpUtils.getInstance().post(map, "/api/user/getAddressList", baseCallback);
    }

//    consignee Y  收货人
//    mobile Y  手机号
//    province Y  省ID
//    city Y  市ID
//    district Y  区/县ID
//    address Y  具体地址（不需要省市区）
//    address_id N  修改时必传，不传为新加
//    is_default N 0 是否默认地址

    /**
     *
     * @param baseCallback
     * @param consignee  收货人
     * @param mobile 手机号
     * @param province 省ID
     * @param city 市ID
     * @param district 区/县ID
     * @param address   具体地址（不需要省市区）
     * @param address_id 修改时必传，不传为新加
     * @param is_default 是否默认地址
     */
    public void addShopAddress(BaseCallback baseCallback,String consignee,String mobile,String province,String city,String district,String address,String address_id,int is_default){

        Map<String, String> map = new HashMap<>();
        map.put("consignee",consignee);
        map.put("mobile",mobile);
        map.put("province",province);
        map.put("city",city);
        map.put("district",district);
        map.put("address",address);
        map.put("address_id",address_id);
        map.put("is_default",String.valueOf(is_default));
        HttpUtils.getInstance().post(map, "/api/user/addAddress", baseCallback);
    }

    /**
     *
     * @param baseCallback
     * @param address_id 删除收货地址id
     */
    public void delAddress(BaseCallback baseCallback,String  address_id){

        Map<String,String> map=new HashMap<>();
        map.put("address_id",address_id);
        HttpUtils.getInstance().post(map,"/api/user/delAddress",baseCallback);
    }
}
