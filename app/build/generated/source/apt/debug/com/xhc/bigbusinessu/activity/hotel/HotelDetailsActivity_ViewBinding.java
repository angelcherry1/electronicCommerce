// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.hotel;

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

public class HotelDetailsActivity_ViewBinding implements Unbinder {
  private HotelDetailsActivity target;

  private View view7f0801b7;

  private View view7f0801cb;

  private View view7f08013b;

  @UiThread
  public HotelDetailsActivity_ViewBinding(HotelDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HotelDetailsActivity_ViewBinding(final HotelDetailsActivity target, View source) {
    this.target = target;

    View view;
    target.roomListView = Utils.findRequiredViewAsType(source, R.id.hotel_list_view, "field 'roomListView'", RecyclerView.class);
    target.evaluateListView = Utils.findRequiredViewAsType(source, R.id.evaluate_list_view, "field 'evaluateListView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.rel_back, "method 'onViewClicked'");
    view7f0801b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rel_share, "method 'onViewClicked'");
    view7f0801cb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_room_screen, "method 'onViewClicked'");
    view7f08013b = view;
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
    HotelDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.roomListView = null;
    target.evaluateListView = null;

    view7f0801b7.setOnClickListener(null);
    view7f0801b7 = null;
    view7f0801cb.setOnClickListener(null);
    view7f0801cb = null;
    view7f08013b.setOnClickListener(null);
    view7f08013b = null;
  }
}
