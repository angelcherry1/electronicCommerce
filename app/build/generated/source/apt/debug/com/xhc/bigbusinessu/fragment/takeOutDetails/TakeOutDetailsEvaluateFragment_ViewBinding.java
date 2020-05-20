// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.fragment.takeOutDetails;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TakeOutDetailsEvaluateFragment_ViewBinding implements Unbinder {
  private TakeOutDetailsEvaluateFragment target;

  @UiThread
  public TakeOutDetailsEvaluateFragment_ViewBinding(TakeOutDetailsEvaluateFragment target,
      View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TakeOutDetailsEvaluateFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
