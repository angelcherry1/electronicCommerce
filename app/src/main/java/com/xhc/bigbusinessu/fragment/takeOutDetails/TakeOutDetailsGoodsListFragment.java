package com.xhc.bigbusinessu.fragment.takeOutDetails;

import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.SectionEntity;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.takeOut.TakeOutGoodsDetailsActivity;
import com.xhc.bigbusinessu.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class TakeOutDetailsGoodsListFragment extends BaseFragment {

    @BindView(R.id.left_list_view)
    RecyclerView leftListView;
    @BindView(R.id.right_list_view)
    RecyclerView rightListView;

    LeftAdapter leftAdapter;
    RightAdapter rightAdapter;

    List<String> leftDataList = new ArrayList<>();
    List<Bean> rightDataList = new ArrayList<>();

    @Override
    protected void setContentView() {

        setContentView(R.layout.frag_take_out_details_goods_list);
    }

    @Override
    protected void initUI() {

        rightListView.setLayoutManager(new LinearLayoutManager(getActivity()));

        Bean bean1 = new Bean(true, "主食");
        bean1.setName("香辣鸡腿堡");
        Bean bean2 = new Bean(false, "主食");
        bean2.setName("香辣鸡腿堡2");
        Bean bean3 = new Bean(false, "主食");
        bean3.setName("香辣鸡腿堡3");
        Bean bean4 = new Bean(false, "主食");
        bean4.setName("香辣鸡腿堡4");

        Bean bean5 = new Bean(true, "饮料");
        bean5.setName("可乐");
        Bean bean6 = new Bean(false, "");
        bean6.setName("可乐2");
        Bean bean7 = new Bean(false, "");
        bean7.setName("可乐3");
        Bean bean8 = new Bean(false, "");
        bean8.setName("可乐4");


        Bean bean9 = new Bean(true, "赠品");
        bean9.setName("贴纸");
        Bean bean10 = new Bean(false, "");
        bean10.setName("贴纸2");
        Bean bean11 = new Bean(false, "");
        bean11.setName("贴纸3");
        Bean bean12 = new Bean(false, "");
        bean12.setName("贴纸4");

        rightDataList.add(bean1);
        rightDataList.add(bean2);
        rightDataList.add(bean3);
        rightDataList.add(bean4);

        rightDataList.add(bean5);
        rightDataList.add(bean6);
        rightDataList.add(bean7);
        rightDataList.add(bean8);

        rightDataList.add(bean9);
        rightDataList.add(bean10);
        rightDataList.add(bean11);
        rightDataList.add(bean12);

        rightAdapter = new RightAdapter(R.layout.item_take_out_details_goods_list, R.layout.item_take_out_details_goods_list_head, rightDataList);
        rightListView.setAdapter(rightAdapter);


        leftListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        leftDataList.add("主食");
        leftDataList.add("饮料");
        leftDataList.add("赠品");
        leftAdapter = new LeftAdapter(R.layout.item_take_out_details_goods_list_left, leftDataList);
        leftListView.setAdapter(leftAdapter);

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


    @OnClick({R.id.lin_car_show,R.id.lin_car_do_pay})
    public void onClickView(View v){

        switch (v.getId()){
            case R.id.lin_car_show:

                break;

            case R.id.lin_car_do_pay:
                break;
        }
    }

    int selectPosition;

    class LeftAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public LeftAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            TextView tvTitle = helper.getView(R.id.tv_title);
            RelativeLayout relBg = helper.getView(R.id.rel_bg);
            if (selectPosition == helper.getAdapterPosition()) {
                tvTitle.setTextColor(Color.parseColor("#333333"));
                relBg.setBackgroundColor(Color.parseColor("#FFFFFF"));
            } else {
                tvTitle.setTextColor(Color.parseColor("#666666"));
                relBg.setBackgroundColor(Color.parseColor("#F0F0F0"));
            }
            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    selectPosition = helper.getAdapterPosition();
                    notifyDataSetChanged();
                }
            });
            tvTitle.setText(item);
        }
    }

    class RightAdapter extends BaseSectionQuickAdapter<Bean, BaseViewHolder> {


        /**
         * Same as QuickAdapter#QuickAdapter(Context,int) but with
         * some initialization data.
         *
         * @param layoutResId      The layout resource id of each item.
         * @param sectionHeadResId The section head layout id for each item
         * @param data             A new list is created out of this one to avoid mutable list
         */
        public RightAdapter(int layoutResId, int sectionHeadResId, List<Bean> data) {
            super(layoutResId, sectionHeadResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, Bean item) {

            helper.setText(R.id.tv_name, item.getName());

            helper.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mystartActivity(TakeOutGoodsDetailsActivity.class);
                }
            });

        }

        @Override
        protected void convertHead(BaseViewHolder helper, Bean item) {

            Log.e("Test", helper.getAdapterPosition() + "-------");
            helper.setText(R.id.head_tv, item.header);
            //http://thumbs.dreamstime.com/b/%E5%AF%BC%E8%88%AA%E6%A6%82%E8%BF%B0-%E5%85%B8%E6%B1%89%E5%A0%A1%E
        }
    }
        class Bean extends SectionEntity {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Bean(boolean isHeader, String header) {
            super(isHeader, header);
        }

    }
}
