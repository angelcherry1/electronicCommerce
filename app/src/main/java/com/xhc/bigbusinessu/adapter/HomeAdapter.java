package com.xhc.bigbusinessu.adapter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.library.YLCircleImageView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.HomeDataEntity;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.shop.ShopGoodsDetailsActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;

import org.w3c.dom.Text;

import java.util.List;

public class HomeAdapter extends BaseQuickAdapter<HomeDataEntity.DataBean.RecommendBean, BaseViewHolder> {


    public HomeAdapter(int layoutResId, List<HomeDataEntity.DataBean.RecommendBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, HomeDataEntity.DataBean.RecommendBean item) {

        helper.setText(R.id.tv_shop_name, item.getStore_name());


        List<HomeDataEntity.DataBean.RecommendBean.RecommendGoodsBean> list = item.getRecommend_goods();
        if (list != null) {
            if(list.size()>0){
                ImageView imgGoods1 = helper.getView(R.id.img_goods_1);
                TextView tvGoodsName1 = helper.getView(R.id.tv_goods_name_1);
                GlideUtils.loadImg(imgGoods1,list.get(0).getOriginal_img());
                tvGoodsName1.setText(list.get(0).getGoods_name());
                helper.getView(R.id.lin_goods_1).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, ShopGoodsDetailsActivity.class);
                        intent.putExtra("city_goods_id",list.get(0).getCity_goods_id());
                        mContext.startActivity(intent);
                    }
                });
            }
            if(list.size()>1){
                ImageView imgGoods2 = helper.getView(R.id.img_goods_2);
                TextView tvGoodsName2 = helper.getView(R.id.tv_goods_name_2);
                GlideUtils.loadImg(imgGoods2,list.get(1).getOriginal_img());
                tvGoodsName2.setText(list.get(1).getGoods_name());
                helper.getView(R.id.lin_goods_2).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, ShopGoodsDetailsActivity.class);
                        intent.putExtra("city_goods_id",list.get(1).getCity_goods_id());
                        mContext.startActivity(intent);
                    }
                });
            }
            if(list.size()>2){
                ImageView imgGoods3 = helper.getView(R.id.img_goods_3);
                TextView tvGoodsName3 = helper.getView(R.id.tv_goods_name_3);
                GlideUtils.loadImg(imgGoods3,list.get(2).getOriginal_img());
                tvGoodsName3.setText(list.get(2).getGoods_name());
                helper.getView(R.id.lin_goods_3).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(mContext, ShopGoodsDetailsActivity.class);
                        intent.putExtra("city_goods_id",list.get(2).getCity_goods_id());
                        mContext.startActivity(intent);
                    }
                });
            }
        }






    }

}
