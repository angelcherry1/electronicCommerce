// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.shop;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DoPayActivity_ViewBinding implements Unbinder {
  private DoPayActivity target;

  @UiThread
  public DoPayActivity_ViewBinding(DoPayActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public DoPayActivity_ViewBinding(DoPayActivity target, View source) {
    this.target = target;

    target.cbWeChat = Utils.findRequiredViewAsType(source, R.id.cb_type_wechat, "field 'cbWeChat'", CheckBox.class);
    target.cbAli = Utils.findRequiredViewAsType(source, R.id.cb_type_ali, "field 'cbAli'", CheckBox.class);
    target.tvDoPay = Utils.findRequiredViewAsType(source, R.id.tv_do_pay, "field 'tvDoPay'", TextView.class);
    target.tvPrice = Utils.findRequiredViewAsType(source, R.id.tv_total_price, "field 'tvPrice'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    DoPayActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.cbWeChat = null;
    target.cbAli = null;
    target.tvDoPay = null;
    target.tvPrice = null;
  }
}
