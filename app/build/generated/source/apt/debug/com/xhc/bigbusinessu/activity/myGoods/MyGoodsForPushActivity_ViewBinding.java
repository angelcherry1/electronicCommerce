// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.myGoods;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyGoodsForPushActivity_ViewBinding implements Unbinder {
  private MyGoodsForPushActivity target;

  private View view7f080296;

  @UiThread
  public MyGoodsForPushActivity_ViewBinding(MyGoodsForPushActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyGoodsForPushActivity_ViewBinding(final MyGoodsForPushActivity target, View source) {
    this.target = target;

    View view;
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_push, "method 'onViewClicked'");
    view7f080296 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    MyGoodsForPushActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;

    view7f080296.setOnClickListener(null);
    view7f080296 = null;
  }
}
