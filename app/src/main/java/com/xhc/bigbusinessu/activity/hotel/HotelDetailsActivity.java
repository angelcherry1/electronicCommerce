package com.xhc.bigbusinessu.activity.hotel;

import android.app.AlertDialog;
import android.content.ClipData;
import android.content.DialogInterface;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.ShareDialog;
import com.xhc.bigbusinessu.dialog.hotel.room.HotelRoomScreenDialog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;
import me.gujun.android.taggroup.TagGroup;

public class HotelDetailsActivity extends BaseActivity {


    TagContainerLayout mTagContainerLayout;


    @BindView(R.id.hotel_list_view)
    RecyclerView roomListView;
    List<String> roomDataList = new ArrayList<>();
    RoomAdapter roomAdapter;

    @BindView(R.id.evaluate_list_view)
    RecyclerView evaluateListView;
    List<String> evaluateDataList = new ArrayList<>();
    EvaluateAdapter evaluateAdapter;

    HotelRoomScreenDialog hotelRoomScreenDialog;

    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_hotel_details);
    }

    @Override
    protected void initUI() {


        String[] list3 = new String[]{"含早", "大床", "可取消"};

        mTagContainerLayout = (TagContainerLayout) findViewById(R.id.tagcontainerLayout3);

        mTagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                List<Integer> selectedPositions = mTagContainerLayout.getSelectedTagViewPositions();
                //deselect all tags when click on an unselected tag. Otherwise show toast.
                if (selectedPositions.isEmpty() || selectedPositions.contains(position)) {
                    Toast.makeText(HotelDetailsActivity.this, "click-position:" + position + ", text:" + text,
                            Toast.LENGTH_SHORT).show();
                } else {
                    //deselect all tags
                    for (int i : selectedPositions) {
                        mTagContainerLayout.deselectTagView(i);
                    }
                }

            }

            @Override
            public void onTagLongClick(final int position, String text) {
                mTagContainerLayout.toggleSelectTagView(position);

                List<Integer> selectedPositions = mTagContainerLayout.getSelectedTagViewPositions();
                Toast.makeText(HotelDetailsActivity.this, "selected-positions:" + selectedPositions.toString(),
                        Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onSelectedTagDrag(int position, String text) {
                ClipData clip = ClipData.newPlainText("Text", text);
                View view = mTagContainerLayout.getTagView(position);
                View.DragShadowBuilder shadow = new View.DragShadowBuilder(view);
                view.startDrag(clip, shadow, Boolean.TRUE, 0);
            }

            @Override
            public void onTagCrossClick(int position) {
            }
        });
        mTagContainerLayout.setTags(list3);


        roomListView.setFocusable(false);
        roomListView.setLayoutManager(new LinearLayoutManager(this));
        roomDataList.add("12");
        roomDataList.add("12");
        roomDataList.add("12");
        roomAdapter = new RoomAdapter(R.layout.item_hotel_details_room_list, roomDataList);
        roomListView.setAdapter(roomAdapter);

        evaluateListView.setFocusable(false);
        evaluateListView.setLayoutManager(new LinearLayoutManager(this));
        evaluateDataList.add("12");
        evaluateDataList.add("12");
        evaluateAdapter = new EvaluateAdapter(R.layout.item_goods_details_evaluate, evaluateDataList);
        evaluateListView.setAdapter(evaluateAdapter);

        hotelRoomScreenDialog = new HotelRoomScreenDialog(this);
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


    @OnClick({R.id.rel_back, R.id.rel_share, R.id.lin_room_screen})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.rel_back:
                finish();
                break;

            case R.id.rel_share:
                new ShareDialog(this).show();

                break;
            case R.id.lin_room_screen:
                hotelRoomScreenDialog.show();
                break;
        }
    }

    class RoomAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

        public RoomAdapter(int layoutResId, @Nullable List<String> data) {
            super(layoutResId, data);
        }

        @Override
        protected void convert(@NonNull BaseViewHolder helper, String item) {

            RelativeLayout relShowDetails = helper.getView(R.id.rel_show_details);

            RecyclerView listView = helper.getView(R.id.list_view);
            if (listView.getAdapter() == null) {

                List<String> dataList = new ArrayList<>();
                dataList.add("1");
                dataList.add("1");
                listView.setLayoutManager(new LinearLayoutManager(mContext));
                listView.setAdapter(new MyAdapter(R.layout.item_hotel_details_room_list_item, dataList));

            } else {
                MyAdapter myAdapter = (MyAdapter) listView.getAdapter();
                List<String> dataList = new ArrayList<>();
                dataList.add("1");
                dataList.add("1");
                dataList.add("1");
                myAdapter.setNewData(dataList);
            }

            relShowDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int isVis = listView.getVisibility();
                    if (isVis == View.VISIBLE) {
                        listView.setVisibility(View.GONE);
                    } else {
                        listView.setVisibility(View.VISIBLE);
                    }
                }
            });
        }


        class MyAdapter extends BaseQuickAdapter<String, BaseViewHolder> {

            public MyAdapter(int layoutResId, @Nullable List<String> data) {
                super(layoutResId, data);
            }

            @Override
            protected void convert(@NonNull BaseViewHolder helper, String item) {

                TextView tvReserve = helper.getView(R.id.tv_do_reserve);
                tvReserve.setOnClickListener(view -> {
                    mystartActivity(HotelSubOrderActivity.class);
                });
            }
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
}
