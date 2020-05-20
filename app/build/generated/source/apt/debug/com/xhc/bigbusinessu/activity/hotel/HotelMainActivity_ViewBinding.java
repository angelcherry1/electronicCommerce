// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.hotel;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HotelMainActivity_ViewBinding implements Unbinder {
  private HotelMainActivity target;

  private View view7f08014e;

  private View view7f08014f;

  private View view7f08026d;

  @UiThread
  public HotelMainActivity_ViewBinding(HotelMainActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HotelMainActivity_ViewBinding(final HotelMainActivity target, View source) {
    this.target = target;

    View view;
    target.viewType1 = Utils.findRequiredView(source, R.id.view_type_1, "field 'viewType1'");
    target.viewType2 = Utils.findRequiredView(source, R.id.view_type_2, "field 'viewType2'");
    view = Utils.findRequiredView(source, R.id.lin_type_1, "method 'onViewClicked'");
    view7f08014e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_type_2, "method 'onViewClicked'");
    view7f08014f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_find, "method 'onViewClicked'");
    view7f08026d = view;
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
    HotelMainActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.viewType1 = null;
    target.viewType2 = null;

    view7f08014e.setOnClickListener(null);
    view7f08014e = null;
    view7f08014f.setOnClickListener(null);
    view7f08014f = null;
    view7f08026d.setOnClickListener(null);
    view7f08026d = null;
  }
}
