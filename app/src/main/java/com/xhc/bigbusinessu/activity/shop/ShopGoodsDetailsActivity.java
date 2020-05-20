package com.xhc.bigbusinessu.activity.shop;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.ms.banner.Banner;
import com.ms.banner.BannerConfig;
import com.ms.banner.Transformer;
import com.ms.banner.holder.BannerViewHolder;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.GoodsDetailsEntity;
import com.xhc.bigbusinessu.Entity.SureOrderInfoEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.CarApi;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.ChooseGoodsDialog;
import com.xhc.bigbusinessu.dialog.ShareDialog;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ShopGoodsDetailsActivity extends BaseActivity {
    @BindView(R.id.banner)
    Banner banner;


    List<String> mList;

    @BindView(R.id.list_view)
    RecyclerView evaluateListView;
    EvaluateAdapter evaluateAdapter;
    List<String> evaluateList;
    @BindView(R.id.rel_back)
    RelativeLayout relBack;
    @BindView(R.id.rel_share)
    RelativeLayout relShare;
    @BindView(R.id.lin_to_shop)
    LinearLayout linToShop;
    @BindView(R.id.lin_to_kefu)
    LinearLayout linToKefu;
    @BindView(R.id.lin_to_collection)
    LinearLayout linToCollection;
    @BindView(R.id.tv_do_car)
    TextView tvDoCar;
    @BindView(R.id.tv_do_pay)
    TextView tvDoPay;


    String city_goods_id;
    @BindView(R.id.tv_goods_name)
    TextView tvGoodsName;
    @BindView(R.id.tv_goods_price)
    TextView tvGoodsPrice;
    @BindView(R.id.tv_fahuo)
    TextView tvFahuo;
    @BindView(R.id.tv_postage)
    TextView tvPostage;
    @BindView(R.id.tv_shop_name)
    TextView tvShopName;
    @BindView(R.id.tv_shop_des)
    TextView tvShopDes;
    @BindView(R.id.img_shop)
    ImageView imgShop;

    @BindView(R.id.lin_img_content)
    LinearLayout linImgContent;


    ChooseGoodsDialog chooseGoodsDialog;
    GoodsDetailsEntity.DataBean goodsBean;

    int viewType;
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_shop_goods_details);
        city_goods_id = getIntent().getStringExtra("city_goods_id");
        viewType = getIntent().getIntExtra("view_type",0);
    }

    @Override
    protected void initUI() {
        setStatusBarFullTransparent(this);
        evaluateListView.setFocusable(false);
        evaluateListView.setLayoutManager(new LinearLayoutManager(this) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
    }

    @Override
    protected void initData() {

        mList = new ArrayList<>();
        banner.setAutoPlay(true)
                .setOffscreenPageLimit(mList.size())
                .setPages(mList, new CustomViewHolder())
                .setBannerStyle(BannerConfig.NUM_INDICATOR)
                .setBannerAnimation(Transformer.Default)
                .start();
        banner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        evaluateList = new ArrayList<>();
        evaluateList.add("1231");
        evaluateAdapter = new EvaluateAdapter(R.layout.item_goods_details_evaluate, evaluateList);
        evaluateListView.setAdapter(evaluateAdapter);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

        getData(city_goods_id);
    }


    @OnClick({R.id.rel_back, R.id.rel_share, R.id.lin_to_shop, R.id.lin_to_kefu, R.id.lin_to_collection, R.id.tv_do_car, R.id.tv_do_pay,R.id.rel_into_shop})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.rel_back: {
                goBack();
            }
            break;
            case R.id.rel_share: {

                new ShareDialog(this).show();
            }
            break;
            case R.id.lin_to_shop:
//                Intent intent = new Intent(this, ShopDetailsActivity.class);
//                intent.putExtra("store_id", goodsBean.getStore_id());
//                this.startActivity(intent);
            case R.id.rel_into_shop:
                Intent intent = new Intent(this, ShopDetailsActivity.class);
                intent.putExtra("store_id", goodsBean.getStore_id());
                intent.putExtra("view_type",viewType);
                this.startActivity(intent);
                break;
            case R.id.lin_to_kefu:
            {

            }
            break;
            case R.id.lin_to_collection:
            {

            }
            break;
            case R.id.tv_do_car:
                if (goodsBean == null) {
                    ToastMessage("请稍后重试");
                    return;
                }
                if (chooseGoodsDialog == null) {
                    chooseGoodsDialog = new ChooseGoodsDialog(this);
                }
                chooseGoodsDialog.show(new ChooseGoodsDialog.ChooseGoodsDialogListener() {
                    @Override
                    public void onChooseFinish(int payNum) {

                        addToCart(goodsBean.getCity_goods_id(), String.valueOf(payNum));
                    }
                }, goodsBean);

            break;
            case R.id.tv_do_pay:

                if (goodsBean == null) {
                    ToastMessage("请稍后重试");
                    return;
                }
                if (chooseGoodsDialog == null) {
                    chooseGoodsDialog = new ChooseGoodsDialog(this);
                }
                chooseGoodsDialog.show(new ChooseGoodsDialog.ChooseGoodsDialogListener() {
                    @Override
                    public void onChooseFinish(int payNum) {

                        sureOrderInfo(goodsBean.getCity_goods_id(), String.valueOf(payNum), goodsBean.getGoods_name());
                    }
                }, goodsBean);

            break;

            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    public class CustomViewHolder implements BannerViewHolder<String> {

        @SuppressLint("InflateParams")
        @Override
        public View createView(Context context, int position, String data) {
            View view = LayoutInflater.from(context).inflate(R.layout.item_goods_banner, null);

            ImageView img = view.findViewById(R.id.img);
            Glide.with(MyApplication.getInstance()).load(data).into(img);
            return view;
        }

    }


    class EvaluateAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public EvaluateAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

        }
    }


    private void getData(String city_goods_id) {

        ShopApi.getInstance().getGoodsDetails(new BaseCallback<GoodsDetailsEntity>(GoodsDetailsEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(GoodsDetailsEntity response) {

                if (response.getStatus() == 1) {

                    if (response.getData() != null) {
                        goodsBean = response.getData();
                        if (response.getData().getGallery() != null) {

                            mList.clear();
                            mList.addAll(response.getData().getGallery());
                            banner.update(mList);
                        }

                        tvGoodsName.setText(response.getData().getGoods_name());
                        tvGoodsPrice.setText("￥" + response.getData().getCity_goods_price());

                        tvShopName.setText(response.getData().getStore_name());
//                        tvShopDes.setText("商品数量:"+response.getData().getStore().getStore_goods_num()+"  已拼"+response.getData().getStore().getStore_goods_num()+"万件");
                        tvShopDes.setText("商品数量:" + response.getData().getStore().getStore_goods_num() + "  " + response.getData().getStore().getStore_collect() + "人关注");
                        GlideUtils.loadImg(imgShop, response.getData().getStore().getStore_logo());

                        if (response.getData().getContent_images() != null) {

                            for (String url : response.getData().getContent_images()) {

                                ImageView img = new ImageView(ShopGoodsDetailsActivity.this);
                                LinearLayout.LayoutParams llp = new LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.MATCH_PARENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT, 1);
                                img.setLayoutParams(llp);
                                GlideUtils.loadImg(img, url);

                                linImgContent.addView(img);
                            }
                        }

                    } else {

                    }
                } else {
                    ToastMessage(response.getMsg());
                    finish();
                }
            }
        }, city_goods_id, MyApplication.getInstance().getCityId());
    }


    /**
     * 确认订单
     *
     * @param city_goods_ids
     * @param goods_nums
     * @param goods_names
     */
    private void sureOrderInfo(String city_goods_ids, String goods_nums, String goods_names) {

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
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("bean", response.getData());
                    mystartActivity(ConfigGoodsOrderActivity.class, bundle);
                } else {

                    ToastMessage(response.getMsg());
                }

            }
        }, city_goods_ids, goods_nums, goods_names);
    }

    private void addToCart(String city_goods_id, String goods_num) {

        CarApi.getInstance().addCart(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {

                ToastMessage("添加购物车网络异常");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                if(response.getStatus()==1){
                    ToastMessage(response.getMsg());
                }

            }
        }, city_goods_id, goods_num);
    }
}
