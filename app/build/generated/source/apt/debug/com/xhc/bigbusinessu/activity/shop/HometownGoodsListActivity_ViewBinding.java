// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.shop;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class HometownGoodsListActivity_ViewBinding implements Unbinder {
  private HometownGoodsListActivity target;

  private View view7f080140;

  private View view7f0801b7;

  private View view7f080121;

  private View view7f080256;

  @UiThread
  public HometownGoodsListActivity_ViewBinding(HometownGoodsListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HometownGoodsListActivity_ViewBinding(final HometownGoodsListActivity target,
      View source) {
    this.target = target;

    View view;
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    target.hListView = Utils.findRequiredViewAsType(source, R.id.h_list_view, "field 'hListView'", RecyclerView.class);
    target.tvCity = Utils.findRequiredViewAsType(source, R.id.tv_city, "field 'tvCity'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lin_search, "method 'onViewClicked'");
    view7f080140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rel_back, "method 'onViewClicked'");
    view7f0801b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_choose_city, "method 'onViewClicked'");
    view7f080121 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_classify, "method 'onViewClicked'");
    view7f080256 = view;
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
    HometownGoodsListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.hListView = null;
    target.tvCity = null;

    view7f080140.setOnClickListener(null);
    view7f080140 = null;
    view7f0801b7.setOnClickListener(null);
    view7f0801b7 = null;
    view7f080121.setOnClickListener(null);
    view7f080121 = null;
    view7f080256.setOnClickListener(null);
    view7f080256 = null;
  }
}
