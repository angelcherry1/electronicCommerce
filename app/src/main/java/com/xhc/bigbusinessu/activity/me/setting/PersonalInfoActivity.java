package com.xhc.bigbusinessu.activity.me.setting;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.library.YLCircleImageView;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.UploadAvatarEntity;
import com.xhc.bigbusinessu.Entity.UserInfoEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.ChooseGoodsDialog;
import com.xhc.bigbusinessu.dialog.ChoosePhotoDialog;
import com.xhc.bigbusinessu.utils.GlideUtils;
import com.xhc.bigbusinessu.utils.PhotoChooseUtils;

import java.io.File;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.xhc.bigbusinessu.utils.PhotoChooseUtils.REQUEST_CAMERA_CODE;
import static com.xhc.bigbusinessu.utils.PhotoChooseUtils.REQUEST_LIST_CODE;

public class PersonalInfoActivity extends BaseActivity {


    @BindView(R.id.img_avatar)
    YLCircleImageView imgAvatar;
    @BindView(R.id.et_nick_name)
    EditText etNickName;


    String filePath;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_personal_info);
    }

    @Override
    protected void initUI() {
        setTitleText("个人信息");
        showTitleBack();
        setTitleRightText("保存", view -> {

            if (TextUtils.isEmpty(etNickName.getText().toString().trim())) {

                ToastMessage("请先填写昵称");
                return;
            }

            if (!TextUtils.isEmpty(filePath)) {
                showProgressDialog("上传中");
                UserApi.getInstance().uploadAvatar(new BaseCallback<UploadAvatarEntity>(UploadAvatarEntity.class) {
                    @Override
                    protected void onError(Exception e) {

                        disProgressDialog();
                        ToastMessage("上传失败");
                    }

                    @Override
                    protected void onSuccess(UploadAvatarEntity response) {
                        disProgressDialog();
                        if (response.getStatus() == 1) {
                            saveUserInfo(etNickName.getText().toString().trim(), response.getData().getUrl());
                        } else {
                            ToastMessage(response.getMsg());
                        }

                    }
                }, new File(filePath));
            } else {

                saveUserInfo(etNickName.getText().toString().trim(), "");
            }


        });

    }

    @Override
    protected void initData() {

        getUserInfo();
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }

    @OnClick({R.id.rel_choose_avatar})
    public void onViewClicked(View v) {

        switch (v.getId()) {

            case R.id.rel_choose_avatar:
                new ChoosePhotoDialog(this).show(type -> {

                    if (type == 1) {
                        PhotoChooseUtils.openCamera(PersonalInfoActivity.this);
                    } else if (type == 2) {
                        PhotoChooseUtils.openAlbum(PersonalInfoActivity.this, 1);
                    }

                });
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

//        if (requestCode == REQUEST_CAMERA_CODE && resultCode == RESULT_OK && data != null) {
//            filePath = data.getStringExtra("result"); // 图片地址
//            GlideUtils.loadImg(imgAvatar, filePath);
//        }
//
//        // 图片选择结果回调
//        if (requestCode == REQUEST_LIST_CODE && resultCode == RESULT_OK && data != null) {
//            List<String> pathList = data.getStringArrayListExtra("result");
//            for (String path : pathList) {
//                filePath = path;
//                GlideUtils.loadImg(imgAvatar, path);
//            }
//        }

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
                    List<LocalMedia> selectList = PictureSelector.obtainMultipleResult(data);
                    if(selectList!=null && selectList.size()>0){
                        filePath = selectList.get(0).getPath(); // 图片地址
                        GlideUtils.loadImg(imgAvatar, filePath);
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

    private void getUserInfo() {

        UserApi.getInstance().getUserInfo(new BaseCallback<UserInfoEntity>(UserInfoEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(UserInfoEntity response) {

                if (response.getData() != null) {
                    GlideUtils.loadImg(imgAvatar, response.getData().getHead_pic());
                    etNickName.setText(response.getData().getNickname());
                } else {

                }

            }
        }, "");
    }


    private void saveUserInfo(String nickName, String headPic) {

        showProgressDialog("保存中");

        UserApi.getInstance().updateUserInfo(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {
                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {
                    getUserInfo();
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, nickName, headPic);
    }

}
