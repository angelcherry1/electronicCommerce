// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.ruralTourism;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class RuralTourismDetailsActivity_ViewBinding implements Unbinder {
  private RuralTourismDetailsActivity target;

  private View view7f0801b7;

  private View view7f080147;

  @UiThread
  public RuralTourismDetailsActivity_ViewBinding(RuralTourismDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public RuralTourismDetailsActivity_ViewBinding(final RuralTourismDetailsActivity target,
      View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.rel_back, "method 'onViewClicked'");
    view7f0801b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_show_spell_list, "method 'onViewClicked'");
    view7f080147 = view;
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
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    target = null;


    view7f0801b7.setOnClickListener(null);
    view7f0801b7 = null;
    view7f080147.setOnClickListener(null);
    view7f080147 = null;
  }
}
