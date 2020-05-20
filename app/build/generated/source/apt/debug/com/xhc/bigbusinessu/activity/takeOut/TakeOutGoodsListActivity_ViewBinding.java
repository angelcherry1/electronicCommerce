// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.takeOut;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TakeOutGoodsListActivity_ViewBinding implements Unbinder {
  private TakeOutGoodsListActivity target;

  private View view7f0801b7;

  @UiThread
  public TakeOutGoodsListActivity_ViewBinding(TakeOutGoodsListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TakeOutGoodsListActivity_ViewBinding(final TakeOutGoodsListActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.rel_back, "method 'onClickViewed'");
    view7f0801b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickViewed(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0801b7.setOnClickListener(null);
    view7f0801b7 = null;
  }
}
