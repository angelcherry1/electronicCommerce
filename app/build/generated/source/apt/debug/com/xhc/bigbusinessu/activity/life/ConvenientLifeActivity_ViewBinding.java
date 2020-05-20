// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.life;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConvenientLifeActivity_ViewBinding implements Unbinder {
  private ConvenientLifeActivity target;

  @UiThread
  public ConvenientLifeActivity_ViewBinding(ConvenientLifeActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConvenientLifeActivity_ViewBinding(ConvenientLifeActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    target.tvPushXu = Utils.findRequiredViewAsType(source, R.id.tv_push_xu, "field 'tvPushXu'", TextView.class);
    target.tvPushJi = Utils.findRequiredViewAsType(source, R.id.tv_push_ji, "field 'tvPushJi'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConvenientLifeActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.tvPushXu = null;
    target.tvPushJi = null;
  }
}
