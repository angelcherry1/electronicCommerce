// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.shop;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SearchForGoodsActivity_ViewBinding implements Unbinder {
  private SearchForGoodsActivity target;

  private View view7f0801b7;

  private View view7f080122;

  @UiThread
  public SearchForGoodsActivity_ViewBinding(SearchForGoodsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SearchForGoodsActivity_ViewBinding(final SearchForGoodsActivity target, View source) {
    this.target = target;

    View view;
    target.etSearch = Utils.findRequiredViewAsType(source, R.id.et_search, "field 'etSearch'", EditText.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.rel_back, "method 'onViewClicked'");
    view7f0801b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_do_search, "method 'onViewClicked'");
    view7f080122 = view;
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
    SearchForGoodsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etSearch = null;
    target.listView = null;

    view7f0801b7.setOnClickListener(null);
    view7f0801b7 = null;
    view7f080122.setOnClickListener(null);
    view7f080122 = null;
  }
}
