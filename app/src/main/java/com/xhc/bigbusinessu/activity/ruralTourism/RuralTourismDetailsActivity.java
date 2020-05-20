package com.xhc.bigbusinessu.activity.ruralTourism;

import android.view.View;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;
import com.xhc.bigbusinessu.dialog.TourismSpellListDialog;

import butterknife.OnClick;

public class RuralTourismDetailsActivity extends BaseActivity {
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_rural_tourism_details);
    }

    @Override
    protected void initUI() {
        setStatusBarFullTransparent(this);
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

    @OnClick({R.id.rel_back,R.id.lin_show_spell_list})
    public void onViewClicked(View v) {

        switch (v.getId()) {

            case R.id.rel_back:

                finish();

                break;

            case R.id.lin_show_spell_list:

                new TourismSpellListDialog(this).show();
                break;

        }

    }
}
