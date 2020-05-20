// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.ruralTourism;

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

public class RuralTourismActivity_ViewBinding implements Unbinder {
  private RuralTourismActivity target;

  private View view7f080149;

  @UiThread
  public RuralTourismActivity_ViewBinding(RuralTourismActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RuralTourismActivity_ViewBinding(final RuralTourismActivity target, View source) {
    this.target = target;

    View view;
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.lin_title_left, "method 'onClicked'");
    view7f080149 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClicked(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    RuralTourismActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;

    view7f080149.setOnClickListener(null);
    view7f080149 = null;
  }
}
