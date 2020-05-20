package com.xhc.bigbusinessu.dialog.hotel.room;

import android.app.Dialog;
import android.content.ClipData;
import android.content.Context;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.activity.hotel.HotelDetailsActivity;

import java.util.ArrayList;
import java.util.List;

import co.lujun.androidtagview.TagContainerLayout;
import co.lujun.androidtagview.TagView;

public class HotelRoomScreenDialog extends Dialog {


    TextView tvType1, tvType2;

    TextView tvType;

    TagContainerLayout mTagContainerLayout;

    public HotelRoomScreenDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);
        setContentView(R.layout.dialog_hotel_room_screen);
        Window dialogWindow = getWindow();
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        DisplayMetrics d = context.getResources().getDisplayMetrics();
        // 获取屏幕宽、高用
        lp.width = (int) (d.widthPixels * 1.0);
        // 宽度设置为屏幕宽度的80%
        dialogWindow.setAttributes(lp);
        dialogWindow.setGravity(Gravity.BOTTOM);//内围区域底部显示
        setCanceledOnTouchOutside(false);
        initView();
    }


    private void initView() {

        tvType1 = findViewById(R.id.tv_type_1);
        tvType2 = findViewById(R.id.tv_type_2);
        tvType = findViewById(R.id.tv_type);

        tvType1.setOnClickListener(view -> {
            tvType1.setTextColor(Color.parseColor("#363636"));
            tvType1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

            tvType2.setTextColor(Color.parseColor("#666666"));
            tvType2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

            tvType.setText("床型");
            mTagContainerLayout.removeAllTags();
            String[] list = new String[]{"大床房", "双床房", "三人间", "单人房", "钟点房", "水床房", "山景房", "圆床房"};
            mTagContainerLayout.setTags(list);

        });
        tvType2.setOnClickListener(view -> {
            tvType2.setTextColor(Color.parseColor("#363636"));
            tvType2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

            tvType1.setTextColor(Color.parseColor("#666666"));
            tvType1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);

            tvType.setText("早餐");
            mTagContainerLayout.removeAllTags();
            String[] list = new String[]{"不含早", "含单早", "含双早", "含三早及以上"};
            mTagContainerLayout.setTags(list);
        });


        String[] list = new String[]{"大床房", "双床房", "三人间", "单人房", "钟点房", "水床房", "山景房", "圆床房"};
        mTagContainerLayout = findViewById(R.id.tagcontainerLayout);

        mTagContainerLayout.setOnTagClickListener(new TagView.OnTagClickListener() {
            @Override
            public void onTagClick(int position, String text) {
                Log.e("Test","点击了："+position);
                List<Integer> selectedPositions = mTagContainerLayout.getSelectedTagViewPositions();
                //deselect all tags when click on an unselected tag. Otherwise show toast.
                if (!selectedPositions.contains(position)) {
                    mTagContainerLayout.selectTagView(position);
                    TagView view = mTagContainerLayout.getTagView(position);
                    view.setTagBorderColor(Color.parseColor("#FFB333"));
                    view.setTagTextColor(Color.parseColor("#FFB333"));
                } else {
                    mTagContainerLayout.deselectTagView(position);
                    TagView view = mTagContainerLayout.getTagView(position);
                    view.setTagBorderColor(Color.parseColor("#999999"));
                    view.setTagTextColor(Color.parseColor("#666666"));
//                    //deselect all tags
//                    for (int i : selectedPositions) {
//                        mTagContainerLayout.deselectTagView(i);
//                    }
                }

            }

            @Override
            public void onTagLongClick(final int position, String text) {
                mTagContainerLayout.toggleSelectTagView(position);
                List<Integer> selectedPositions = mTagContainerLayout.getSelectedTagViewPositions();
            }

            @Override
            public void onSelectedTagDrag(int position, String text) {
                Log.e("Test","选中了："+position);
                //ClipData clip = ClipData.newPlainText("Text", text);
                TagView view = mTagContainerLayout.getTagView(position);
                view.setTagBorderColor(Color.parseColor("#FFB333"));
//                View.DragShadowBuilder shadow = new View.DragShadowBuilder(view);
//                view.startDrag(clip, shadow, Boolean.TRUE, 0);
            }

            @Override
            public void onTagCrossClick(int position) {
            }
        });
        mTagContainerLayout.setTags(list);
    }

}
