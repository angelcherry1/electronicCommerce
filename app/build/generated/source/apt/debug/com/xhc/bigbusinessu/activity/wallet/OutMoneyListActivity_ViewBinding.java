// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.wallet;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class OutMoneyListActivity_ViewBinding implements Unbinder {
  private OutMoneyListActivity target;

  @UiThread
  public OutMoneyListActivity_ViewBinding(OutMoneyListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public OutMoneyListActivity_ViewBinding(OutMoneyListActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    OutMoneyListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
