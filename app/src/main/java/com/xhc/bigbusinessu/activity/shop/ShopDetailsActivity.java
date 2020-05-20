package com.xhc.bigbusinessu.activity.shop;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.GoodsListEntity;
import com.xhc.bigbusinessu.Entity.ShopDetails;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.ShareDialog;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopDetailsActivity extends BaseActivity {

    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.lin_search)
    LinearLayout linSearch;
    @BindView(R.id.list_view)
    RecyclerView listView;

    List<GoodsListEntity.DataBean.ListBean> dataList;

    MyAdapter myAdapter;
    @BindView(R.id.img_shop)
    ImageView imgShop;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.tv_shop_des)
    TextView tvShopDes;
    @BindView(R.id.tv_type_1)
    TextView tvType1;
    @BindView(R.id.lin_type_1)
    LinearLayout linType1;
    @BindView(R.id.tv_type_2)
    TextView tvType2;
    @BindView(R.id.lin_type_2)
    LinearLayout linType2;
    @BindView(R.id.tv_type_3)
    TextView tvType3;
    @BindView(R.id.lin_type_3)
    LinearLayout linType3;
    @BindView(R.id.tv_type_4)
    TextView tvType4;
    @BindView(R.id.lin_type_4)
    LinearLayout linType4;

    int viewType;
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_shop_details);

        //页面来源
        viewType = getIntent().getIntExtra("view_type",0);
    }

    @Override
    protected void initUI() {

        GridLayoutManager manager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        listView.setLayoutManager(manager);

        dataList = new ArrayList<>();

        myAdapter = new MyAdapter(R.layout.item_shop_details, dataList);
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

        getData(getIntent().getStringExtra("store_id"));
        getGoodsList(MyApplication.getInstance().getCityId(), getIntent().getStringExtra("store_id"), "0",String.valueOf(viewType));
    }

    @OnClick({R.id.rel_back, R.id.img_share, R.id.lin_type_1, R.id.lin_type_2, R.id.lin_type_3, R.id.lin_type_4,R.id.lin_search})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.rel_back:
                goBack();
                break;

            case R.id.img_share:
                new ShareDialog(this).show();
                break;

            case R.id.lin_type_1:
                tvType1.setTextColor(Color.parseColor("#ffb333"));
                tvType2.setTextColor(Color.parseColor("#333333"));
                tvType3.setTextColor(Color.parseColor("#333333"));
                tvType4.setTextColor(Color.parseColor("#333333"));
                getGoodsList(MyApplication.getInstance().getCityId(), getIntent().getStringExtra("store_id"), "0",String.valueOf(viewType));
                break;
            case R.id.lin_type_2:
                tvType2.setTextColor(Color.parseColor("#ffb333"));
                tvType1.setTextColor(Color.parseColor("#333333"));
                tvType3.setTextColor(Color.parseColor("#333333"));
                tvType4.setTextColor(Color.parseColor("#333333"));
                getGoodsList(MyApplication.getInstance().getCityId(), getIntent().getStringExtra("store_id"), "1",String.valueOf(viewType));
                break;
            case R.id.lin_type_3:
                tvType3.setTextColor(Color.parseColor("#ffb333"));
                tvType2.setTextColor(Color.parseColor("#333333"));
                tvType1.setTextColor(Color.parseColor("#333333"));
                tvType4.setTextColor(Color.parseColor("#333333"));
                getGoodsList(MyApplication.getInstance().getCityId(), getIntent().getStringExtra("store_id"), "2",String.valueOf(viewType));
                break;
            case R.id.lin_type_4:
                tvType4.setTextColor(Color.parseColor("#ffb333"));
                tvType2.setTextColor(Color.parseColor("#333333"));
                tvType3.setTextColor(Color.parseColor("#333333"));
                tvType1.setTextColor(Color.parseColor("#333333"));
                getGoodsList(MyApplication.getInstance().getCityId(), getIntent().getStringExtra("store_id"), "3",String.valueOf(viewType));
                break;
            case R.id.lin_search:

                Bundle bundle = new Bundle();
                bundle.putString("store_id",getIntent().getStringExtra("store_id"));
                mystartActivity(SearchForGoodsActivity.class);

                break;
        }
    }


    private void getGoodsList(String city_id, String store_id, String sort_type,String type) {

        ShopApi.getInstance().getGoodsList(new BaseCallback<GoodsListEntity>(GoodsListEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网路异常");
            }

            @Override
            protected void onSuccess(GoodsListEntity response) {

                if (response.getStatus() == 1) {

                    if (response.getData() != null) {

                        if (response.getData().getList() != null) {
                            dataList.clear();
                            dataList.addAll(response.getData().getList());
                            myAdapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, city_id, "", "", "", "", store_id, sort_type, "",type);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    class MyAdapter extends BaseQuickAdapter<GoodsListEntity.DataBean.ListBean, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<GoodsListEntity.DataBean.ListBean> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, GoodsListEntity.DataBean.ListBean item) {

            ImageView img = helper.getView(R.id.img_goods);
            GlideUtils.loadImg(img, item.getOriginal_img());
            helper.setText(R.id.tv_goods_name, item.getGoods_name());
            helper.setText(R.id.tv_goods_price, "￥" + item.getCity_goods_price());
            helper.setText(R.id.tv_pay_num, item.getSales_sum() + "人付款");

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ShopGoodsDetailsActivity.class);
                    intent.putExtra("city_goods_id",item.getCity_goods_id());
                    mContext.startActivity(intent);
                }
            });
        }
    }

    private void getData(String store_id) {

        ShopApi.getInstance().getShopDetails(new BaseCallback<ShopDetails>(ShopDetails.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(ShopDetails response) {

                if (response.getStatus() == 1) {

                    if (response.getData() != null) {
                        GlideUtils.loadImg(imgShop, response.getData().getStore_logo());
                        tvShopName.setText(response.getData().getStore_name());
                        tvShopDes.setText("商品数量:" + response.getData().getStore_goods_num() + "  " + response.getData().getStore_collect() + "人关注");

                    } else {
                        ToastMessage("数据异常");
                    }
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, store_id);
    }
}
