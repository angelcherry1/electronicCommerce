// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.me.setting;

import android.view.View;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.android.library.YLCircleImageView;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SetupActivity_ViewBinding implements Unbinder {
  private SetupActivity target;

  private View view7f0801cd;

  private View view7f0801c9;

  private View view7f0801b5;

  private View view7f080282;

  @UiThread
  public SetupActivity_ViewBinding(SetupActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public SetupActivity_ViewBinding(final SetupActivity target, View source) {
    this.target = target;

    View view;
    target.imgAvatar = Utils.findRequiredViewAsType(source, R.id.img_avatar, "field 'imgAvatar'", YLCircleImageView.class);
    target.tvMobile = Utils.findRequiredViewAsType(source, R.id.tv_mobile, "field 'tvMobile'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rel_user_info, "method 'onViewClicked'");
    view7f0801cd = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rel_my_address, "method 'onViewClicked'");
    view7f0801c9 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rel_account, "method 'onViewClicked'");
    view7f0801b5 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_logout, "method 'onViewClicked'");
    view7f080282 = view;
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
    SetupActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgAvatar = null;
    target.tvMobile = null;

    view7f0801cd.setOnClickListener(null);
    view7f0801cd = null;
    view7f0801c9.setOnClickListener(null);
    view7f0801c9 = null;
    view7f0801b5.setOnClickListener(null);
    view7f0801b5 = null;
    view7f080282.setOnClickListener(null);
    view7f080282 = null;
  }
}
