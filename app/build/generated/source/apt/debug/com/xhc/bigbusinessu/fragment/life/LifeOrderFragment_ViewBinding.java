// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.fragment.life;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LifeOrderFragment_ViewBinding implements Unbinder {
  private LifeOrderFragment target;

  @UiThread
  public LifeOrderFragment_ViewBinding(LifeOrderFragment target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    LifeOrderFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
