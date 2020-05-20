// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.integral_recharge;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class IntegralRechargeActivity_ViewBinding implements Unbinder {
  private IntegralRechargeActivity target;

  @UiThread
  public IntegralRechargeActivity_ViewBinding(IntegralRechargeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public IntegralRechargeActivity_ViewBinding(IntegralRechargeActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    IntegralRechargeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
