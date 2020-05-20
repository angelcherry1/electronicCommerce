package com.xhc.bigbusinessu.activity.invoice;

import android.view.View;

import com.xhc.bigbusinessu.R;
import com.xhc.bigbusinessu.base.BaseActivity;

public class EditInvoiceDetailsActivity extends BaseActivity {
    @Override
    protected void setContentView() {

        setContentView(R.layout.aty_edit_invoice_details);
    }

    @Override
    protected void initUI() {

        showTitleBack();
        setTitleText("添加发票抬头");
        setTitleRightText("保存", view -> {

        });
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
}
