package com.xhc.bigbusinessu.activity.shop;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.Entity.GoodsListEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.ShopApi;
import com.xhc.bigbusinessu.MyApplication;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.adapter.HometownGoodsListAdapter;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.utils.GlideUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchForGoodsActivity extends BaseActivity {

    @BindView(R.id.et_search)
    EditText etSearch;

    @BindView(R.id.list_view)
    RecyclerView listView;

    MyAdapter adapter;

    List<GoodsListEntity.DataBean.ListBean> dataList;

    String store_id;

    int viewType;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_search_for_goods);

        store_id = getIntent().getStringExtra("store_id");

        if(TextUtils.isEmpty(store_id)){
            store_id = "";
        }
        //页面来源
        viewType = getIntent().getIntExtra("view_type",0);
    }

    @Override
    protected void initUI() {
//        etSearch.setFocusable(false);

        dataList = new ArrayList<>();
        adapter = new MyAdapter(R.layout.item_home_town_godos_list, dataList);

        GridLayoutManager manager = new GridLayoutManager(this, 2, RecyclerView.VERTICAL, false);
        listView.setLayoutManager(manager);
        listView.setAdapter(adapter);
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

    @OnClick({R.id.rel_back,R.id.lin_do_search})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.rel_back:
                goBack();
                break;
            case R.id.lin_do_search:

                if(etSearch.getText().toString().trim().length()<=0){
                    ToastMessage("请输入关键词");
                    return;
                }

                doSearch(etSearch.getText().toString().trim());


                break;
        }

    }

    private void doSearch(String keyword) {

        showProgressDialog("搜索中");
        ShopApi.getInstance().getGoodsList(new BaseCallback<GoodsListEntity>(GoodsListEntity.class) {
            @Override
            protected void onError(Exception e) {

                disProgressDialog();
                ToastMessage("网路异常");
            }

            @Override
            protected void onSuccess(GoodsListEntity response) {
                disProgressDialog();
                if (response.getStatus() == 1) {

                    if (response.getData() != null) {

                        if (response.getData().getList() != null) {
                            dataList.clear();
                            dataList.addAll(response.getData().getList());
                            adapter.notifyDataSetChanged();
                        }
                    }
                } else {
                    ToastMessage(response.getMsg());
                }
            }
        }, MyApplication.getInstance().getCityId(), "", keyword, "", "", store_id, "", "",String.valueOf(viewType));

    }


    public class MyAdapter extends BaseQuickAdapter<GoodsListEntity.DataBean.ListBean, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<GoodsListEntity.DataBean.ListBean> data) {
            super(layoutResId, data);
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
                mContext.startActivity(intent);
            });
            helper.getView(R.id.lin_to_shop).setOnClickListener(view1 -> {

                Intent intent = new Intent(mContext, ShopDetailsActivity.class);
                intent.putExtra("store_id",item.getStore_id());
                mContext.startActivity(intent);
            });

        }
    }

}
