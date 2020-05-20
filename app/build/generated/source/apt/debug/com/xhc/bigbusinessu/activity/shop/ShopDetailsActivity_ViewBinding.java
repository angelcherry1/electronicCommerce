// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.shop;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class ShopDetailsActivity_ViewBinding implements Unbinder {
  private ShopDetailsActivity target;

  private View view7f0801b7;

  private View view7f080140;

  private View view7f08014e;

  private View view7f08014f;

  private View view7f080150;

  private View view7f080151;

  private View view7f0800fd;

  @UiThread
  public ShopDetailsActivity_ViewBinding(ShopDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShopDetailsActivity_ViewBinding(final ShopDetailsActivity target, View source) {
    this.target = target;

    View view;
    view = Utils.findRequiredView(source, R.id.rel_back, "field 'relBack' and method 'onViewClicked'");
    target.relBack = Utils.castView(view, R.id.rel_back, "field 'relBack'", RelativeLayout.class);
    view7f0801b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_search, "field 'linSearch' and method 'onViewClicked'");
    target.linSearch = Utils.castView(view, R.id.lin_search, "field 'linSearch'", LinearLayout.class);
    view7f080140 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    target.imgShop = Utils.findRequiredViewAsType(source, R.id.img_shop, "field 'imgShop'", ImageView.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tv_shop_name, "field 'tvShopName'", TextView.class);
    target.tvShopDes = Utils.findRequiredViewAsType(source, R.id.tv_shop_des, "field 'tvShopDes'", TextView.class);
    target.tvType1 = Utils.findRequiredViewAsType(source, R.id.tv_type_1, "field 'tvType1'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lin_type_1, "field 'linType1' and method 'onViewClicked'");
    target.linType1 = Utils.castView(view, R.id.lin_type_1, "field 'linType1'", LinearLayout.class);
    view7f08014e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvType2 = Utils.findRequiredViewAsType(source, R.id.tv_type_2, "field 'tvType2'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lin_type_2, "field 'linType2' and method 'onViewClicked'");
    target.linType2 = Utils.castView(view, R.id.lin_type_2, "field 'linType2'", LinearLayout.class);
    view7f08014f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvType3 = Utils.findRequiredViewAsType(source, R.id.tv_type_3, "field 'tvType3'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lin_type_3, "field 'linType3' and method 'onViewClicked'");
    target.linType3 = Utils.castView(view, R.id.lin_type_3, "field 'linType3'", LinearLayout.class);
    view7f080150 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvType4 = Utils.findRequiredViewAsType(source, R.id.tv_type_4, "field 'tvType4'", TextView.class);
    view = Utils.findRequiredView(source, R.id.lin_type_4, "field 'linType4' and method 'onViewClicked'");
    target.linType4 = Utils.castView(view, R.id.lin_type_4, "field 'linType4'", LinearLayout.class);
    view7f080151 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.img_share, "method 'onViewClicked'");
    view7f0800fd = view;
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
    ShopDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.relBack = null;
    target.linSearch = null;
    target.listView = null;
    target.imgShop = null;
    target.tvShopName = null;
    target.tvShopDes = null;
    target.tvType1 = null;
    target.linType1 = null;
    target.tvType2 = null;
    target.linType2 = null;
    target.tvType3 = null;
    target.linType3 = null;
    target.tvType4 = null;
    target.linType4 = null;

    view7f0801b7.setOnClickListener(null);
    view7f0801b7 = null;
    view7f080140.setOnClickListener(null);
    view7f080140 = null;
    view7f08014e.setOnClickListener(null);
    view7f08014e = null;
    view7f08014f.setOnClickListener(null);
    view7f08014f = null;
    view7f080150.setOnClickListener(null);
    view7f080150 = null;
    view7f080151.setOnClickListener(null);
    view7f080151 = null;
    view7f0800fd.setOnClickListener(null);
    view7f0800fd = null;
  }
}
