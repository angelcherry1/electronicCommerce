// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.fragment;

import android.view.View;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
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

public class CarFragment_ViewBinding implements Unbinder {
  private CarFragment target;

  private View view7f080266;

  private View view7f08024d;

  private View view7f0801b6;

  @UiThread
  public CarFragment_ViewBinding(final CarFragment target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.tv_edit, "field 'tvEdit' and method 'onViewClicked'");
    target.tvEdit = Utils.castView(view, R.id.tv_edit, "field 'tvEdit'", TextView.class);
    view7f080266 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.tv_btn, "field 'tvBtn' and method 'onViewClicked'");
    target.tvBtn = Utils.castView(view, R.id.tv_btn, "field 'tvBtn'", TextView.class);
    view7f08024d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rel_all_choose, "field 'relAllChoose' and method 'onViewClicked'");
    target.relAllChoose = Utils.castView(view, R.id.rel_all_choose, "field 'relAllChoose'", RelativeLayout.class);
    view7f0801b6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.cbAll = Utils.findRequiredViewAsType(source, R.id.cb_all, "field 'cbAll'", CheckBox.class);
    target.tvTotalView = Utils.findRequiredViewAsType(source, R.id.tv_total_price, "field 'tvTotalView'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    CarFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvEdit = null;
    target.listView = null;
    target.tvBtn = null;
    target.relAllChoose = null;
    target.cbAll = null;
    target.tvTotalView = null;

    view7f080266.setOnClickListener(null);
    view7f080266 = null;
    view7f08024d.setOnClickListener(null);
    view7f08024d = null;
    view7f0801b6.setOnClickListener(null);
    view7f0801b6 = null;
  }
}
