package com.xhc.bigbusinessu.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.CarListEntity;
import com.xhc.bigbusinessu.Entity.SureOrderInfoEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.CarApi;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.shop.ConfigGoodsOrderActivity;
import com.xhc.bigbusinessu.adapter.CarAdapter;
import com.xhc.bigbusinessu.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by XXW on 2018/8/19.
 * 首页
 */

public class CarFragment extends BaseFragment {


    @BindView(R.id.tv_edit)
    TextView tvEdit;
    @BindView(R.id.list_view)
    RecyclerView listView;
    @BindView(R.id.tv_btn)
    TextView tvBtn;
    @BindView(R.id.rel_all_choose)
    RelativeLayout relAllChoose;
    @BindView(R.id.cb_all)
    CheckBox cbAll;
    @BindView(R.id.tv_total_price)
    TextView tvTotalView;

    CarAdapter carAdapter;

    List<CarListEntity.DataBean> dataList;

    int model = 0;//0 普通模式 1删除模式

    @Override
    protected void setContentView() {
        setContentView(R.layout.frag_tab_car);
    }

    @Override
    protected void initUI() {

        dataList = new ArrayList<>();

        carAdapter = new CarAdapter(getActivity(), R.layout.item_car_shop, dataList);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        listView.setLayoutManager(manager);
        listView.setAdapter(carAdapter);
        carAdapter.setTotalTextView(tvTotalView);
        carAdapter.setOnCarAdapterListener(new CarAdapter.OnCarAdapterListener() {
            @Override
            public void onNumChange(CarListEntity.DataBean.GoodsListBean bean, int nowNum) {


                chaneCarNum(bean.getId(), bean.getCity_goods_id(), nowNum + "");
            }
        });

    }

    @Override
    protected void initData() {


    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {


    }

    @Override
    public void onResume() {
        super.onResume();
        getCarList();
    }

    @OnClick({R.id.tv_edit, R.id.tv_btn, R.id.rel_all_choose})
    public void onViewClicked(View view) {

        switch (view.getId()) {

            case R.id.tv_edit:

                if (model == 0) {
                    model = 1;
                    tvEdit.setText("完成");
                    tvBtn.setText("删除");


                } else {
                    model = 0;
                    tvEdit.setText("管理");
                    tvBtn.setText("结算");
                }

                break;

            case R.id.tv_btn:

                if (carAdapter.getSelectGoodsList().size() <= 0) {
                    ToastMessage("请先选择商品");
                    return;
                }
                //购买模式
                if (model == 0) {
                    subOrder();
                }
                //删除模式
                else if (model == 1) {

                    delGoods();
                }
                break;

            case R.id.rel_all_choose:

                cbAll.setChecked(!cbAll.isChecked());
                if (cbAll.isChecked()) {
                    carAdapter.getSelectGoodsList().clear();
                    carAdapter.getSelectShopList().clear();
                    for (CarListEntity.DataBean store : dataList) {
                        carAdapter.getSelectGoodsList().addAll(store.getGoodsList());
                        carAdapter.getSelectShopList().add(String.valueOf(store.getStore_id()));
                    }

                } else {
                    carAdapter.getSelectShopList().clear();
                    carAdapter.getSelectGoodsList().clear();
                }
                carAdapter.notifyDataSetChanged();
                carAdapter.getTotalPrice();
                break;
        }
    }

    /**
     * 删除选中商品
     */
    private void delGoods() {

        showAlertDialogMessage("提示", "是否要删除选中商品", (dialogInterface, i) -> {
            List<CarListEntity.DataBean.GoodsListBean> ids = carAdapter.getSelectGoodsList();
            String idsStr = "";
            for (CarListEntity.DataBean.GoodsListBean s : ids) {
                if (idsStr.length() <= 0) {
                    idsStr = s.getCity_goods_id();
                } else {
                    idsStr += "," + s.getCity_goods_id();
                }

            }

            showProgressDialog("删除中");
            CarApi.getInstance().delCartGoods(new BaseCallback<BaseEntity>(BaseEntity.class) {
                @Override
                protected void onError(Exception e) {
                    disProgressDialog();
                    ToastMessage("网络异常");
                }

                @Override
                protected void onSuccess(BaseEntity response) {
                    disProgressDialog();
                    ToastMessage(response.getMsg());
                    if (response.getStatus() == 1) {
                        carAdapter.getSelectGoodsList().clear();
                        carAdapter.getSelectShopList().clear();
                        getCarList();
                    }
                }
            }, idsStr);
        });
    }


    /**
     * 提交订单
     */
    private void subOrder() {

        showAlertDialogMessage("提示", "是否要结算？", (dialogInterface, i) -> {

            List<CarListEntity.DataBean.GoodsListBean> ids = carAdapter.getSelectGoodsList();
            String city_goods_ids = "";
            for (CarListEntity.DataBean.GoodsListBean s : ids) {
                if (city_goods_ids.length() <= 0) {
                    city_goods_ids = s.getCity_goods_id();
                } else {
                    city_goods_ids += "," + s.getCity_goods_id();
                }

            }

            String goods_nums = "";
            for (CarListEntity.DataBean.GoodsListBean s : ids) {
                if (goods_nums.length() <= 0) {
                    goods_nums = s.getGoods_num();
                } else {
                    goods_nums += "," + s.getGoods_num();
                }

            }

            String goods_names = "";
            for (CarListEntity.DataBean.GoodsListBean s : ids) {
                if (goods_names.length() <= 0) {
                    goods_names = s.getGoods_name();
                } else {
                    goods_names += "," + s.getGoods_name();
                }

            }

            showProgressDialog("提交中");
            ShopApi.getInstance().sureOrderInfo(new BaseCallback<SureOrderInfoEntity>(SureOrderInfoEntity.class) {
                @Override
                protected void onError(Exception e) {

                    disProgressDialog();
                    ToastMessage("网络异常");
                }

                @Override
                protected void onSuccess(SureOrderInfoEntity response) {

                    disProgressDialog();

                    if (response.getStatus() == 1) {

                        carAdapter.getSelectGoodsList().clear();
                        carAdapter.getSelectShopList().clear();

                        Bundle bundle = new Bundle();
                        bundle.putSerializable("bean", response.getData());
                        bundle.putBoolean("is_car",true);
                        mystartActivity(ConfigGoodsOrderActivity.class, bundle);


                    } else {
                        ToastMessage(response.getMsg());
                    }

                }
            }, city_goods_ids, goods_nums, goods_names);
        });


    }

    private void getCarList() {

        CarApi.getInstance().getCartList(new BaseCallback<CarListEntity>(CarListEntity.class) {
            @Override
            protected void onError(Exception e) {
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(CarListEntity response) {
                if (response.getStatus() == 1) {
                    if (response.getData() != null) {

                        dataList.clear();
                        dataList.addAll(response.getData());

                        List<CarListEntity.DataBean.GoodsListBean> oldList = new ArrayList<>();
                        oldList.addAll(carAdapter.getSelectGoodsList());
                        carAdapter.getSelectGoodsList().clear();
                        for (CarListEntity.DataBean s : dataList) {
                            for (CarListEntity.DataBean.GoodsListBean bean : s.getGoodsList()) {
                                for (CarListEntity.DataBean.GoodsListBean bean1 : oldList)
                                    if (bean.getCity_goods_id().equals(bean1.getCity_goods_id())) {
                                        if (!carAdapter.getSelectGoodsList().contains(bean))
                                            carAdapter.getSelectGoodsList().add(bean);
                                    }
                            }
                        }
                        oldList.clear();
                        carAdapter.notifyDataSetChanged();
                        carAdapter.getTotalPrice();
                    }

                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, MyApplication.getInstance().getCityId());
    }


    private void chaneCarNum(String id, String city_goods_id, String goods_num) {

        showProgressDialog("操作中");
        CarApi.getInstance().changeCartGoodsNum(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {
                disProgressDialog();
                ToastMessage("网路异常");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {
                    getCarList();
                } else {
                    ToastMessage(response.getMsg());
                }

            }
        }, id, city_goods_id, goods_num);
    }

}
