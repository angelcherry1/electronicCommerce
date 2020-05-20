// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.life.push;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LifePushNeedActivity_ViewBinding implements Unbinder {
  private LifePushNeedActivity target;

  private View view7f0801f7;

  private View view7f0801ce;

  private View view7f0801f6;

  private View view7f08025d;

  @UiThread
  public LifePushNeedActivity_ViewBinding(LifePushNeedActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LifePushNeedActivity_ViewBinding(final LifePushNeedActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.server_type, "field 'server_type' and method 'onViewClickNeed'");
    target.server_type = Utils.castView(view, R.id.server_type, "field 'server_type'", ImageView.class);
    view7f0801f7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClickNeed(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rg_sex, "field 'rg_sex' and method 'onViewClickNeed'");
    target.rg_sex = Utils.castView(view, R.id.rg_sex, "field 'rg_sex'", RadioGroup.class);
    view7f0801ce = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClickNeed(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.server_time, "field 'server_time' and method 'onViewClickNeed'");
    target.server_time = Utils.castView(view, R.id.server_time, "field 'server_time'", TextView.class);
    view7f0801f6 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClickNeed(p0);
      }
    });
    target.server_indroction = Utils.findRequiredViewAsType(source, R.id.server_indroction, "field 'server_indroction'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_do, "field 'tv_do' and method 'onViewClickNeed'");
    target.tv_do = Utils.castView(view, R.id.tv_do, "field 'tv_do'", TextView.class);
    view7f08025d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClickNeed(p0);
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    LifePushNeedActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.server_type = null;
    target.rg_sex = null;
    target.server_time = null;
    target.server_indroction = null;
    target.tv_do = null;

    view7f0801f7.setOnClickListener(null);
    view7f0801f7 = null;
    view7f0801ce.setOnClickListener(null);
    view7f0801ce = null;
    view7f0801f6.setOnClickListener(null);
    view7f0801f6 = null;
    view7f08025d.setOnClickListener(null);
    view7f08025d = null;
  }
}
