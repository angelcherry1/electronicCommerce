package com.xhc.bigbusinessu.fragment.order;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.ShopOrderListEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.shop.ConfigGoodsOrderActivity;
import com.xhc.bigbusinessu.activity.shop.ShopOrderDetailsActivity;
import com.xhc.bigbusinessu.base.BaseFragment;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ShopGoodsOrderFragment extends BaseFragment {

    @BindView(R.id.list_view)
    RecyclerView listView;


    MyAdapter adapter;
    List<ShopOrderListEntity.DataBean.ListBean> dataList;

    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_shop_goods_order);
    }

    @Override
    protected void initUI() {

        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dataList = new ArrayList<>();
        adapter = new MyAdapter(R.layout.item_shop_goods_order, dataList);
        listView.setAdapter(adapter);
        adapter.setEmptyView(R.layout.view_list_order_empty, listView);

    }

    @Override
    protected void initData() {

//        int type = getArguments().getInt("type", 0);
//        getMyShopOrderList(type);
//        setTypeData(type);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }

    class MyAdapter extends BaseQuickAdapter<ShopOrderListEntity.DataBean.ListBean, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<ShopOrderListEntity.DataBean.ListBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, ShopOrderListEntity.DataBean.ListBean item) {


            helper.setText(R.id.tv_shop_name, item.getStore_name());

            helper.setText(R.id.tv_order_type, ShopApi.getInstance().getOrderStatus(item.getOrder_status()));
            helper.setText(R.id.tv_order_des, "共" + item.getGoods_list().size() + "件商品  合计:￥" + item.getTotal_amount());

            TextView leftBtn = helper.getView(R.id.left_btn);
            TextView rightBtn = helper.getView(R.id.right_btn);

            //订单状态   1待支付，2待发货，3待收货,4(已收货)待评价，5已完成， 6已取消,7已作废
            if (item.getOrder_status() == 1) {
                leftBtn.setVisibility(View.VISIBLE);
                leftBtn.setText("取消订单");
                rightBtn.setVisibility(View.VISIBLE);
                rightBtn.setText("立即支付");
            } else if (item.getOrder_status() == 2) {
                leftBtn.setVisibility(View.GONE);
                leftBtn.setText("");
                rightBtn.setVisibility(View.VISIBLE);
                rightBtn.setText("退款");
            } else if (item.getOrder_status() == 3) {
                leftBtn.setVisibility(View.VISIBLE);
                leftBtn.setText("查看物流");
                rightBtn.setVisibility(View.VISIBLE);
                rightBtn.setText("确认收货");
            } else if (item.getOrder_status() == 4) {
                leftBtn.setVisibility(View.GONE);
                leftBtn.setText("");
                rightBtn.setVisibility(View.VISIBLE);
                rightBtn.setText("评价");
            } else if (item.getOrder_status() == 5) {
                leftBtn.setVisibility(View.GONE);
                leftBtn.setText("");
                rightBtn.setVisibility(View.GONE);
                rightBtn.setText("");
            } else if (item.getOrder_status() == 6) {
                leftBtn.setVisibility(View.GONE);
                leftBtn.setText("");
                rightBtn.setVisibility(View.VISIBLE);
                rightBtn.setText("删除订单");
            } else if (item.getOrder_status() == 7) {
                leftBtn.setVisibility(View.GONE);
                leftBtn.setText("");
                rightBtn.setVisibility(View.GONE);
                rightBtn.setText("");
            } else {
                leftBtn.setVisibility(View.GONE);
                leftBtn.setText("");
                rightBtn.setVisibility(View.GONE);
                rightBtn.setText("");
            }

            RecyclerView recyclerView = helper.getView(R.id.list_view);
            recyclerView.setFocusableInTouchMode(false);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            MyGoodsAdapter myGoodsAdapter = (MyGoodsAdapter) recyclerView.getAdapter();

            if (myGoodsAdapter == null) {
                myGoodsAdapter = new MyGoodsAdapter(R.layout.item_shop_goods_order_sub, item.getGoods_list());
                recyclerView.setAdapter(myGoodsAdapter);
            }

            myGoodsAdapter.setNewData(item.getGoods_list());
            myGoodsAdapter.setOrder_sn(item.getOrder_sn());
            myGoodsAdapter.notifyDataSetChanged();


            helper.itemView.setOnClickListener(view -> {

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("order_sn", item.getOrder_sn());
                        mystartActivity(ShopOrderDetailsActivity.class, bundle);
                    }

            );
        }
    }

    class MyGoodsAdapter extends BaseQuickAdapter<ShopOrderListEntity.DataBean.ListBean.GoodsListBean, BaseViewHolder> {


        private String order_sn;

        public void setOrder_sn(String order_sn) {
            this.order_sn = order_sn;
        }

        public MyGoodsAdapter(int layoutResId, @Nullable List<ShopOrderListEntity.DataBean.ListBean.GoodsListBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, ShopOrderListEntity.DataBean.ListBean.GoodsListBean item) {


            ImageView img = helper.getView(R.id.img_goods);
            TextView tvGoodsName = helper.getView(R.id.tv_goods_name);
            TextView tvGoodsSpec = helper.getView(R.id.tv_spec);
            TextView tvGoodsPrice = helper.getView(R.id.tv_goods_price);
            TextView tvGoodsNum = helper.getView(R.id.tv_goods_num);

            GlideUtils.loadImg(img, item.getOriginal_img());
            tvGoodsName.setText(item.getGoods_name());
            tvGoodsPrice.setText("￥" + item.getGoods_price());
            tvGoodsNum.setText("X" + item.getGoods_num());

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("order_sn", order_sn);
                    mystartActivity(ShopOrderDetailsActivity.class, bundle);
                }
            });
        }
    }


    //0全部，1待支付，2待发货，3待收货,4待评价，5已完成
    private void getMyShopOrderList(int type) {

        ShopApi.getInstance().getShopOrderList(new BaseCallback<ShopOrderListEntity>(ShopOrderListEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(ShopOrderListEntity response) {
                if (response.getStatus() == 1) {

                    dataList.clear();
                    dataList.addAll(response.getData().getList());
                    adapter.notifyDataSetChanged();
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, String.valueOf(type), "", "", "");


    }

    @Override
    public void onResume() {
        super.onResume();
        int type = getArguments().getInt("type", 0);
        getMyShopOrderList(type);
    }
}
