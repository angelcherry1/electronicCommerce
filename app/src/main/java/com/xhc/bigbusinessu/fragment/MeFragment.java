package com.xhc.bigbusinessu.fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.library.YLCircleImageView;
import com.bumptech.glide.Glide;
import com.xhc.bigbusinessu.Entity.UserInfoEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.bbs.PushBBSActivity;
import com.xhc.bigbusinessu.activity.collection.MyCollectionActivity;
import com.xhc.bigbusinessu.activity.coupon.GoodsCouponListActivity;
import com.xhc.bigbusinessu.activity.integral_recharge.IntegralRechargeActivity;
import com.xhc.bigbusinessu.activity.invoice.InvoiceListActivity;
import com.xhc.bigbusinessu.activity.life.order.LifeAllOrderListActivity;
import com.xhc.bigbusinessu.activity.me.order.errands.AllErrandsOrderActivity;
import com.xhc.bigbusinessu.activity.me.order.hotel.AllHotelOrderActivity;
import com.xhc.bigbusinessu.activity.me.order.shop.AllShopOrderActivity;
import com.xhc.bigbusinessu.activity.me.order.takeOut.AllTakeoutOrderActivity;
import com.xhc.bigbusinessu.activity.me.order.travel.AllTravelOrderActivity;
import com.xhc.bigbusinessu.activity.me.setting.SetupActivity;
import com.xhc.bigbusinessu.activity.myGoods.MyGoodsForPushActivity;
import com.xhc.bigbusinessu.activity.myGoods.MyGoodsForSellActivity;
import com.xhc.bigbusinessu.activity.wallet.MyWalletActivity;
import com.xhc.bigbusinessu.base.BaseFragment;
import com.xhc.bigbusinessu.utils.GlideUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by XXW on 2018/8/19.
 * 首页
 */

public class MeFragment extends BaseFragment {


    @BindView(R.id.img_avatar)
    YLCircleImageView imgAvatar;
    @BindView(R.id.tv_nick_name)
    TextView tvNickName;

    @Override
    protected void setContentView() {
        setContentView(R.layout.frag_tab_info);
    }

    @Override
    protected void initUI() {
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

    @OnClick({

            R.id.rel_setting, R.id.lin_all_order,
            R.id.lin_shop_order_type_1, R.id.lin_shop_order_type_2,
            R.id.lin_shop_order_type_3, R.id.lin_shop_order_type_4,
            R.id.lin_shop_order_type_5,

            R.id.tv1,
            R.id.tv2,
            R.id.tv3,
            R.id.tv4,
            R.id.tv6,
            R.id.tv7,
            R.id.tv8,
            R.id.tv9,
            R.id.tv10,
            R.id.tv11,
            R.id.tv12,
            R.id.tv13,
            R.id.tv14

    })
    public void onViewClicked(View v) {
        Bundle bundle = new Bundle();
        switch (v.getId()) {

            case R.id.rel_setting:
                mystartActivity(SetupActivity.class);
                break;

            case R.id.lin_all_order:
                mystartActivity(AllShopOrderActivity.class);
                break;

            case R.id.lin_shop_order_type_1:

                bundle.putInt("type", 1);
                mystartActivity(AllShopOrderActivity.class, bundle);
                break;
            case R.id.lin_shop_order_type_2:
                bundle.putInt("type", 2);
                mystartActivity(AllShopOrderActivity.class, bundle);
                break;
            case R.id.lin_shop_order_type_3:
                bundle.putInt("type", 3);
                mystartActivity(AllShopOrderActivity.class, bundle);
                break;
            case R.id.lin_shop_order_type_4:
                bundle.putInt("type", 4);
                mystartActivity(AllShopOrderActivity.class, bundle);
                break;

            case R.id.lin_shop_order_type_5:
                bundle.putInt("type", 5);
                mystartActivity(AllShopOrderActivity.class, bundle);
                break;

                //外卖
            case R.id.tv1:
                mystartActivity(AllTakeoutOrderActivity.class);
                break;

            //快递跑腿
            case R.id.tv2:
                mystartActivity(AllErrandsOrderActivity.class);
                break;

            //酒店住宿订单管理
            case R.id.tv3:
                mystartActivity(AllHotelOrderActivity.class, bundle);
                break;

            //旅游订单
            case R.id.tv4:
                mystartActivity(AllTravelOrderActivity.class);
                break;


            //便捷生活订单
            case R.id.tv6:
                mystartActivity(LifeAllOrderListActivity.class);
                break;

            //我发布的商品
            case R.id.tv7:
                mystartActivity(MyGoodsForPushActivity.class);
                break;
            //我卖出的商品
            case R.id.tv8:
                mystartActivity(MyGoodsForSellActivity.class);
                break;

            //发布论坛
            case R.id.tv9:
                mystartActivity(PushBBSActivity.class);
                break;
            //优惠券
            case R.id.tv10:
                mystartActivity(GoodsCouponListActivity.class);
                break;
            //积分充值
            case R.id.tv11:
                mystartActivity(IntegralRechargeActivity.class);
                break;
            //我的钱包
            case R.id.tv12:
                mystartActivity(MyWalletActivity.class);
                break;
            //我的收藏
            case R.id.tv13:
                mystartActivity(MyCollectionActivity.class);
                break;
            //发票抬头
            case R.id.tv14:
                mystartActivity(InvoiceListActivity.class);
                break;

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
                    tvNickName.setText(response.getData().getNickname());
                } else {

                }

            }
        }, "");
    }

}
