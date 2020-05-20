package com.xhc.bigbusinessu.activity.shop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.GoodsClassifyEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class AllGoodsClassActivity extends BaseActivity {

    @BindView(R.id.left_list_view)
    RecyclerView leftListView;
    @BindView(R.id.right_list_view)
    RecyclerView rightListView;

    LeftAdapter leftAdapter;
    RightAdapter rightAdapter;

    List<GoodsClassifyEntity.DataBean> leftDataList = new ArrayList<>();
    List<GoodsClassifyEntity.DataBean.SubCategoryBean> rightDataList = new ArrayList<>();

    int selectIndex;

    int viewType;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_all_goods_classify);

        //页面来源
        viewType = getIntent().getIntExtra("view_type",0);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("全部分类");

        leftListView.setLayoutManager(new LinearLayoutManager(this));
        rightListView.setLayoutManager(new LinearLayoutManager(this));

        leftAdapter = new LeftAdapter(R.layout.item_class_left_view, leftDataList);
        leftListView.setAdapter(leftAdapter);

        rightAdapter = new RightAdapter(R.layout.item_class_right_view, rightDataList);
        rightListView.setAdapter(rightAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

        getGoodsClassifyList(String.valueOf(viewType));
    }

    private void getGoodsClassifyList(String type) {


        ShopApi.getInstance().getGoodsClassifyList(new BaseCallback<GoodsClassifyEntity>(GoodsClassifyEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(GoodsClassifyEntity response) {

                if (response.getStatus() == 1) {
                    leftDataList.clear();
                    leftDataList.addAll(response.getData());
                    leftAdapter.notifyDataSetChanged();
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        },type);
    }

    class LeftAdapter extends BaseQuickAdapter<GoodsClassifyEntity.DataBean, BaseViewHolder> {

        public LeftAdapter(int layoutResId, @Nullable List<GoodsClassifyEntity.DataBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, GoodsClassifyEntity.DataBean item) {

            LinearLayout linBg = helper.getView(R.id.lin_bg);
            TextView tvTitle = helper.getView(R.id.tv_title);
            ImageView imgMore = helper.getView(R.id.img_more);

            tvTitle.setText(item.getName());

            if (selectIndex == helper.getAdapterPosition()) {
                linBg.setBackgroundResource(R.color.app_bg);
                imgMore.setImageResource(R.mipmap.icon_samll_more_yellow);
                rightDataList.clear();
                if (item.getSub_category() != null)
                    rightDataList.addAll(item.getSub_category());
                rightAdapter.notifyDataSetChanged();

            } else {
                linBg.setBackgroundColor(Color.parseColor("#FFFFFF"));
                imgMore.setImageResource(R.mipmap.icon_samll_more);
            }
            helper.itemView.setOnClickListener(view -> {
                selectIndex = helper.getAdapterPosition();
                notifyDataSetChanged();

            });


        }
    }

    class RightAdapter extends BaseQuickAdapter<GoodsClassifyEntity.DataBean.SubCategoryBean, BaseViewHolder> {

        public RightAdapter(int layoutResId, @Nullable List<GoodsClassifyEntity.DataBean.SubCategoryBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, GoodsClassifyEntity.DataBean.SubCategoryBean item) {
            TextView tvTitle = helper.getView(R.id.tv_title);
            tvTitle.setText(item.getName());
            helper.itemView.setOnClickListener(view -> {

                int subId = Integer.parseInt(item.getId());

                Intent intent = new Intent();
                intent.putExtra("subId",subId);
                setResult(1003,intent);
                finish();

            });
        }
    }
}
