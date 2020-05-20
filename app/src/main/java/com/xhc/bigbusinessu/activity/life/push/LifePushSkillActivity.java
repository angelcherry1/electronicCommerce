package com.xhc.bigbusinessu.activity.life.push;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.SkillAndNeedEntity;
import com.xhc.bigbusinessu.Entity.UploadAvatarEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.HttpUtils;
import com.xhc.bigbusinessu.HttpUtils.LifeApi;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.me.setting.PersonalInfoActivity;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.ChoosePhotoDialog;
import com.xhc.bigbusinessu.utils.GlideUtils;
import com.xhc.bigbusinessu.utils.PhotoChooseUtils;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class LifePushSkillActivity extends BaseActivity {
    @BindView(R.id.lp_skill)
    ImageView lp_skill;
    @BindView(R.id.lp_type)
    TextView lp_type;
    @BindView(R.id.lp_skill2)
    EditText lp_skill2;
    @BindView(R.id.lp_indruction)
    EditText lp_indruction;
    @BindView(R.id.lp_picture)
    ImageView lp_picture;
    @BindView(R.id.lp_video)
    ImageView lp_video;
    @BindView(R.id.lp_offline)
    EditText lp_offline;
    @BindView(R.id.lp_tel_prices)
    EditText lp_tel_prices;
    @BindView(R.id.tv_ok_skill)
    TextView tv_ok;

    String filePath;
    Boolean imageIs=false;
    String videoPath;
    String[] items=new String[]{"上门服务","线上服务","居家服务"};//技能选择类型

    //提交的技能列表
    String type="1";
    String cat_id1="1";
    String cat_id2="1";
    String discipline="我擅长全身按摩";
    String introduction="保证让你爽歪歪";
    String phonts="sfsf";
    String video="asdfs";
    String offline="20.00";
    String tel="12.00";
    String sex="";
    String content="";
    String time="";


    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_life_push_skill);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("发布技能");
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }

    @OnClick({R.id.lp_skill,R.id.lp_picture,R.id.lp_video,R.id.tv_ok_skill})
    public void onClickView(View v){
        switch (v.getId()) {
            case R.id.lp_skill:
                optionSkill();
                break;
            case R.id.lp_picture:
                selectePicture();
                break;
            case R.id.lp_video:
                selecteVideo();
                break;
            case R.id.tv_ok_skill:
                subData();
                break;

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    if(selectList!=null && selectList.size()>0){
                        filePath = selectList.get(0).getPath(); // 图片地址

                        GlideUtils.loadImg(lp_picture, filePath);
                    }

                    // 例如 LocalMedia 里面返回五种path
                    // 1.media.getPath(); 原图path
                    // 2.media.getCutPath();裁剪后path，需判断media.isCut();切勿直接使用
                    // 3.media.getCompressPath();压缩后path，需判断media.isCompressed();切勿直接使用
                    // 4.media.getOriginalPath()); media.isOriginal());为true时此字段才有值
                    // 5.media.getAndroidQToPath();Android Q版本特有返回的字段，但如果开启了压缩或裁剪还是取裁剪或压缩路径；注意：.isAndroidQTransform 为false 此字段将返回空
                    // 如果同时开启裁剪和压缩，则取压缩路径为准因为是先裁剪后压缩
                    break;
            }

        }
    }

    //选择技能类型
    private void optionSkill() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("选择技能类型");
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ToastMessage("您选择了:"+items[i]);
            }
        });
        builder.setPositiveButton("确定",null);
        builder.create().show();//创建显示对话框
    }

    //上传图片
    private void selectePicture() {
        new ChoosePhotoDialog(this).show(type -> {

            if (type == 1) {
                PhotoChooseUtils.openCamera(LifePushSkillActivity.this);
            } else if (type == 2) {
                PhotoChooseUtils.openAlbum(LifePushSkillActivity.this, 1);
            }

        });
    }

    //上传录像
    private void selecteVideo() {
        new ChoosePhotoDialog(this).show(type -> {

            if (type == 1) {
                PhotoChooseUtils.openCamera(LifePushSkillActivity.this);
            } else if (type == 2) {
                PhotoChooseUtils.openAlbum(LifePushSkillActivity.this, 1);
            }

        });
    }

    //上传数据
    private void subData(){

//        cat_id1=lp_type.getText().toString().trim();
//        if (TextUtils.isEmpty(lp_type.getText().toString().trim())) {
//            ToastMessage("请先选择技能类型！");
//            return;
//        }
//        discipline=lp_skill2.getText().toString().trim();
//        if (TextUtils.isEmpty(lp_skill2.getText().toString().trim())) {
//
//            ToastMessage("请输入你的专业详情描述！");
//            return;
//        }
//        introduction=lp_indruction.getText().toString().trim();
//        if (TextUtils.isEmpty(lp_indruction.getText().toString().trim())) {
//
//            ToastMessage("请输入你的需求描述！");
//            return;
//        }
//        offline=lp_offline.getText().toString().trim();
//        if (TextUtils.isEmpty(lp_offline.getText().toString().trim())) {
//
//            ToastMessage("请输入线下服务收费标准！");
//            return;
//        }
//        tel=lp_tel_prices.getText().toString().trim();
//        if (TextUtils.isEmpty(lp_tel_prices.getText().toString().trim())) {
//
//            ToastMessage("请输入电话咨询收费标准！");
//            return;
//        }
//
//        if (!TextUtils.isEmpty(filePath)) {
//            showProgressDialog("上传中");
//            UserApi.getInstance().uploadAvatar(new BaseCallback<UploadAvatarEntity>(UploadAvatarEntity.class) {
//                @Override
//                protected void onError(Exception e) {
//
//                    disProgressDialog();
//                    ToastMessage("上传失败");
//                }
//
//                @Override
//                protected void onSuccess(UploadAvatarEntity response) {
//                    disProgressDialog();
//                    if (response.getStatus() == 1) {
//                        imageIs=true;
//                        phonts=filePath.trim();
//                    } else {
//                        ToastMessage(response.getMsg());
//                    }
//
//                }
//            }, new File(filePath));
//        }
//      if(!TextUtils.isEmpty(videoPath)){
////          UserApi.getInstance().uploadvideo(new BaseCallback<UploadAvatarEntity>(UploadAvatarEntity.class) {
////              @Override
////              protected void onError(Exception e) {
////
////                  disProgressDialog();
////                  ToastMessage("上传失败");
////              }
////
////              @Override
////              protected void onSuccess(UploadAvatarEntity response) {
////                  disProgressDialog();
////                  if (response.getStatus() == 1) {
////                      imageIs=true;
////                      video=videoPath.trim();
////                  } else {
////                      ToastMessage(response.getMsg());
////                  }
////
////              }
////          }, new File(videoPath));
//
//        video="";
//      }
        LifeApi.getInstance().pubSkills(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络连接失败");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                if (response.getStatus() == 1) {
                    ToastMessage("成功上传");
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        },type,cat_id1,cat_id2,discipline,introduction,phonts,video,offline,tel,sex,content,time);
    }

}
