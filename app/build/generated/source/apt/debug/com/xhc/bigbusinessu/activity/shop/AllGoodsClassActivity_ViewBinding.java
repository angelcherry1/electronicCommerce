// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.shop;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AllGoodsClassActivity_ViewBinding implements Unbinder {
  private AllGoodsClassActivity target;

  @UiThread
  public AllGoodsClassActivity_ViewBinding(AllGoodsClassActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public AllGoodsClassActivity_ViewBinding(AllGoodsClassActivity target, View source) {
    this.target = target;

    target.leftListView = Utils.findRequiredViewAsType(source, R.id.left_list_view, "field 'leftListView'", RecyclerView.class);
    target.rightListView = Utils.findRequiredViewAsType(source, R.id.right_list_view, "field 'rightListView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    AllGoodsClassActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.leftListView = null;
    target.rightListView = null;
  }
}
