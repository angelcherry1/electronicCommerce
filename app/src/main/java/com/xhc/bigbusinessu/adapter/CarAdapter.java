package com.xhc.bigbusinessu.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.CarListEntity;
import com.xhc.bigbusinessu.Entity.SureOrderInfoEntity;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.shop.ShopGoodsDetailsActivity;
import com.xhc.bigbusinessu.fragment.CarFragment;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends BaseQuickAdapter<CarListEntity.DataBean, BaseViewHolder> {

    private Context context;

    TextView totalTextView;

    List<String> selectShopList = new ArrayList<>();

    List<CarListEntity.DataBean.GoodsListBean> selectGoodsList = new ArrayList<>();

    OnCarAdapterListener onCarAdapterListener;

    public void setOnCarAdapterListener(OnCarAdapterListener onCarAdapterListener) {
        this.onCarAdapterListener = onCarAdapterListener;
    }

    public List<String> getSelectShopList() {
        return selectShopList;
    }

    public CarAdapter(Context context, int layoutResId, @Nullable List<CarListEntity.DataBean> data) {
        super(layoutResId, data);
        this.context = context;
    }

    @Override
    protected void convert(@NonNull BaseViewHolder helper, CarListEntity.DataBean item) {

        RelativeLayout relCbBtn = helper.getView(R.id.rel_cb_btn);
        CheckBox checkBox = helper.getView(R.id.cb_select);

        checkBox.setChecked(selectShopList.contains(String.valueOf(item.getStore_id())));


        helper.setText(R.id.tv_shop_name, item.getStore_name());


        RecyclerView recyclerView = helper.getView(R.id.goods_list_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        MyGoodsAdapter myGoodsAdapter = (MyGoodsAdapter) recyclerView.getAdapter();
        if (myGoodsAdapter == null) {
            myGoodsAdapter = new MyGoodsAdapter(R.layout.item_car_shop_goods, item.getGoodsList());
            recyclerView.setAdapter(myGoodsAdapter);
        }
        myGoodsAdapter.setNewData(item.getGoodsList());
        myGoodsAdapter.notifyDataSetChanged();


        relCbBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkBox.setChecked(!checkBox.isChecked());

                if (selectShopList.contains(String.valueOf(item.getStore_id()))) {
                    selectShopList.remove(String.valueOf(item.getStore_id()));
                } else {
                    selectShopList.add(String.valueOf(item.getStore_id()));
                }


                List<CarListEntity.DataBean.GoodsListBean> goodsListBean = item.getGoodsList();
                if (checkBox.isChecked()) {
                    for (CarListEntity.DataBean.GoodsListBean bean : goodsListBean) {
                        if (!selectGoodsList.contains(bean)) {
                            selectGoodsList.add(bean);
                        }
                    }
                } else {
                    for (CarListEntity.DataBean.GoodsListBean bean : goodsListBean) {
                        if (selectGoodsList.contains(bean)) {
                            selectGoodsList.remove(bean);
                        }
                    }
                }
                notifyDataSetChanged();
                getTotalPrice();
            }
        });



    }


    class MyGoodsAdapter extends BaseQuickAdapter<CarListEntity.DataBean.GoodsListBean, BaseViewHolder> {


        public MyGoodsAdapter(int layoutResId, @Nullable List<CarListEntity.DataBean.GoodsListBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, CarListEntity.DataBean.GoodsListBean item) {
            RelativeLayout relCbBtn = helper.getView(R.id.rel_cb_btn);
            CheckBox checkBox = helper.getView(R.id.cb_select);

            checkBox.setChecked(selectGoodsList.contains(item));

            relCbBtn.setOnClickListener(view -> {


                checkBox.setChecked(!checkBox.isChecked());

                if (checkBox.isChecked()) {
                    if (!selectGoodsList.contains(item)) {
                        selectGoodsList.add(item);
                    }
                } else {
                    selectGoodsList.remove(item);
                }


                int selectSize = 0;
                for (CarListEntity.DataBean.GoodsListBean b : mData) {
                    if (selectGoodsList.contains(b)) {
                        selectSize++;
                        Log.e("Test", "selectSize:" + selectSize);
                    }
                }
//                boolean isAllSelect = (mData.size() == selectSize && mData.size() > 0);
                boolean isAllSelect = (mData.size() == selectSize);

                if (isAllSelect) {
                    if (!selectShopList.contains(item.getStore_id())) {
                        selectShopList.add(item.getStore_id());
                    }
                } else {
                    if (selectShopList.contains(item.getStore_id())) {
                        selectShopList.remove(item.getStore_id());
                    }
                }
                CarAdapter.this.notifyDataSetChanged();

                getTotalPrice();
            });


            ImageView img = helper.getView(R.id.img_goods);
            TextView tvGoodsName = helper.getView(R.id.tv_goods_name);
            TextView tvGoodsPrice = helper.getView(R.id.tv_goods_price);
            TextView tvGoodsNum = helper.getView(R.id.tv_goods_num);

            GlideUtils.loadImg(img, item.getOriginal_img());
            tvGoodsName.setText(item.getGoods_name());
            tvGoodsPrice.setText("￥" + item.getCity_goods_price());
            tvGoodsNum.setText("X" + item.getGoods_num());


            RelativeLayout tvSub = helper.getView(R.id.iv_sub);
            RelativeLayout tvAdd = helper.getView(R.id.iv_add);
            TextView etNum = helper.getView(R.id.et_good_num);
            etNum.setText(item.getGoods_num());

            //减少数量
            tvSub.setOnClickListener(view -> {

                int nowNum = Integer.parseInt(item.getGoods_num());
                if (nowNum <= 1) {
                    Toast.makeText(mContext,"不能再减了",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(onCarAdapterListener!=null){
                    onCarAdapterListener.onNumChange(item,nowNum-1);
                }

            });

            //增加数量
            tvAdd.setOnClickListener(view -> {
                int nowNum = Integer.parseInt(item.getGoods_num());
                if(onCarAdapterListener!=null){
                    onCarAdapterListener.onNumChange(item,nowNum+1);
                }
            });


            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ShopGoodsDetailsActivity.class);
                    intent.putExtra("city_goods_id",item.getCity_goods_id());
                    mContext.startActivity(intent);
                }
            });

            helper.getView(R.id.view_line).setVisibility((helper.getAdapterPosition()+1)==getItemCount()?View.INVISIBLE:View.VISIBLE);
        }


    }

    public void setTotalTextView(TextView totalTextView) {
        this.totalTextView = totalTextView;
    }

    public List<CarListEntity.DataBean.GoodsListBean> getSelectGoodsList() {

        return this.selectGoodsList;
    }


    /**
     * 计算选中的总价
     */
    public void getTotalPrice(){

        if (totalTextView != null) {
            float totalPrice = 0.00f;
            for (CarListEntity.DataBean.GoodsListBean b : selectGoodsList) {
                totalPrice += Integer.parseInt(b.getGoods_num()) * Float.parseFloat(b.getCity_goods_price());
            }
            DecimalFormat decimalFormat = new DecimalFormat("0.00");//构造方法的字符格式这里如果小数不足2位,会以0补足.
            String formatStr = "￥" + decimalFormat.format(totalPrice);//format 返回的是字符串
            totalTextView.setText(formatStr);
        }
    }

    public interface OnCarAdapterListener{
        void onNumChange(CarListEntity.DataBean.GoodsListBean bean,int nowNum);
    }
}
