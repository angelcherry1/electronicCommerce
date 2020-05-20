// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.life.push;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LifePushSkillActivity_ViewBinding implements Unbinder {
  private LifePushSkillActivity target;

  private View view7f08016f;

  private View view7f08016e;

  private View view7f080173;

  private View view7f08028c;

  @UiThread
  public LifePushSkillActivity_ViewBinding(LifePushSkillActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public LifePushSkillActivity_ViewBinding(final LifePushSkillActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.lp_skill, "field 'lp_skill' and method 'onClickView'");
    target.lp_skill = Utils.castView(view, R.id.lp_skill, "field 'lp_skill'", ImageView.class);
    view7f08016f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickView(p0);
      }
    });
    target.lp_type = Utils.findRequiredViewAsType(source, R.id.lp_type, "field 'lp_type'", TextView.class);
    target.lp_skill2 = Utils.findRequiredViewAsType(source, R.id.lp_skill2, "field 'lp_skill2'", EditText.class);
    target.lp_indruction = Utils.findRequiredViewAsType(source, R.id.lp_indruction, "field 'lp_indruction'", EditText.class);
    view = Utils.findRequiredView(source, R.id.lp_picture, "field 'lp_picture' and method 'onClickView'");
    target.lp_picture = Utils.castView(view, R.id.lp_picture, "field 'lp_picture'", ImageView.class);
    view7f08016e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickView(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lp_video, "field 'lp_video' and method 'onClickView'");
    target.lp_video = Utils.castView(view, R.id.lp_video, "field 'lp_video'", ImageView.class);
    view7f080173 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onClickView(p0);
      }
    });
    target.lp_offline = Utils.findRequiredViewAsType(source, R.id.lp_offline, "field 'lp_offline'", EditText.class);
    target.lp_tel_prices = Utils.findRequiredViewAsType(source, R.id.lp_tel_prices, "field 'lp_tel_prices'", EditText.class);
    view = Utils.findRequiredView(source, R.id.tv_ok_skill, "field 'tv_ok' and method 'onClickView'");
    target.tv_ok = Utils.castView(view, R.id.tv_ok_skill, "field 'tv_ok'", TextView.class);
    view7f08028c = view;
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
    LifePushSkillActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.lp_skill = null;
    target.lp_type = null;
    target.lp_skill2 = null;
    target.lp_indruction = null;
    target.lp_picture = null;
    target.lp_video = null;
    target.lp_offline = null;
    target.lp_tel_prices = null;
    target.tv_ok = null;

    view7f08016f.setOnClickListener(null);
    view7f08016f = null;
    view7f08016e.setOnClickListener(null);
    view7f08016e = null;
    view7f080173.setOnClickListener(null);
    view7f080173 = null;
    view7f08028c.setOnClickListener(null);
    view7f08028c = null;
  }
}
