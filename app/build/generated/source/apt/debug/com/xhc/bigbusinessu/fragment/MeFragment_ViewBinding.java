// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.fragment;

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

public class MeFragment_ViewBinding implements Unbinder {
  private MeFragment target;

  private View view7f0801ca;

  private View view7f08011d;

  private View view7f080141;

  private View view7f080142;

  private View view7f080143;

  private View view7f080144;

  private View view7f080145;

  private View view7f080238;

  private View view7f08023e;

  private View view7f08023f;

  private View view7f080240;

  private View view7f080242;

  private View view7f080243;

  private View view7f080244;

  private View view7f080245;

  private View view7f080239;

  private View view7f08023a;

  private View view7f08023b;

  private View view7f08023c;

  private View view7f08023d;

  @UiThread
  public MeFragment_ViewBinding(final MeFragment target, View source) {
    this.target = target;

    View view;
    target.imgAvatar = Utils.findRequiredViewAsType(source, R.id.img_avatar, "field 'imgAvatar'", YLCircleImageView.class);
    target.tvNickName = Utils.findRequiredViewAsType(source, R.id.tv_nick_name, "field 'tvNickName'", TextView.class);
    view = Utils.findRequiredView(source, R.id.rel_setting, "method 'onViewClicked'");
    view7f0801ca = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_all_order, "method 'onViewClicked'");
    view7f08011d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_shop_order_type_1, "method 'onViewClicked'");
    view7f080141 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_shop_order_type_2, "method 'onViewClicked'");
    view7f080142 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_shop_order_type_3, "method 'onViewClicked'");
    view7f080143 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_shop_order_type_4, "method 'onViewClicked'");
    view7f080144 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_shop_order_type_5, "method 'onViewClicked'");
    view7f080145 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv1, "method 'onViewClicked'");
    view7f080238 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv2, "method 'onViewClicked'");
    view7f08023e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv3, "method 'onViewClicked'");
    view7f08023f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv4, "method 'onViewClicked'");
    view7f080240 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv6, "method 'onViewClicked'");
    view7f080242 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv7, "method 'onViewClicked'");
    view7f080243 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv8, "method 'onViewClicked'");
    view7f080244 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv9, "method 'onViewClicked'");
    view7f080245 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv10, "method 'onViewClicked'");
    view7f080239 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv11, "method 'onViewClicked'");
    view7f08023a = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv12, "method 'onViewClicked'");
    view7f08023b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv13, "method 'onViewClicked'");
    view7f08023c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv14, "method 'onViewClicked'");
    view7f08023d = view;
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
    MeFragment target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgAvatar = null;
    target.tvNickName = null;

    view7f0801ca.setOnClickListener(null);
    view7f0801ca = null;
    view7f08011d.setOnClickListener(null);
    view7f08011d = null;
    view7f080141.setOnClickListener(null);
    view7f080141 = null;
    view7f080142.setOnClickListener(null);
    view7f080142 = null;
    view7f080143.setOnClickListener(null);
    view7f080143 = null;
    view7f080144.setOnClickListener(null);
    view7f080144 = null;
    view7f080145.setOnClickListener(null);
    view7f080145 = null;
    view7f080238.setOnClickListener(null);
    view7f080238 = null;
    view7f08023e.setOnClickListener(null);
    view7f08023e = null;
    view7f08023f.setOnClickListener(null);
    view7f08023f = null;
    view7f080240.setOnClickListener(null);
    view7f080240 = null;
    view7f080242.setOnClickListener(null);
    view7f080242 = null;
    view7f080243.setOnClickListener(null);
    view7f080243 = null;
    view7f080244.setOnClickListener(null);
    view7f080244 = null;
    view7f080245.setOnClickListener(null);
    view7f080245 = null;
    view7f080239.setOnClickListener(null);
    view7f080239 = null;
    view7f08023a.setOnClickListener(null);
    view7f08023a = null;
    view7f08023b.setOnClickListener(null);
    view7f08023b = null;
    view7f08023c.setOnClickListener(null);
    view7f08023c = null;
    view7f08023d.setOnClickListener(null);
    view7f08023d = null;
  }
}
