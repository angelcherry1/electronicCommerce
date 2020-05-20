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

public class TakeOutDetailsGoodsListFragment_ViewBinding implements Unbinder {
  private TakeOutDetailsGoodsListFragment target;

  private View view7f080120;

  private View view7f08011f;

  @UiThread
  public TakeOutDetailsGoodsListFragment_ViewBinding(final TakeOutDetailsGoodsListFragment target,
      View source) {
    this.target = target;

    View view;
    target.leftListView = Utils.findRequiredViewAsType(source, R.id.left_list_view, "field 'leftListView'", RecyclerView.class);
    target.rightListView = Utils.findRequiredViewAsType(source, R.id.right_list_view, "field 'rightListView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.lin_car_show, "method 'onClickView'");
    view7f080120 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickView(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_car_do_pay, "method 'onClickView'");
    view7f08011f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickView(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    TakeOutDetailsGoodsListFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.leftListView = null;
    target.rightListView = null;

    view7f080120.setOnClickListener(null);
    view7f080120 = null;
    view7f08011f.setOnClickListener(null);
    view7f08011f = null;
  }
}
