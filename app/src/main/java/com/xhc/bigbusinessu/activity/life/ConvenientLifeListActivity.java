package com.xhc.bigbusinessu.activity.life;

import android.graphics.Color;
import android.view.View;
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
import com.xhc.bigbusinessu.dialog.LifeConditionScreenConditionPop;
import com.xhc.bigbusinessu.dialog.LifeConditionScreenSortPop;
import com.xhc.bigbusinessu.dialog.LifeConditionScreenTypePop;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class ConvenientLifeListActivity extends BaseActivity {


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
    @BindView(R.id.list_view)
    RecyclerView listView;


    LifeConditionScreenTypePop lifeConditionScreenTypePop;
    LifeConditionScreenConditionPop lifeConditionScreenConditionPop;
    LifeConditionScreenSortPop lifeConditionScreenSortPop;



    List<String> dataList;
    MyAdapter myAdapter;
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_convenient_life_list);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("");

        listView.setLayoutManager(new LinearLayoutManager(this));
        dataList = new ArrayList<>();
        dataList.add("123");
        dataList.add("123");
        dataList.add("123");
        dataList.add("123");
        dataList.add("123");
        myAdapter = new MyAdapter(R.layout.item_service_home_1,dataList);
        listView.setAdapter(myAdapter);

        lifeConditionScreenTypePop = new LifeConditionScreenTypePop(this, new LifeConditionScreenTypePop.OnLifeConditionScreenPopListener() {
            @Override
            public void onDismiss() {
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
            }

            @Override
            public void onChoose(int type) {

            }
        });
        lifeConditionScreenConditionPop = new LifeConditionScreenConditionPop(this, new LifeConditionScreenConditionPop.OnLifeConditionScreenConditionPopListener() {
            @Override
            public void onDismiss() {
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
            }

            @Override
            public void onChoose(int type, int value) {

            }
        });
        lifeConditionScreenSortPop = new LifeConditionScreenSortPop(this, new LifeConditionScreenSortPop.OnLifeConditionScreenSortPopListener() {
            @Override
            public void onDismiss() {
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
            }

            @Override
            public void onChoose(int type) {

            }
        });

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initEvent() {

        linScreen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvScreen1.setTextColor(Color.parseColor("#FFB333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_ed);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                showPop(1);

            }
        });
        linScreen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvScreen2.setTextColor(Color.parseColor("#FFB333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                tvScreen3.setTextColor(Color.parseColor("#333333"));
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_ed);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_nor);
                showPop(2);
            }
        });
        linScreen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvScreen3.setTextColor(Color.parseColor("#FFB333"));
                tvScreen2.setTextColor(Color.parseColor("#333333"));
                tvScreen1.setTextColor(Color.parseColor("#333333"));
                imgScreen3.setImageResource(R.mipmap.icon_dialog_choose_ed);
                imgScreen2.setImageResource(R.mipmap.icon_dialog_choose_nor);
                imgScreen1.setImageResource(R.mipmap.icon_dialog_choose_nor);
                showPop(3);
            }
        });
    }

    @Override
    protected void startFunction() {

    }

    private void showPop(int position) {

        switch (position) {
            case 1:
                lifeConditionScreenTypePop.showAsDropDown(linScreen1);
                break;
            case 2:
                lifeConditionScreenConditionPop.showAsDropDown(linScreen2);
                break;
            case 3:
                lifeConditionScreenSortPop.showAsDropDown(linScreen3);
                break;

        }

    }

    class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder>{

        public MyAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {


            helper.getView(R.id.tv_do_app).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    mystartActivity(AppointmentHeActivity.class);
                }
            });
        }
    }
}
