package com.xhc.bigbusinessu.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.google.gson.Gson;
import com.xhc.bigbusinessu.Entity.GoodsDetailsEntity;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.utils.BigDecimalUtils;
import com.xhc.bigbusinessu.utils.GlideUtils;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChooseGoodsDialog extends Dialog {


    ImageView ivImage;
    TextView tvMoney;
    TextView tvLeaveNumber;
    LinearLayout llClose;
    RecyclerView recyclerView;
    ImageView ivSub;
    EditText etGoodNum;
    ImageView ivAdd;
    Button btnSure;

    private int sum = 0;//购买商品库存


    //    private ThingsDetails thingsDetails;//获取商品详情
//    private HashMap<Integer, String> map;
    private int countNum = 1;//购买商品数量
    Context context;

    ChooseGoodsDialogListener chooseGoodsDialogListener;


    public ChooseGoodsDialog(@NonNull Context context) {
        super(context, R.style.CustomDialog);
        this.context = context;
        setContentView(R.layout.dialog_choose_goods);
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

    public void show(ChooseGoodsDialogListener chooseGoodsDialogListener, GoodsDetailsEntity.DataBean bean) {
        super.show();
        this.chooseGoodsDialogListener = chooseGoodsDialogListener;

        GlideUtils.loadImg(ivImage, bean.getOriginal_img());
        tvMoney.setText("￥" + bean.getCity_goods_price());
        tvLeaveNumber.setText("库存" + bean.getStore_count() + "件");

        sum = Integer.parseInt(bean.getStore_count());
    }

    private void initView() {
//        String jsonString="";
//        try {
//            InputStream is =    context.getAssets().open("goods.json");//打开json数据
//            byte[] by = new byte[is.available()];//转字节
//            is.read(by);
//            jsonString = new String(by, "utf-8");
//            is.close();//关闭流
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        Gson gson = new Gson();
//        thingsDetails = gson.fromJson(jsonString, ThingsDetails.class);
//
//
//        map = new HashMap<>();

        ivImage = findViewById(R.id.iv_image);
        tvMoney = findViewById(R.id.tv_money);
        tvLeaveNumber = findViewById(R.id.tv_leave_number);
        llClose = findViewById(R.id.ll_close);
        recyclerView = findViewById(R.id.recycler_view);
        ivSub = findViewById(R.id.iv_sub);
        etGoodNum = findViewById(R.id.et_good_num);
        ivAdd = findViewById(R.id.iv_add);
        btnSure = findViewById(R.id.btn_sure);

        findViewById(R.id.tv_have_choose).setVisibility(View.INVISIBLE);//隐藏已选规格

//        Utils.setImageViewSigle(thingsDetails.getPics(), ivImage, mContext);

//        sum = thingsDetails.getNumber();
//        tvMoney.setText("¥ " + BigDecimalUtils.toDecimal(thingsDetails.getPlatform_price(), 2));
//        tvLeaveNumber.setText("库存" + thingsDetails.getNumber() + "件");
//        //****************************选择商品规格（开始）****************************************//
//        CustomLinearLayoutManager mLayoutManager = new CustomLinearLayoutManager(context);
//        mLayoutManager.setScrollEnabled(false);
//        recyclerView.setLayoutManager(mLayoutManager);
//        final ChooseGoodsAdapter chooseGoodsAdapter = new ChooseGoodsAdapter();
//        recyclerView.setAdapter(chooseGoodsAdapter);
//        chooseGoodsAdapter.addData(thingsDetails.getSpecTile());
//        //****************************初始化数据**********************************/
//        for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//            for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                thingsDetails.getSpecTile().get(i).getValues().get(j).setCanSelect(true);
//            }
//        }
//        //******************开始匹配前再把所有没货的id挑出来(开始)******************/
//        List<String> allIDList = new ArrayList<>();
//        List<String> allIDList1 = new ArrayList<>();
//        List<String> allList = new ArrayList<>();
//        for (int n = 0; n < thingsDetails.getSpecList().size(); n++) {
//            for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                    allList.add(thingsDetails.getSpecTile().get(i).getValues().get(j).getId());
//                    if (thingsDetails.getSpecList().get(n).getSpec_value_ids().contains(thingsDetails.getSpecTile().get(i).getValues().get(j).getId())) {
//                        allIDList.add(thingsDetails.getSpecList().get(n).getSpec_value_ids());
//                    }
//                }
//            }
//        }
//        for (int i = 0; i < allIDList.size(); i++) {
//            List<String> list = Arrays.asList(allIDList.get(i).split(","));
//            for (String s : list) {
//                allIDList1.add(s);
//            }
//        }
//        allList.removeAll(allIDList1);
//        for (int n = 0; n < allList.size(); n++) {
//            for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                    if (allList.get(n).contains(thingsDetails.getSpecTile().get(i).getValues().get(j).getId())) {
//                        thingsDetails.getSpecTile().get(i).getValues().get(j).setCanSelect(false);
//                    }
//                }
//            }
//        }
//        //****************开始匹配前再把所有没货的id挑出来(结束)*********************/
//        chooseGoodsAdapter.setTagItemOnClickListener(new ChooseGoodsAdapter.TagItemOnClick() {
//            @Override
//            public void onItemClick(View view, int positions, int position) {
//                //*********************布局切换相关(开始)*********************/
//                if (thingsDetails.getSpecTile().get(position).getValues().get(positions).isCanSelect()) {
//                    if (thingsDetails.getSpecTile().get(position).getValues().get(positions).isSelect()) {
//                        map.remove(position);
//                        thingsDetails.getSpecTile().get(position).getValues().get(positions).setSelect(false);
//                    } else {
//                        map.put(position, thingsDetails.getSpecTile().get(position).getValues().get(positions).getId());
//                        for (int i = 0; i < thingsDetails.getSpecTile().get(position).getValues().size(); i++) {
//                            thingsDetails.getSpecTile().get(position).getValues().get(i).setSelect(false);
//                        }
//                        thingsDetails.getSpecTile().get(position).getValues().get(positions).setSelect(true);
//                    }
//                    //*********************布局切换相关(结束)*********************/
//                    if (map.size() == chooseGoodsAdapter.getItemCount()) {
//                        Log.v("规格", "开始匹配");
//                        String ids = "";
//                        String ids1 = "";
//                        for (int i = 0; i < map.size(); i++) {
//                            ids += map.get(i) + ",";
//                        }
//                        if (map.size() >= 1) {
//                            for (int i = map.size() - 1; i >= 0; i--) {
//                                ids1 += map.get(i) + ",";
//                            }
//                        }
//                        boolean isHave = false;
//                        for (int i = 0; i < thingsDetails.getSpecList().size(); i++) {
//                            String idString = thingsDetails.getSpecList().get(i).getSpec_value_ids();
//                            if (ids.contains(idString) || ids1.contains(idString)) {
//                                isHave = true;
//                                Log.v("规格", "匹配到了");
////                                Utils.setImageViewSigle(thingsDetails.getSpecList().get(i).getPic(), ivImage, mContext);
//                                tvMoney.setText("¥ " + BigDecimalUtils.toDecimal(thingsDetails.getSpecList().get(i).getPlatform_price(), 2));
//                                tvLeaveNumber.setText("库存" + thingsDetails.getSpecList().get(i).getNumber() + "件");
//                                ((TextView) findViewById(R.id.tv_have_choose)).setText("已选择 " + thingsDetails.getSpecList().get(i).getSpec_value_texts());
//                                sum = thingsDetails.getSpecList().get(i).getNumber();
//                            }
//                        }
//                        if (!isHave) {
////                            Utils.setImageViewSigle(thingsDetails.getPics(), ivImage, mContext);
//                            tvMoney.setText("¥ " + BigDecimalUtils.toDecimal(thingsDetails.getPlatform_price(), 2));
//                            tvLeaveNumber.setText("库存" + 0 + "件");
//                            ((TextView) findViewById(R.id.tv_have_choose)).setText("已选择");
//                            sum = 0;
//                            Toast.makeText(context, "该规格没库存了", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                    //****************开始匹配********************/
//                    for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                        for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                            thingsDetails.getSpecTile().get(i).getValues().get(j).setCanSelect(true);
//                        }
//                    }
//                    List<String> idValue = new ArrayList<>();//所选的id在所有可选规格里的可能id
//                    List<String> idList = new ArrayList<>();//把这些id拆开，装里面
//                    List<String> allIdList = new ArrayList<>();//所有的可能id
//                    boolean isMath = true;//是否开始进行匹配
//                    //******************如果所有配对都有货就不进行以下所有的匹配了(开始)**********/
//                    int totalType = 1;
//                    for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                        totalType = totalType * thingsDetails.getSpecTile().get(i).getValues().size();
//                    }
//                    if (totalType == thingsDetails.getSpecList().size()) {
//                        isMath = false;
//                    }
//                    //******************如果所有配对都有货就不进行以下所有的匹配了(结束)**********/
//                    for (int i = 0; i < thingsDetails.getSpecList().size(); i++) {
//                        for (Map.Entry<Integer, String> m : map.entrySet()) {
//                            if (thingsDetails.getSpecList().get(i).getSpec_value_ids().contains(m.getValue())) {
//                                idValue.add(thingsDetails.getSpecList().get(i).getSpec_value_ids());
//                            }
//                        }
//                    }
//                    if (map.size() == 0) {//如果现在取消刚在选中的就当前没有一个被选中就不匹配了
//                        isMath = false;
//                    }
//                    if (isMath) {
//                        for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                            for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                                allIdList.add(thingsDetails.getSpecTile().get(i).getValues().get(j).getId());
//                            }
//                        }
//                        for (int i = 0; i < idValue.size(); i++) {
//                            List<String> list = Arrays.asList(idValue.get(i).split(","));
//                            for (String s : list) {
//                                idList.add(s);
//                            }
//                        }
//                        allIdList.removeAll(idList);
//                        for (int n = 0; n < allIdList.size(); n++) {
//                            for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                                for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                                    if (allIdList.get(n).contains(thingsDetails.getSpecTile().get(i).getValues().get(j).getId())) {
//                                        thingsDetails.getSpecTile().get(i).getValues().get(j).setCanSelect(false);
//                                    }
//                                }
//                            }
//                        }
//                        for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                            for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                                Log.v("规格打印", thingsDetails.getSpecTile().get(i).getValues().get(j).getId() + ":" + thingsDetails.getSpecTile().get(i).getValues().get(j).isCanSelect() + "");
//                            }
//                        }
//                    }
//                }
//                //***********************匹配结束******************************/
//                chooseGoodsAdapter.notifyDataSetChanged();
//                Log.v("规格", "" + thingsDetails.getSpecTile().get(position).getValues().get(positions).isSelect());
//                Log.v("规格", position + "," + map.get(position));
//            }
//        });
        //****************************选择商品规格（结束）****************************************//
        etGoodNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().startsWith("0") && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 2).equals(".")) {
                        etGoodNum.setText(s.subSequence(0, 1));
                        etGoodNum.setSelection(1);
                        return;
                    }
                }
                if (s.length() > 0) {
                    if (Integer.parseInt(s.toString().trim()) > sum) {
                        countNum = 1;
                        etGoodNum.setText("1");
                        Toast.makeText(context, "不能再加啦!", Toast.LENGTH_SHORT).show();
                    } else if (Integer.parseInt(s.toString().trim()) < 1) {
                        countNum = 1;
                        etGoodNum.setText("1");
                        Toast.makeText(context, "不能再减啦!", Toast.LENGTH_SHORT).show();
                    } else {
                        countNum = Integer.parseInt(s.toString().trim());
                    }
                } else {

                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        llClose.setOnClickListener(new View.OnClickListener() {//关闭弹框
            @Override
            public void onClick(View v) {
//                for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                    for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                        thingsDetails.getSpecTile().get(i).getValues().get(j).setSelect(false);
//                        thingsDetails.getSpecTile().get(i).getValues().get(j).setCanSelect(true);
//                    }
//                }
                dismiss();
            }
        });
        ivAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countNum < sum) {
                    countNum = countNum + 1;
                    etGoodNum.setText(countNum + "");
                } else {
                    Toast.makeText(context, "不能再加啦!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        ivSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (countNum > 1) {
                    countNum = countNum - 1;
                    etGoodNum.setText(countNum + "");
                } else {
                    Toast.makeText(context, "不能再减啦!", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//确定提交订单
//                int id = 0;
//                if (map.size() == chooseGoodsAdapter.getItemCount()) {
//                    String ids = "";
//                    for (int i = 0; i < map.size(); i++) {
//                        ids += map.get(i) + ",";
//                    }
//                    for (int i = 0; i < thingsDetails.getSpecList().size(); i++) {
//                        if (ids.contains(thingsDetails.getSpecList().get(i).getSpec_value_ids())) {
//                            id = thingsDetails.getSpecList().get(i).getId();
//                            sum = thingsDetails.getSpecList().get(i).getNumber();
//                        }
//                    }
//                    Log.v("规格1map.size", map.size() + "，" + ids);
//                    Log.v("规格2id", id + "");
//                    for (int i = 0; i < thingsDetails.getSpecTile().size(); i++) {
//                        for (int j = 0; j < thingsDetails.getSpecTile().get(i).getValues().size(); j++) {
//                            thingsDetails.getSpecTile().get(i).getValues().get(j).setSelect(false);
//                            thingsDetails.getSpecTile().get(i).getValues().get(j).setCanSelect(true);
//                        }
//                    }
//                    if (id != 0) {
//                        if (sum < Integer.parseInt(etGoodNum.getText().toString().trim())) {
//                            etGoodNum.setText("1");
//                        }
//                        dismiss();
//                        Bundle bundle = new Bundle();
//                        bundle.putString("whichActivity", "GroupBuyingActivity");
//                        bundle.putInt("good_id", thingsDetails.getGoods_id());
//                        bundle.putInt("good_id_ggs", id);
//                        bundle.putInt("count", Integer.parseInt(etGoodNum.getText().toString().trim()));
//                        bundle.putInt("type", 1);
////                        RxActivityTool.skipActivity(GroupBuyingActivity.this, SureOrderActivity.class, bundle);
//
//                        if(chooseGoodsDialogListener!=null){
//                            chooseGoodsDialogListener.onChooseFinish();
//                        }
//
//                    } else {
//                        Toast.makeText(context, "请重新选择规格!", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Log.v("规格", "请选择商品规格");
//                    Toast.makeText(context, "请选择商品规格!", Toast.LENGTH_SHORT).show();
//                }


                if (chooseGoodsDialogListener != null) {
                    chooseGoodsDialogListener.onChooseFinish(countNum);
                    dismiss();
                }
            }
        });


    }


    public interface ChooseGoodsDialogListener {
        void onChooseFinish(int payNum);
    }

    public class ThingsDetails {
        private int id = 0;
        private float promotion_price = 0;
        private int number = 0;
        private int order_base = 0;
        private int goods_id = 0;
        private String goods_name = "";
        private float market_price = 0;
        private float platform_price = 0;
        private String pics = "";
        private String bewrite = "";
        private float weight = 0;
        private float volume = 0;
        private int state = 0;
        private String url;
        private List<SpecTile> specTile;

        public class SpecTile {
            private List<Values> values;

            public class Values {
                private String id = "";
                private String name = "";
                private boolean isSelect = false;
                private boolean isCanSelect = true;

                public boolean isCanSelect() {
                    return isCanSelect;
                }

                public void setCanSelect(boolean canSelect) {
                    isCanSelect = canSelect;
                }

                public boolean isSelect() {
                    return isSelect;
                }

                public void setSelect(boolean select) {
                    isSelect = select;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }
            }

            private String name = "";

            public List<Values> getValues() {
                return values;
            }

            public void setValues(List<Values> values) {
                this.values = values;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public List<SpecTile> getSpecTile() {
            return specTile;
        }

        public void setSpecTile(List<SpecTile> specTile) {
            this.specTile = specTile;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public float getPromotion_price() {
            return promotion_price;
        }

        public void setPromotion_price(float promotion_price) {
            this.promotion_price = promotion_price;
        }

        public int getOrder_base() {
            return order_base;
        }

        public void setOrder_base(int order_base) {
            this.order_base = order_base;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public String getGoods_name() {
            return goods_name;
        }

        public void setGoods_name(String goods_name) {
            this.goods_name = goods_name;
        }

        public float getMarket_price() {
            return market_price;
        }

        public void setMarket_price(float market_price) {
            this.market_price = market_price;
        }

        public float getPlatform_price() {
            return platform_price;
        }

        public void setPlatform_price(float platform_price) {
            this.platform_price = platform_price;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getPics() {
            return pics;
        }

        public void setPics(String pics) {
            this.pics = pics;
        }

        public String getBewrite() {
            return bewrite;
        }

        public void setBewrite(String bewrite) {
            this.bewrite = bewrite;
        }

        public float getWeight() {
            return weight;
        }

        public void setWeight(float weight) {
            this.weight = weight;
        }

        public float getVolume() {
            return volume;
        }

        public void setVolume(float volume) {
            this.volume = volume;
        }

        public int getState() {
            return state;
        }

        public void setState(int state) {
            this.state = state;
        }

        public List<ThingsDetails.specList> getSpecList() {
            return specList;
        }

        public void setSpecList(List<ThingsDetails.specList> specList) {
            this.specList = specList;
        }

        private List<specList> specList;

        public class specList {
            private int id = 0;
            private String pic = "";
            private String goods_id = "";
            private String spec_ids = "";
            private String spec_texts = "";
            private String spec_value_ids = "";
            private String spec_value_texts = "";
            private float market_price = 0;
            private float platform_price = 0;
            private int number = 0;
            private int warn_number = 0;
            private String goods_no = "";
            private String bar_code = "";
            private String add_time = "";
            private int is_delete = 0;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getGoods_id() {
                return goods_id;
            }

            public void setGoods_id(String goods_id) {
                this.goods_id = goods_id;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getSpec_ids() {
                return spec_ids;
            }

            public void setSpec_ids(String spec_ids) {
                this.spec_ids = spec_ids;
            }

            public String getSpec_texts() {
                return spec_texts;
            }

            public void setSpec_texts(String spec_texts) {
                this.spec_texts = spec_texts;
            }

            public String getSpec_value_ids() {
                return spec_value_ids;
            }

            public void setSpec_value_ids(String spec_value_ids) {
                this.spec_value_ids = spec_value_ids;
            }

            public String getSpec_value_texts() {
                return spec_value_texts;
            }

            public void setSpec_value_texts(String spec_value_texts) {
                this.spec_value_texts = spec_value_texts;
            }

            public float getMarket_price() {
                return market_price;
            }

            public void setMarket_price(float market_price) {
                this.market_price = market_price;
            }

            public float getPlatform_price() {
                return platform_price;
            }

            public void setPlatform_price(float platform_price) {
                this.platform_price = platform_price;
            }

            public int getNumber() {
                return number;
            }

            public void setNumber(int number) {
                this.number = number;
            }

            public int getWarn_number() {
                return warn_number;
            }

            public void setWarn_number(int warn_number) {
                this.warn_number = warn_number;
            }

            public String getGoods_no() {
                return goods_no;
            }

            public void setGoods_no(String goods_no) {
                this.goods_no = goods_no;
            }

            public String getBar_code() {
                return bar_code;
            }

            public void setBar_code(String bar_code) {
                this.bar_code = bar_code;
            }

            public String getAdd_time() {
                return add_time;
            }

            public void setAdd_time(String add_time) {
                this.add_time = add_time;
            }

            public int getIs_delete() {
                return is_delete;
            }

            public void setIs_delete(int is_delete) {
                this.is_delete = is_delete;
            }
        }
    }

    public class CustomLinearLayoutManager extends LinearLayoutManager {
        private boolean isScrollEnabled = true;

        public CustomLinearLayoutManager(Context context) {
            super(context);
        }

        public void setScrollEnabled(boolean flag) {
            this.isScrollEnabled = flag;
        }

        @Override
        public boolean canScrollVertically() {
            return isScrollEnabled && super.canScrollVertically();
        }
    }

    public static class ChooseGoodsAdapter extends BaseQuickAdapter<ThingsDetails.SpecTile, BaseViewHolder> {
        public ChooseGoodsAdapter() {
            super(R.layout.item_choose_shop);
        }

        private TagItemOnClick tagItemOnClick;

        public interface TagItemOnClick {

            void onItemClick(View view, int position, int positions);
        }

        public void setTagItemOnClickListener(TagItemOnClick listener) {
            tagItemOnClick = listener;
        }

        @Override
        protected void convert(final BaseViewHolder helper, final ThingsDetails.SpecTile item) {
            final TagFlowLayout mFlowLayout = helper.getView(R.id.flow_layout_hot);
            helper.setText(R.id.tv_type, item.getName());
            final List<String> listString = new ArrayList<>();
            for (int i = 0; i < item.getValues().size(); i++) {
                listString.add(item.getValues().get(i).getName());
            }
            final LayoutInflater mInflater = LayoutInflater.from(mContext);
            mFlowLayout.setAdapter(new TagAdapter<String>(listString) {
                @Override
                public View getView(FlowLayout parent, int position, String s) {
                    TextView tv = (TextView) mInflater.inflate(R.layout.item_shop_group_text,
                            mFlowLayout, false);
                    tv.setText(s);
                    if (item.getValues().get(position).isSelect() && item.getValues().get(position).isCanSelect()) {
                        tv.setBackgroundResource(R.drawable.bg_btn_base);
                    } else {
                        tv.setBackgroundResource(R.drawable.bg_btn_gray);
                    }
                    if (item.getValues().get(position).isCanSelect()) {
                        tv.setEnabled(true);
                        tv.setTextColor(Color.parseColor("#565656"));
                    } else {
                        tv.setEnabled(false);
                        tv.setTextColor(Color.parseColor("#ffffff"));
                    }
                    return tv;
                }
            });

            mFlowLayout.setOnTagClickListener(new TagFlowLayout.OnTagClickListener() {
                @Override
                public boolean onTagClick(View view, int position, FlowLayout parent) {
                    if (tagItemOnClick != null) {
                        tagItemOnClick.onItemClick(view, position, helper.getPosition());
                    }
                    return true;
                }
            });
            mFlowLayout.setMaxSelectCount(1);
            helper.addOnClickListener(R.id.flow_layout_hot);
        }
    }
}
