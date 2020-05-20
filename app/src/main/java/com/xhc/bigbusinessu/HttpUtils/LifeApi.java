package com.xhc.bigbusinessu.HttpUtils;

import android.util.ArrayMap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:lixiaobiao
 * @date:On 2020/3/31
 * @Desriptiong: 23231
 */
public class LifeApi {

    private static LifeApi instance=null;

    public static LifeApi getInstance(){
        if(instance==null){
            synchronized (LifeApi.class){
                if(instance==null){
                    instance=new LifeApi();
                }
            }

        }
        return instance;
    }

    /**
     *技能需求提交
     * @param baseCallback
     * @param type 1技能 2需求
     * @param cat_id1 一级分类id （技能必填）
     * @param cat_id2 二级分类id （技能必填）
     * @param discipline 擅长专业 （技能必填）
     * @param introcduction 服务介绍 （技能必填）
     * @param phonts 服务图片 （技能必填）
     * @param video 服务视频 （技能必填）
     * @param offline 线下服务费用
     * @param tel 电话咨询费用
     * @param sex 性别 （需求必填）
     * @param content 需求内容 （需求必填）
     * @param time 需求有效期 （需求必填）
     */
    public  void pubSkills(BaseCallback baseCallback,String type,String cat_id1,String cat_id2,String discipline,String introcduction,String phonts,String video,String offline,String tel,String sex,String content,String time){

//        type Y  1技能 2需求
//        cat_id1 	一级分类id （技能必填）
//        cat_id2 二级分类id （技能必填）
//        discipline 擅长专业 （技能必填）
//       introcduction 服务介绍 （技能必填）
//        phonts 服务图片 （技能必填）
//        video 服务视频 （技能必填）
//        offline 线下服务费用
//        tel 电话咨询费用
//        sex 性别 （需求必填）
//        content 需求内容 （需求必填）
//        time 需求有效期 （需求必填）
        Map<String, String> map = new HashMap<>();
        map.put("type", type);
        map.put("cat_id1", cat_id1);
        map.put("cat_id2", cat_id2);
        map.put("discipline", discipline);
        map.put("introcduction", introcduction);
        map.put("phonts", phonts);
        map.put("video", video);
        map.put("offline", offline);
        map.put("tel", tel);
        map.put("sex", sex);
        map.put("content", content);
        map.put("time", time);
        HttpUtils.getInstance().post(map, "api/life/pub_skill", baseCallback);

    }

    /**
     *技能需求列表获取
     * @param baseCallback
     * @param type 1技能 2需求
     */
    public void getSkillList(BaseCallback  baseCallback,String type){
        Map<String,String> map=new HashMap<>();
        //        type Y  1技能 2需求
        map.put("type",type);
        HttpUtils.getInstance().post(map,"/api/life/skill_lst",baseCallback);
    }

    /**
     *获取生活分类
     * @param baseCallback
     * @param type
     */
    public void getSkillCate(BaseCallback baseCallback,String type){
        Map<String,String> map=new HashMap<>();
        map.put("type",type);
        HttpUtils.getInstance().post(map,"api/life/get_cate",baseCallback);
    }

    /**
     *
     * @param baseCallback
     * @param talent 预约达人（用户ID）
     * @param s_id 技能 ID
     * @param price 单价
     * @param num 预约次数
     * @param time 预约时间
     * @param address 预约地点
     * @param contact 联系人
     * @param mobile 联系电话
     * @param pay_type 付款方式 1 weixin 2 alipay
     */
    public void orderSkill(BaseCallback baseCallback,String talent,String s_id,String price,String num,String time,String address,String contact,String mobile,String pay_type){
        Map<String,String> map=new HashMap<>();
        map.put("talent",talent);
        map.put("s_id",s_id);
        map.put("price",price);
        map.put("num",num);
        map.put("time",time);
        map.put("address",address);
        map.put("contact",contact);
        map.put("mobile",mobile);
        map.put("pay_type",pay_type);
    HttpUtils.getInstance().post(map,"api/life/app_skills",baseCallback);
    }
}
