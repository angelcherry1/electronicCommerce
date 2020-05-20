package com.xhc.bigbusinessu.activity.bbs;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luck.picture.lib.PictureSelector;
import com.luck.picture.lib.config.PictureConfig;
import com.luck.picture.lib.entity.LocalMedia;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.GlideEngine;
import com.xhc.bigbusinessu.utils.GlideUtils;
import com.xhc.bigbusinessu.utils.PhotoChooseUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class PushBBSActivity extends BaseActivity {

    @BindView(R.id.img_add)
    ImageView imgAdd;

    @BindView(R.id.list_view)
    RecyclerView listView;
    List<LocalMedia> dataList;
    MyAdapter myAdapter;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_push_bbs);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("发布论坛");
        setTitleRightText("发布", new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        listView.setLayoutManager(linearLayoutManager);
        dataList = new ArrayList<>();
        myAdapter = new MyAdapter(R.layout.item_upload_img, dataList);
        listView.setAdapter(myAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

        imgAdd.setOnClickListener(view -> {

            PhotoChooseUtils.openAlbum(PushBBSActivity.this, 3);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


//        // 图片选择结果回调
//        if (requestCode == PictureConfig.CHOOSE_REQUEST && resultCode == RESULT_OK && data != null) {
//            List<String> pathList = data.getStringArrayListExtra("result");
//
//            dataList.clear();
//            dataList.addAll(pathList);
//            myAdapter.notifyDataSetChanged();
//        }

        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case PictureConfig.CHOOSE_REQUEST:
                    // 图片选择结果回调
//                    selectList = PictureSelector.obtainMultipleResult(data);
                    dataList.clear();
                    dataList.addAll(PictureSelector.obtainMultipleResult(data));
                    // 例如 LocalMedia 里面返回五种path
                    // 1.media.getPath(); 原图path
                    // 2.media.getCutPath();裁剪后path，需判断media.isCut();切勿直接使用
                    // 3.media.getCompressPath();压缩后path，需判断media.isCompressed();切勿直接使用
                    // 4.media.getOriginalPath()); media.isOriginal());为true时此字段才有值
                    // 5.media.getAndroidQToPath();Android Q版本特有返回的字段，但如果开启了压缩或裁剪还是取裁剪或压缩路径；注意：.isAndroidQTransform 为false 此字段将返回空
                    // 如果同时开启裁剪和压缩，则取压缩路径为准因为是先裁剪后压缩
                    for (LocalMedia media : dataList) {
                        Log.i(TAG, "是否压缩:" + media.isCompressed());
                        Log.i(TAG, "压缩:" + media.getCompressPath());
                        Log.i(TAG, "原图:" + media.getPath());
                        Log.i(TAG, "是否裁剪:" + media.isCut());
                        Log.i(TAG, "裁剪:" + media.getCutPath());
                        Log.i(TAG, "是否开启原图:" + media.isOriginal());
                        Log.i(TAG, "原图路径:" + media.getOriginalPath());
                        Log.i(TAG, "Android Q 特有Path:" + media.getAndroidQToPath());
                    }
                    myAdapter.notifyDataSetChanged();
                    break;
            }

        }
    }

    class MyAdapter extends BaseQuickAdapter<LocalMedia, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<LocalMedia> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, LocalMedia item) {

            ImageView img = helper.getView(R.id.img);
            GlideUtils.loadImg(img, item.getPath());

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PictureSelector.create(PushBBSActivity.this)
                            .themeStyle(R.style.picture_default_style)
                            .isNotPreviewDownload(true)
                            .loadImageEngine(GlideEngine.createGlideEngine())
                            .openExternalPreview(helper.getAdapterPosition(), dataList);
                }
            });
        }
    }
}
