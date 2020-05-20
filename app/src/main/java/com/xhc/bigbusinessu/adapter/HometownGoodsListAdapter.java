package com.xhc.bigbusinessu.adapter;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.android.library.YLCircleImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.GoodsListEntity;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.shop.ShopDetailsActivity;
import com.xhc.bigbusinessu.activity.shop.ShopGoodsDetailsActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.List;

public class HometownGoodsListAdapter extends BaseQuickAdapter<GoodsListEntity.DataBean.ListBean, BaseViewHolder> {

    int type;
    public HometownGoodsListAdapter(int layoutResId, @Nullable List<GoodsListEntity.DataBean.ListBean> data,int type) {
        super(layoutResId, data);
        this.type = type;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, GoodsListEntity.DataBean.ListBean item) {


        ImageView img = helper.getView(R.id.img_goods_1);
        GlideUtils.loadImg(img,item.getOriginal_img());

        helper.setText(R.id.tv_goods_name,item.getGoods_name());

        helper.setText(R.id.tv_price,"￥"+item.getCity_goods_price());
        helper.setText(R.id.tv_sales_sum,item.getSales_sum()+"人付款");
        helper.setText(R.id.tv_shop_name,item.getStore_name());


        helper.itemView.setOnClickListener(view12 -> {

            Intent intent = new Intent(mContext, ShopGoodsDetailsActivity.class);
            intent.putExtra("city_goods_id",item.getCity_goods_id());
            intent.putExtra("view_type",type);
            mContext.startActivity(intent);
        });
        helper.getView(R.id.lin_to_shop).setOnClickListener(view1 -> {

            Intent intent = new Intent(mContext, ShopDetailsActivity.class);
            intent.putExtra("store_id",item.getStore_id());
            mContext.startActivity(intent);
        });

    }
}
