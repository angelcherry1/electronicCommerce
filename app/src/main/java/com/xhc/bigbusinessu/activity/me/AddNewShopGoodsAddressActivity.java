package com.xhc.bigbusinessu.activity.me;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.google.gson.Gson;
import com.xhc.bigbusinessu.Entity.BaseEntity;
import com.xhc.bigbusinessu.Entity.JsonBean;
import com.xhc.bigbusinessu.Entity.MShopAddressListEntity;
import com.xhc.bigbusinessu.HttpUtils.BaseCallback;
import com.xhc.bigbusinessu.HttpUtils.UserApi;
import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

import org.json.JSONArray;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddNewShopGoodsAddressActivity extends BaseActivity {
    @BindView(R.id.et_user_name)
    EditText etUserName;
    @BindView(R.id.rb_nan)
    RadioButton rbNan;
    @BindView(R.id.rb_nv)
    RadioButton rbNv;
    @BindView(R.id.rg_sex)
    RadioGroup rgSex;
    @BindView(R.id.et_moile)
    EditText etMoile;
    @BindView(R.id.tv_choose_city)
    TextView tvChooseCity;
    @BindView(R.id.et_details)
    EditText etDetails;
    @BindView(R.id.tv_ok)
    TextView tvOk;
    @BindView(R.id.sw_default)
    Switch swDefault;

    private List<JsonBean> options1Items = new ArrayList<>();
    private ArrayList<ArrayList<JsonBean.SubBeanX>> options2Items = new ArrayList<>();
    private ArrayList<ArrayList<ArrayList<JsonBean.SubBeanX.SubBean>>> options3Items = new ArrayList<>();
    private Thread thread;
    private static final int MSG_LOAD_DATA = 0x0001;
    private static final int MSG_LOAD_SUCCESS = 0x0002;
    private static final int MSG_LOAD_FAILED = 0x0003;

    private static boolean isLoaded = false;

    String province;
    String city;
    String district;


    MShopAddressListEntity.DataBean addressBean;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_LOAD_DATA:
                    if (thread == null) {//如果已创建就不再重新创建子线程了

                        thread = new Thread(new Runnable() {
                            @Override
                            public void run() {
                                // 子线程中解析省市区数据
                                initJsonData();
                            }
                        });
                        thread.start();
                    }
                    break;

                case MSG_LOAD_SUCCESS:
                    isLoaded = true;
                    break;

                case MSG_LOAD_FAILED:
                    break;
            }
        }
    };


    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_add_new_shop_goods_address);


    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("新增收货地址");
    }

    @Override
    protected void initData() {
        mHandler.sendEmptyMessage(MSG_LOAD_DATA);

        if(getIntent().hasExtra("bean")){
            addressBean = (MShopAddressListEntity.DataBean) getIntent().getSerializableExtra("bean");
            if(addressBean!=null){
                etUserName.setText(addressBean.getConsignee());
                etMoile.setText(addressBean.getMobile());
                tvChooseCity.setText(addressBean.getProvince_name()+addressBean.getCity_name() + addressBean.getDistrict_name());

                province = addressBean.getProvince();
                city = addressBean.getCity();
                district = addressBean.getDistrict();
                etDetails.setText(addressBean.getAddress());
                swDefault.setChecked(addressBean.getIs_default().equals("1"));
            }
        }
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void startFunction() {

    }

    @OnClick({R.id.tv_choose_city, R.id.tv_ok})
    public void onViewClicked(View v) {

        switch (v.getId()) {
            case R.id.tv_choose_city:
                if (isLoaded)
                    showPickerView();
                break;

            case R.id.tv_ok:
                subData();
                break;

        }
    }

    private void subData() {

        String consignee = etUserName.getText().toString().trim();
        if (TextUtils.isEmpty(consignee)) {
            ToastMessage("请填写收货人的姓名");
            return;
        }
        String mobile = etMoile.getText().toString().trim();
        if (TextUtils.isEmpty(mobile)) {
            ToastMessage("请填写收货人的姓名");
            return;
        }

        if (TextUtils.isEmpty(province) || TextUtils.isEmpty(city) || TextUtils.isEmpty(district)) {

            ToastMessage("请选择地址");
            return;
        }
//        String  province = ;
//        String city
//        String  district
        String address = etDetails.getText().toString().trim();
        if (TextUtils.isEmpty(address)) {
            ToastMessage("请输入详细地址");
            return;
        }


        //    consignee Y  收货人
//    mobile Y  手机号
//    province Y  省ID
//    city Y  市ID
//    district Y  区/县ID
//    address Y  具体地址（不需要省市区）
//    address_id N  修改时必传，不传为新加
//    is_default N 0 是否默认地址
//
        showProgressDialog("保存中");
        UserApi.getInstance().addShopAddress(new BaseCallback<BaseEntity>(BaseEntity.class) {
            @Override
            protected void onError(Exception e) {

                disProgressDialog();
                ToastMessage("网络异常");
            }

            @Override
            protected void onSuccess(BaseEntity response) {
                ToastMessage(response.getMsg());
                if (response.getStatus() == 1) {
                    finish();
                }
            }
        }, consignee, mobile, province, city, district, address, "", swDefault.isChecked() ? 1 : 0);
    }


    private void showPickerView() {// 弹出选择器

        hideKeyboard();

        OptionsPickerView pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int options2, int options3, View v) {
                //返回的分别是三个级别的选中位置
                String opt1tx = options1Items.size() > 0 ?
                        options1Items.get(options1).getPickerViewText() : "";

                String opt2tx = options2Items.size() > 0
                        && options2Items.get(options1).size() > 0 ?
                        options2Items.get(options1).get(options2).getName() : "";

                String opt3tx = options2Items.size() > 0
                        && options3Items.get(options1).size() > 0
                        && options3Items.get(options1).get(options2).size() > 0 ?
                        options3Items.get(options1).get(options2).get(options3).getName() : "";

                String tx = opt1tx + opt2tx + opt3tx;
                tvChooseCity.setText(tx);

                province = options1Items.get(options1).getId();
                city = options2Items.get(options1).get(options2).getId();
                district = options3Items.get(options1).get(options2).get(options3).getId();

            }
        })

                .setTitleText("城市选择")
                .setDividerColor(Color.BLACK)
                .setTextColorCenter(Color.BLACK) //设置选中项文字颜色
                .setCancelColor(Color.GRAY)
                .setSubmitColor(Color.parseColor("#FFB333"))
                .setContentTextSize(20)
                .build();

        /*pvOptions.setPicker(options1Items);//一级选择器
        pvOptions.setPicker(options1Items, options2Items);//二级选择器*/
        pvOptions.setPicker(options1Items, options2Items, options3Items);//三级选择器
        pvOptions.show();
    }

    private void initJsonData() {//解析数据

        /**
         * 注意：assets 目录下的Json文件仅供参考，实际使用可自行替换文件
         * 关键逻辑在于循环体
         *
         * */
        String JsonData = getJson(this, "province.json");//获取assets目录下的json文件数据

        ArrayList<JsonBean> jsonBean = parseData(JsonData);//用Gson 转成实体

        /**
         * 添加省份数据
         *
         * 注意：如果是添加的JavaBean实体，则实体类需要实现 IPickerViewData 接口，
         * PickerView会通过getPickerViewText方法获取字符串显示出来。
         */
        options1Items = jsonBean;

        for (int i = 0; i < jsonBean.size(); i++) {//遍历省份
            ArrayList<JsonBean.SubBeanX> cityList = new ArrayList<>();//该省的城市列表（第二级）
            ArrayList<ArrayList<JsonBean.SubBeanX.SubBean>> province_AreaList = new ArrayList<>();//该省的所有地区列表（第三极）

            if (jsonBean.get(i).getSub() == null) {

                List<JsonBean.SubBeanX> list = new ArrayList<JsonBean.SubBeanX>();
                JsonBean.SubBeanX bean = new JsonBean.SubBeanX();
                bean.setId(jsonBean.get(i).getId());
                bean.setName(jsonBean.get(i).getName());
                bean.setParent_id(jsonBean.get(i).getParent_id());
                list.add(bean);
                jsonBean.get(i).setSub(list);
            }
            for (int c = 0; c < jsonBean.get(i).getSub().size(); c++) {//遍历该省份的所有城市
                JsonBean.SubBeanX cityName = jsonBean.get(i).getSub().get(c);
                cityList.add(cityName);//添加城市
                ArrayList<JsonBean.SubBeanX.SubBean> city_AreaList = new ArrayList<>();//该城市的所有地区列表

                //如果无地区数据，建议添加空字符串，防止数据为null 导致三个选项长度不匹配造成崩溃
                if (jsonBean.get(i).getSub().get(c).getSub() == null
                        || jsonBean.get(i).getSub().get(c).getSub().size() == 0) {
                    JsonBean.SubBeanX.SubBean b = new JsonBean.SubBeanX.SubBean();
                    b.setId(jsonBean.get(i).getSub().get(c).getId());
                    b.setName(jsonBean.get(i).getSub().get(c).getName());
                    b.setParent_id(jsonBean.get(i).getSub().get(c).getParent_id());
                    city_AreaList.add(b);
                } else {
                    city_AreaList.addAll(jsonBean.get(i).getSub().get(c).getSub());
                }

//                if (!(jsonBean.get(i).getSub().get(c).getSub() == null
//                        || jsonBean.get(i).getSub().get(c).getSub().size() == 0))
//                city_AreaList.addAll(jsonBean.get(i).getSub().get(c).getSub());

                province_AreaList.add(city_AreaList);//添加该省所有地区数据
            }

            /**
             * 添加城市数据
             */
            options2Items.add(cityList);

            /**
             * 添加地区数据
             */
            options3Items.add(province_AreaList);
        }

        mHandler.sendEmptyMessage(MSG_LOAD_SUCCESS);

    }


    public ArrayList<JsonBean> parseData(String result) {//Gson 解析

        ArrayList<JsonBean> detail = new ArrayList<>();
        try {
            JSONArray data = new JSONArray(result);
            Gson gson = new Gson();
            for (int i = 0; i < data.length(); i++) {
                JsonBean entity = gson.fromJson(data.optJSONObject(i).toString(), JsonBean.class);
                detail.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            mHandler.sendEmptyMessage(MSG_LOAD_FAILED);
        }
        return detail;
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mHandler != null) {
            mHandler.removeCallbacksAndMessages(null);
        }
    }

    public String getJson(Context context, String fileName) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            AssetManager assetManager = context.getAssets();
            BufferedReader bf = new BufferedReader(new InputStreamReader(
                    assetManager.open(fileName)));
            String line;
            while ((line = bf.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
