package com.xhc.bigbusinessu.activity.hotel;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.hotel.HotelMultipleScreenSortPop;
import com.xhc.bigbusinessu.dialog.hotel.HotelScreenSortPop;
import com.xhc.bigbusinessu.dialog.hotel.PriceStarSortPop;
import com.xhc.bigbusinessu.dialog.hotel.RegionalLocationSortPop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class HotelListActivity extends BaseActivity {


    @BindView(R.id.list_view)
    RecyclerView listView;
    MyAdapter myAdapter;
    List<String> dataList;
    @BindView(R.id.tv_screen_1)
    TextView tvScreen1;
    @BindView(R.id.img_screen_1)
    ImageView imgScreen1;
    @BindView(R.id.lin_screen_1)
    LinearLayout linScreen1;
    @BindView(R.id.tv_screen_2)
    TextView tvScreen2;
    @BindView(R.id.img_screen_2)
    ImageView imgScreen2;
    @BindView(R.id.lin_screen_2)
    LinearLayout linScreen2;
    @BindView(R.id.tv_screen_3)
    TextView tvScreen3;
    @BindView(R.id.img_screen_3)
    ImageView imgScreen3;
    @BindView(R.id.lin_screen_3)
    LinearLayout linScreen3;
    @BindView(R.id.tv_screen_4)
    TextView tvScreen4;
    @BindView(R.id.img_screen_4)
    ImageView imgScreen4;
    @BindView(R.id.lin_screen_4)
    LinearLayout linScreen4;


    HotelScreenSortPop hotelScreenSortPop;//智能排序
    PriceStarSortPop priceStarSortPop;//价格星际
    RegionalLocationSortPop regionalLocationSortPop;//位置区域
    HotelMultipleScreenSortPop hotelMultipleScreenSortPop;//筛选

    @BindView(R.id.et_search)
    EditText etSearch;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_hotel_list);
    }

    @Override
    protected void initUI() {
        etSearch.setFocusable(false);
        showTitleBack();
        setTitleText("成都");

        listView.setLayoutManager(new LinearLayoutManager(this));


        hotelScreenSortPop = new HotelScreenSortPop(this, new HotelScreenSortPop.OnLifeConditionScreenSortPopListener() {
            @Override
            public void onDismiss() {
                tvScreen4.setTextColor(Color.parseColor("#333333"));
                imgScreen4.setImageResource(R.mipmap.icon_dialog_choose_nor);
            }

            @Override
            public void onChoose(int type) {

            }
        });

        priceStarSortPop = new PriceStarSortPop(this);

        regionalLocationSortPop = new RegionalLocationSortPop(this);

        hotelMultipleScreenSortPop = new HotelMultipleScreenSortPop(this);
    }

    @Override
    protected void initData() {

        dataList = new ArrayList<>();
        dataList.add("");
        dataList.add("");
        dataList.add("");
        dataList.add("");
        myAdapter = new MyAdapter(R.layout.item_hotel_list, dataList);
        listView.setAdapter(myAdapter);
        myAdapter.setUpFetchEnable(true);
        myAdapter.setUpFetchListener(new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {

            }
        });

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }


    @OnClick({R.id.lin_screen_1, R.id.lin_screen_2, R.id.lin_screen_3, R.id.lin_screen_4})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.lin_screen_1:
                tvScreen1.setTextColor(Color.parseColor("#FFB333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                tvScreen4.setTextColor(Color.parseColor("#333333"));
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_ed);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen4.setImageResource(R.mipmap.icon_dialog_choose_nor);
                showPop(1);
                break;

            case R.id.lin_screen_2:

                tvScreen2.setTextColor(Color.parseColor("#FFB333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                tvScreen4.setTextColor(Color.parseColor("#333333"));
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_ed);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen4.setImageResource(R.mipmap.icon_dialog_choose_nor);
                showPop(2);
                break;

            case R.id.lin_screen_3:

                tvScreen3.setTextColor(Color.parseColor("#FFB333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                tvScreen4.setTextColor(Color.parseColor("#333333"));
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_ed);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen4.setImageResource(R.mipmap.icon_dialog_choose_nor);
                showPop(3);
                break;

            case R.id.lin_screen_4:

                tvScreen4.setTextColor(Color.parseColor("#FFB333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                imgScreen4.setImageResource(R.mipmap.icon_dialog_choose_ed);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                showPop(4);

                break;
        }
    }

    private void showPop(int position) {

        switch (position) {
            case 1:
                hotelMultipleScreenSortPop.showAsDropDown(linScreen1);
                break;
            case 2:
                regionalLocationSortPop.showAsDropDown(linScreen2);
                break;
            case 3:
                priceStarSortPop.showAsDropDown(linScreen3);
                break;
            case 4:
                hotelScreenSortPop.showAsDropDown(linScreen4);
                break;

        }

    }

    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mystartActivity(HotelDetailsActivity.class);
                }
            });
        }
    }
}
