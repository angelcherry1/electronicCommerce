// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.hotel;

import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HotelSubOrderActivity_ViewBinding implements Unbinder {
  private HotelSubOrderActivity target;

  private View view7f0801c0;

  private View view7f080146;

  private View view7f080264;

  @UiThread
  public HotelSubOrderActivity_ViewBinding(HotelSubOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HotelSubOrderActivity_ViewBinding(final HotelSubOrderActivity target, View source) {
    this.target = target;

    View view;
    target.mLinOrderDetail = Utils.findRequiredViewAsType(source, R.id.lin_order_details, "field 'mLinOrderDetail'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.rel_choose_user, "method 'onViewClicked'");
    view7f0801c0 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_show_details, "method 'onViewClicked'");
    view7f080146 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_do_sub_order, "method 'onViewClicked'");
    view7f080264 = view;
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
    HotelSubOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.mLinOrderDetail = null;

    view7f0801c0.setOnClickListener(null);
    view7f0801c0 = null;
    view7f080146.setOnClickListener(null);
    view7f080146 = null;
    view7f080264.setOnClickListener(null);
    view7f080264 = null;
  }
}
