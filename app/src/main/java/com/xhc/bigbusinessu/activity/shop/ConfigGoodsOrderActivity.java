package com.xhc.bigbusinessu.activity.shop;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.alipay.sdk.app.PayTask;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.MShopAddressListEntity;
import com.xhc.bigbusinessu.Entity.PayResultEntity;
import com.xhc.bigbusinessu.Entity.SureOrderInfoEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.me.MyShopGoodsAddressListActivity;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;
import com.xhc.bigbusinessu.utils.PayUtils;
import com.xhc.bigbusinessu.utils.pay.PayEvent;
import com.xhc.bigbusinessu.utils.pay.PayResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.transform.Result;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ConfigGoodsOrderActivity extends BaseActivity {

    @BindView(R.id.list_view)
    RecyclerView listView;


    @BindView(R.id.tv_exp_type_1)
    TextView tvExp1;
    @BindView(R.id.tv_exp_type_2)
    TextView tvExp2;
    @BindView(R.id.rel_exp_type_1)
    RelativeLayout relExp1;
    @BindView(R.id.rel_exp_type_2)
    RelativeLayout relExp2;
    @BindView(R.id.tv_total_price)
    TextView tvTotalPrice;

    int expType;

    List<SureOrderInfoEntity.DataBean.StoreListBean> dataList;
    CarAdapter adapter;
    MShopAddressListEntity.DataBean addressBean;


    SureOrderInfoEntity.DataBean bean;
    @BindView(R.id.tv_user_name_mobile)
    TextView tvUserNameMobile;
    @BindView(R.id.tv_user_address)
    TextView tvUserAddress;
    @BindView(R.id.lin_user_address)
    LinearLayout linUserAddress;
    @BindView(R.id.tv_choose_address)
    TextView tvChooseAddress;

    @BindView(R.id.tv_ship_price)
    TextView tvShipPrice;


    @BindView(R.id.cb_type_wechat)
    CheckBox cbWeChat;
    @BindView(R.id.cb_type_ali)
    CheckBox cbAli;

    @BindView(R.id.tv_sub_order)
    TextView tvSubOrder;

    boolean isFromCar;//是否是从购物车结算
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_config_goods_order);
        bean = (SureOrderInfoEntity.DataBean) getIntent().getSerializableExtra("bean");

        isFromCar = getIntent().getBooleanExtra("is_car",false);
    }

    @Override
    protected void initUI() {
        showTitleBack();
        listView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    protected void initData() {

        dataList = new ArrayList<>();
        dataList.addAll(bean.getStore_list());
        tvTotalPrice.setText("" + bean.getAll_price());

        adapter = new CarAdapter(getActivity(), R.layout.item_config_order_shop, dataList);
        listView.setAdapter(adapter);

        getAddressList();
    }

    @Override
    protected void initEvent() {

        tvExp1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (expType == 1) {

                    tvExp1.setBackgroundResource(R.mipmap.icon_exp_type_btn_ed);
                    tvExp1.setTextColor(Color.parseColor("#ffffff"));

                    tvExp2.setBackgroundResource(0);
                    tvExp2.setTextColor(Color.parseColor("#999999"));
                    expType = 0;

                    relExp1.setVisibility(View.VISIBLE);
                    relExp2.setVisibility(View.GONE);
                }
            }
        });
        tvExp2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (expType == 0) {

                    tvExp2.setBackgroundResource(R.mipmap.icon_exp_type_btn_ed);
                    tvExp2.setTextColor(Color.parseColor("#ffffff"));

                    tvExp1.setBackgroundResource(0);
                    tvExp1.setTextColor(Color.parseColor("#999999"));
                    expType = 1;

                    relExp2.setVisibility(View.VISIBLE);
                    relExp1.setVisibility(View.GONE);
                }
            }
        });
        tvChooseAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ConfigGoodsOrderActivity.this, MyShopGoodsAddressListActivity.class);
                intent.putExtra("is_select", true);
                startActivityForResult(intent, 1002);
            }
        });

        cbWeChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbAli.setChecked(false);
                cbWeChat.setChecked(true);
            }
        });
        cbAli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cbAli.setChecked(true);
                cbWeChat.setChecked(false);
            }
        });
        tvSubOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                subData("", isFromCar?"1":"0", cbWeChat.isChecked() ? "0" : "1");//0微信支付，1支付宝支付
            }
        });

        PayUtils.getInstance().setOnPayUtilsListener(new PayUtils.OnPayUtilsListener() {
            @Override
            public void onWechatStatus(PayEvent payEvent) {
                if (payEvent.getStatus() == 1) {
                    ToastMessage(payEvent.getMessage());
                    finish();
                    mystartActivity(PaySuccessActivity.class);

                } else {
                    ToastMessage(payEvent.getMessage());
                }
            }

            @Override
            public void onAliStatus(PayEvent payEvent) {
                if (payEvent.getStatus() == 1) {
                    ToastMessage(payEvent.getMessage());
                    finish();
                    mystartActivity(PaySuccessActivity.class);

                } else {
                    ToastMessage(payEvent.getMessage());
                }
            }
        });
    }

    @Override
    protected void startFunction() {

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1003) {
            if (data.hasExtra("address_bean")) {

                addressBean = (MShopAddressListEntity.DataBean) data.getSerializableExtra("address_bean");
                if (addressBean != null) {

                    linUserAddress.setVisibility(View.VISIBLE);
                    tvChooseAddress.setText("");
                    tvUserNameMobile.setText(addressBean.getConsignee() + "    " + addressBean.getMobile());
                    tvUserAddress.setText(addressBean.getProvince_name() + "  " + addressBean.getCity_name() + "  " + addressBean.getDistrict_name() + "  " + addressBean.getAddress());
                    getOrderPrice();
                }
            }
        }

    }

    class CarAdapter extends BaseQuickAdapter<SureOrderInfoEntity.DataBean.StoreListBean, BaseViewHolder> {

        private Context context;

        public CarAdapter(Context context, int layoutResId, @Nullable List<SureOrderInfoEntity.DataBean.StoreListBean> data) {
            super(layoutResId, data);
            this.context = context;

        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, SureOrderInfoEntity.DataBean.StoreListBean item) {

            helper.setText(R.id.tv_shop_name, item.getStore_name());

            RecyclerView recyclerView = helper.getView(R.id.goods_list_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            MyGoodsAdapter myGoodsAdapter = (MyGoodsAdapter) recyclerView.getAdapter();

            if (myGoodsAdapter == null) {
                myGoodsAdapter = new MyGoodsAdapter(R.layout.item_config_order_shop_goods, item.getGoods_list());
                recyclerView.setAdapter(myGoodsAdapter);
            }

            myGoodsAdapter.setNewData(item.getGoods_list());
            myGoodsAdapter.notifyDataSetChanged();
        }


        class MyGoodsAdapter extends BaseQuickAdapter<SureOrderInfoEntity.DataBean.StoreListBean.GoodsListBean, BaseViewHolder> {

            public MyGoodsAdapter(int layoutResId, @Nullable List<SureOrderInfoEntity.DataBean.StoreListBean.GoodsListBean> data) {
                super(layoutResId, data);
            }

            @Override
            protected void convert(@NonNull BaseViewHolder helper, SureOrderInfoEntity.DataBean.StoreListBean.GoodsListBean item) {


                ImageView img = helper.getView(R.id.img_goods);
                TextView tvGoodsName = helper.getView(R.id.tv_goods_name);
                TextView tvGoodsSpec = helper.getView(R.id.tv_spec);
                TextView tvGoodsPrice = helper.getView(R.id.tv_goods_price);
                TextView tvGoodsNum = helper.getView(R.id.tv_goods_num);

                ImageView tvSub = helper.getView(R.id.iv_sub);
                ImageView tvAdd = helper.getView(R.id.iv_add);
                TextView etNum = helper.getView(R.id.et_good_num);


                GlideUtils.loadImg(img, item.getOriginal_img());
                tvGoodsName.setText(item.getGoods_name());
                tvGoodsPrice.setText("￥" + item.getCity_goods_price());
                tvGoodsNum.setText("X" + item.getBuy_num());
                etNum.setText(String.valueOf(item.getBuy_num()));


                //减少数量
                tvSub.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (item.getBuy_num() <= 1) {
                            ToastMessage("不能再减了");
                            return;
                        }
                        item.setBuy_num(item.getBuy_num() - 1);
                        getOrderPrice();
                    }
                });

                //增加数量
                tvAdd.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (item.getBuy_num() > Integer.parseInt(item.getStore_count())) {
                            ToastMessage("已超出商品库存，不能再加了");
                            return;
                        }
                        item.setBuy_num(item.getBuy_num() + 1);
                        getOrderPrice();
                    }
                });

            }
        }
    }


    /**
     * 计算订单价格
     **/
    private void getOrderPrice() {

        showProgressDialog("请求中");
        String city_goods_ids = "";
        String goods_nums = "";
        String goods_names = "";
        String address_id = "";
        for (SureOrderInfoEntity.DataBean.StoreListBean storeBean : bean.getStore_list()) {

            for (SureOrderInfoEntity.DataBean.StoreListBean.GoodsListBean goodBean : storeBean.getGoods_list()) {

                if (TextUtils.isEmpty(city_goods_ids)) {
                    city_goods_ids = goodBean.getCity_goods_id();
                } else {

                    city_goods_ids += "," + goodBean.getCity_goods_id();
                }

                if (TextUtils.isEmpty(goods_nums)) {
                    goods_nums = goodBean.getBuy_num() + "";
                } else {

                    goods_nums += "," + goodBean.getBuy_num();
                }

                if (TextUtils.isEmpty(goods_names)) {
                    goods_names = goodBean.getGoods_name();
                } else {

                    goods_names += "," + goodBean.getGoods_name();
                }

            }
        }

        if (addressBean != null) {
            address_id = addressBean.getAddress_id();
        }


        showProgressDialog("提交中");
        ShopApi.getInstance().getOrderPrice(new BaseCallback<SureOrderInfoEntity>(SureOrderInfoEntity.class) {
            @Override
            protected void onError(Exception e) {
                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(SureOrderInfoEntity response) {
                disProgressDialog();

                if (response.getData() != null) {
                    dataList.clear();
                    bean = response.getData();
                    dataList.addAll(response.getData().getStore_list());
                    tvTotalPrice.setText("" + response.getData().getAll_price());
                    adapter.notifyDataSetChanged();
                    tvShipPrice.setText("" + response.getData().getAll_shipping_price());
                }
            }
        }, city_goods_ids, goods_nums, goods_names, address_id);
    }


    /**
     * 获取我的地址列表 是否有默认地址
     */
    private void getAddressList() {

        UserApi.getInstance().getMyShopList(new BaseCallback<MShopAddressListEntity>(MShopAddressListEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络错误");
            }

            @Override
            protected void onSuccess(MShopAddressListEntity response) {

                if (response.getData() != null) {

                    for (MShopAddressListEntity.DataBean bean : response.getData()) {
                        if ("1".equals(bean.getIs_default())) {

                            addressBean = bean;

                            linUserAddress.setVisibility(View.VISIBLE);
                            tvChooseAddress.setText("");

                            tvUserNameMobile.setText(addressBean.getConsignee() + "    " + addressBean.getMobile());
                            tvUserAddress.setText(addressBean.getProvince_name() + "  " + addressBean.getCity_name() + "  " + addressBean.getDistrict_name() + "  " + addressBean.getAddress());

                            getOrderPrice();
                            break;
                        }

                    }
                }
            }
        });
    }


    private void subData(String user_note, String type, String pay_type) {


        if (addressBean == null) {

            ToastMessage("请先选择收货地址");
            return;
        }


        //        user_note N  用户给卖家留言 多个用英文逗号“,”隔开 如1,2,3
//        type N 0 购买方式：0立即购买，1购物车购买
//        pay_type N 0 支付方式：0微信支付，1支付宝支付

        showProgressDialog("提交中");
        String city_goods_ids = "";
        String goods_nums = "";
        String goods_names = "";
        String address_id = "";

        address_id = addressBean.getAddress_id();

        for (SureOrderInfoEntity.DataBean.StoreListBean storeBean : bean.getStore_list()) {

            for (SureOrderInfoEntity.DataBean.StoreListBean.GoodsListBean goodBean : storeBean.getGoods_list()) {

                if (TextUtils.isEmpty(city_goods_ids)) {
                    city_goods_ids = goodBean.getCity_goods_id();
                } else {

                    city_goods_ids += "," + goodBean.getCity_goods_id();
                }

                if (TextUtils.isEmpty(goods_nums)) {
                    goods_nums = goodBean.getBuy_num() + "";
                } else {

                    goods_nums += "," + goodBean.getBuy_num();
                }

                if (TextUtils.isEmpty(goods_names)) {
                    goods_names = goodBean.getGoods_name();
                } else {

                    goods_names += "," + goodBean.getGoods_name();
                }

            }
        }
        ShopApi.getInstance().subOrder(new BaseCallback<PayResultEntity>(PayResultEntity.class) {
            @Override
            protected void onError(Exception e) {

                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(PayResultEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {
                    if (pay_type.equals("1")) {
                        PayUtils.getInstance().doAliPay(ConfigGoodsOrderActivity.this, response.getData().getAlipay());
                    } else if (pay_type.equals("0")) {
                        PayUtils.getInstance().doWeChatPay(ConfigGoodsOrderActivity.this, response.getData().getWxpay());
                    }

                } else {
                    ToastMessage(response.getMsg());
                }

            }
        }, city_goods_ids, goods_nums, goods_names, address_id, user_note,type, pay_type);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
