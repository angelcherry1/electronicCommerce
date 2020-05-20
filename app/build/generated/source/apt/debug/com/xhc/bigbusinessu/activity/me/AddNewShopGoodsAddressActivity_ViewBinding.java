// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.me;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddNewShopGoodsAddressActivity_ViewBinding implements Unbinder {
  private AddNewShopGoodsAddressActivity target;

  private View view7f080254;

  private View view7f08028b;

  @UiThread
  public AddNewShopGoodsAddressActivity_ViewBinding(AddNewShopGoodsAddressActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AddNewShopGoodsAddressActivity_ViewBinding(final AddNewShopGoodsAddressActivity target,
      View source) {
    this.target = target;

    View view;
    target.etUserName = Utils.findRequiredViewAsType(source, R.id.et_user_name, "field 'etUserName'", EditText.class);
    target.rbNan = Utils.findRequiredViewAsType(source, R.id.rb_nan, "field 'rbNan'", RadioButton.class);
    target.rbNv = Utils.findRequiredViewAsType(source, R.id.rb_nv, "field 'rbNv'", RadioButton.class);
    target.rgSex = Utils.findRequiredViewAsType(source, R.id.rg_sex, "field 'rgSex'", RadioGroup.class);
    target.etMoile = Utils.findRequiredViewAsType(source, R.id.et_moile, "field 'etMoile'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_choose_city, "field 'tvChooseCity' and method 'onViewClicked'");
    target.tvChooseCity = Utils.castView(view, R.id.tv_choose_city, "field 'tvChooseCity'", TextView.class);
    view7f080254 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etDetails = Utils.findRequiredViewAsType(source, R.id.et_details, "field 'etDetails'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_ok, "field 'tvOk' and method 'onViewClicked'");
    target.tvOk = Utils.castView(view, R.id.tv_ok, "field 'tvOk'", TextView.class);
    view7f08028b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.swDefault = Utils.findRequiredViewAsType(source, R.id.sw_default, "field 'swDefault'", Switch.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AddNewShopGoodsAddressActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etUserName = null;
    target.rbNan = null;
    target.rbNv = null;
    target.rgSex = null;
    target.etMoile = null;
    target.tvChooseCity = null;
    target.etDetails = null;
    target.tvOk = null;
    target.swDefault = null;

    view7f080254.setOnClickListener(null);
    view7f080254 = null;
    view7f08028b.setOnClickListener(null);
    view7f08028b = null;
  }
}
