package com.xhc.bigbusinessu.activity.shop;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.ShopOrderDetailsEntity;
import com.xhc.bigbusinessu.Entity.ShopOrderListEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShopOrderDetailsActivity extends BaseActivity {


    MyAdapter myAdapter;
    @BindView(R.id.list_view)
    RecyclerView listView;

    @BindView(R.id.tv_shop_name)
    TextView tvShopName;

    @BindView(R.id.tv_order_des)
    TextView tvOrderDes;
    @BindView(R.id.right_btn)
    TextView rightBtn;
    @BindView(R.id.left_btn)
    TextView leftBtn;
    @BindView(R.id.left_btn2)
    TextView leftBtn2;
    @BindView(R.id.left_btn3)
    TextView leftBtn3;

    @BindView(R.id.lin_order_no)
    LinearLayout linOrderInfo;
    @BindView(R.id.tv_order_no)
    TextView tvOrderNo;
    @BindView(R.id.lin_order_pay_time)
    LinearLayout linOrderPayTime;
    @BindView(R.id.tv_order_pay_time)
    TextView tvOrderPayTime;
    @BindView(R.id.lin_order_send_time)
    LinearLayout linOrderSendTime;
    @BindView(R.id.tv_order_send_time)
    TextView tvOrderSendTime;

    @BindView(R.id.tv_consignee)
    TextView tvConsignee;
    @BindView(R.id.tv_address)
    TextView tvAddress;

    @BindView(R.id.tv_top_title)
    TextView tvTopTitle;
    @BindView(R.id.tv_top_des)
    TextView tvTopDes;

    @BindView(R.id.lin_express_info)
    LinearLayout linearLayout;
    @BindView(R.id.tv_express_info)
    TextView tvExpressInfo;
    @BindView(R.id.tv_express_time)
    TextView tvExpressTime;

    String order_sn;

    List<ShopOrderDetailsEntity.DataBean.GoodsListBean> list;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_shop_order_details);
        order_sn = getIntent().getStringExtra("order_sn");
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("订单详情");


        listView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        myAdapter = new MyAdapter(R.layout.item_shop_order_goods_list, list);
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

        getOrderDetails(order_sn);
    }


    /**
     * 设置界面信息
     *
     * @param bean
     */
    private void setInfo(ShopOrderDetailsEntity.DataBean bean) {
        if (bean == null) {
            ToastMessage("数据异常");
            return;
        }

        int status = bean.getOrder_status();

        //订单状态   1待支付，2待发货，3待收货,4(已收货)待评价，5已完成， 6已取消,7已作废
        if (status == 1) {

            tvTopTitle.setText("未付款");
            tvTopDes.setText("");

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.VISIBLE);
            rightBtn.setVisibility(View.VISIBLE);

            leftBtn.setText("取消订单");
            rightBtn.setText("立即支付");


            leftBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showAlertDialogMessage("提示", "是否要取消订单？", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            cancelOrder(bean.getOrder_sn());
                        }
                    });
                }
            });
            rightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ShopOrderDetailsActivity.this, DoPayActivity.class);
                    intent.putExtra("order_sn", bean.getOrder_sn());
                    intent.putExtra("price", bean.getTotal_amount());
                    startActivityForResult(intent, 1000);
                }
            });

        } else if (status == 2) {

            tvTopTitle.setText("买家已付款");
            tvTopDes.setText("");

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.GONE);
            rightBtn.setVisibility(View.VISIBLE);

            leftBtn.setText("");
            rightBtn.setText("退款");

        } else if (status == 3) {

            //快递信息
//            linearLayout.setVisibility(View.VISIBLE);
//            tvExpressInfo.setText("");
//            tvExpressTime.setText("");

            tvTopTitle.setText("卖家已发货");
            tvTopDes.setText("");
//            tvTopDes.setText("还剩14天2时自动确认");

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.VISIBLE);
            rightBtn.setVisibility(View.VISIBLE);

            leftBtn.setText("查看物流");
            rightBtn.setText("确认收货");
            rightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    showAlertDialogMessage("提示", "是否要确认收货？", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            confirmOrder(bean.getOrder_sn());
                        }
                    });
                }
            });

        } else if (status == 4) {

            tvTopTitle.setText("买家已收货");
            tvTopDes.setText("");

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.GONE);
            rightBtn.setVisibility(View.VISIBLE);

            leftBtn.setText("");
            rightBtn.setText("评价");

        } else if (status == 5) {

            tvTopTitle.setText("订单已完成");
            tvTopDes.setText("");

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.GONE);
            rightBtn.setVisibility(View.GONE);

            leftBtn.setText("");
            rightBtn.setText("");

        } else if (status == 6) {

            tvTopTitle.setText("订单已取消");
            tvTopDes.setText("");

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.GONE);
            rightBtn.setVisibility(View.VISIBLE);

            leftBtn.setText("");
            rightBtn.setText("删除订单");
            rightBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    showAlertDialogMessage("提示", "是否要删除订单", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            delOrder(bean.getOrder_sn());
                        }
                    });
                }
            });

        } else if (status == 7) {

            tvTopTitle.setText("订单已作废");
            tvTopDes.setText("");

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.GONE);
            rightBtn.setVisibility(View.VISIBLE);

            rightBtn.setText("");
            leftBtn.setText("");

        } else {

            leftBtn3.setVisibility(View.GONE);
            leftBtn2.setVisibility(View.GONE);
            leftBtn.setVisibility(View.GONE);
            rightBtn.setVisibility(View.GONE);

            leftBtn.setText("");
            rightBtn.setText("");
        }


        list.clear();
        list.addAll(bean.getGoods_list());
        myAdapter.notifyDataSetChanged();


        if (bean.getStore() != null) {
            tvShopName.setText(bean.getStore().getStore_name());
            tvOrderDes.setText("共" + bean.getGoods_list().size() + "件商品  合计:￥" + bean.getTotal_amount());
        }

        tvOrderNo.setText(bean.getOrder_sn());

        linOrderPayTime.setVisibility(View.GONE);
        if(TextUtils.isEmpty(bean.getPay_time()) && !"0".equals(bean.getPay_time())){
            linOrderPayTime.setVisibility(View.VISIBLE);
            tvOrderPayTime.setText(bean.getPay_time());
        }


        linOrderSendTime.setVisibility(View.GONE);
        if (!TextUtils.isEmpty(bean.getShipping_time()) && !"0".equals(bean.getShipping_time())) {
            linOrderSendTime.setVisibility(View.VISIBLE);
            tvOrderSendTime.setText(bean.getShipping_time());
        }


        tvConsignee.setText(bean.getConsignee() + "    " + bean.getMobile());
        tvAddress.setText(bean.getProvince() + "  " + bean.getCity() + "  " + bean.getDistrict() + "  " + bean.getAddress());
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1003) {
            getOrderDetails(order_sn);
        }
    }

    /**
     * 获取订单详情
     *
     * @param order_sn
     */
    private void getOrderDetails(String order_sn) {

        ShopApi.getInstance().getShopOrderDetails(new BaseCallback<ShopOrderDetailsEntity>(ShopOrderDetailsEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(ShopOrderDetailsEntity response) {

                if (response.getStatus() == 1) {

                    if (response.getData().getGoods_list() != null) {

                        setInfo(response.getData());
                    }
                } else {

                    ToastMessage(response.getMsg());
                    finish();
                }
            }
        }, order_sn);
    }

    class MyAdapter extends BaseQuickAdapter<ShopOrderDetailsEntity.DataBean.GoodsListBean, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<ShopOrderDetailsEntity.DataBean.GoodsListBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, ShopOrderDetailsEntity.DataBean.GoodsListBean item) {


            ImageView img = helper.getView(R.id.img_goods);
            TextView tvGoodsName = helper.getView(R.id.tv_goods_name);
            TextView tvGoodsSpec = helper.getView(R.id.tv_spec);
            TextView tvGoodsPrice = helper.getView(R.id.tv_goods_price);
            TextView tvGoodsNum = helper.getView(R.id.tv_goods_num);


            GlideUtils.loadImg(img, item.getOriginal_img());
            tvGoodsName.setText(item.getGoods_name());
            tvGoodsPrice.setText("￥" + item.getGoods_price());
            tvGoodsNum.setText("X" + item.getGoods_num());

        }
    }


    /**
     * 取消订单
     *
     * @param order_sn
     */
    private void cancelOrder(String order_sn) {
        ShopApi.getInstance().cancelOrder(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                if (response.getStatus() == 1) {
                    ToastMessage(response.getMsg());
                    finish();
                } else {
                    ToastMessage(response.getMsg());
                }

            }
        }, order_sn);
    }

    /**
     * 删除订单
     *
     * @param order_sn
     */
    private void delOrder(String order_sn) {
        ShopApi.getInstance().delOrder(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                if (response.getStatus() == 1) {
                    ToastMessage(response.getMsg());
                    finish();
                } else {
                    ToastMessage(response.getMsg());
                }

            }
        }, order_sn);
    }

    /**
     * 确认收货
     *
     * @param order_sn
     */
    private void confirmOrder(String order_sn) {
        ShopApi.getInstance().confirmOrder(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                if (response.getStatus() == 1) {
                    ToastMessage(response.getMsg());
                    getOrderDetails(order_sn);
                } else {
                    ToastMessage(response.getMsg());
                }

            }
        }, order_sn);
    }
}
