// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.fragment.takeOutDetails;

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

public class TakeOutDetailsBusinessFragment_ViewBinding implements Unbinder {
  private TakeOutDetailsBusinessFragment target;

  private View view7f0800ea;

  private View view7f0801b9;

  @UiThread
  public TakeOutDetailsBusinessFragment_ViewBinding(final TakeOutDetailsBusinessFragment target,
      View source) {
    this.target = target;

    View view;
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.img_call_shop, "method 'onViewClicked'");
    view7f0800ea = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rel_business_qualification, "method 'onViewClicked'");
    view7f0801b9 = view;
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
    TakeOutDetailsBusinessFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;

    view7f0800ea.setOnClickListener(null);
    view7f0800ea = null;
    view7f0801b9.setOnClickListener(null);
    view7f0801b9 = null;
  }
}
