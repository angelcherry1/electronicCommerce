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
import com.ms.banner.Banner;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShopGoodsDetailsActivity_ViewBinding implements Unbinder {
  private ShopGoodsDetailsActivity target;

  private View view7f0801b7;

  private View view7f0801cb;

  private View view7f08014d;

  private View view7f08014c;

  private View view7f08014b;

  private View view7f08025f;

  private View view7f080261;

  private View view7f0801c6;

  @UiThread
  public ShopGoodsDetailsActivity_ViewBinding(ShopGoodsDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShopGoodsDetailsActivity_ViewBinding(final ShopGoodsDetailsActivity target, View source) {
    this.target = target;

    View view;
    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
    target.evaluateListView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'evaluateListView'", RecyclerView.class);
    view = Utils.findRequiredView(source, R.id.rel_back, "field 'relBack' and method 'onViewClicked'");
    target.relBack = Utils.castView(view, R.id.rel_back, "field 'relBack'", RelativeLayout.class);
    view7f0801b7 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.rel_share, "field 'relShare' and method 'onViewClicked'");
    target.relShare = Utils.castView(view, R.id.rel_share, "field 'relShare'", RelativeLayout.class);
    view7f0801cb = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_to_shop, "field 'linToShop' and method 'onViewClicked'");
    target.linToShop = Utils.castView(view, R.id.lin_to_shop, "field 'linToShop'", LinearLayout.class);
    view7f08014d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_to_kefu, "field 'linToKefu' and method 'onViewClicked'");
    target.linToKefu = Utils.castView(view, R.id.lin_to_kefu, "field 'linToKefu'", LinearLayout.class);
    view7f08014c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.lin_to_collection, "field 'linToCollection' and method 'onViewClicked'");
    target.linToCollection = Utils.castView(view, R.id.lin_to_collection, "field 'linToCollection'", LinearLayout.class);
    view7f08014b = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_do_car, "field 'tvDoCar' and method 'onViewClicked'");
    target.tvDoCar = Utils.castView(view, R.id.tv_do_car, "field 'tvDoCar'", TextView.class);
    view7f08025f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    view = Utils.findRequiredView(source, R.id.tv_do_pay, "field 'tvDoPay' and method 'onViewClicked'");
    target.tvDoPay = Utils.castView(view, R.id.tv_do_pay, "field 'tvDoPay'", TextView.class);
    view7f080261 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvGoodsName = Utils.findRequiredViewAsType(source, R.id.tv_goods_name, "field 'tvGoodsName'", TextView.class);
    target.tvGoodsPrice = Utils.findRequiredViewAsType(source, R.id.tv_goods_price, "field 'tvGoodsPrice'", TextView.class);
    target.tvFahuo = Utils.findRequiredViewAsType(source, R.id.tv_fahuo, "field 'tvFahuo'", TextView.class);
    target.tvPostage = Utils.findRequiredViewAsType(source, R.id.tv_postage, "field 'tvPostage'", TextView.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tv_shop_name, "field 'tvShopName'", TextView.class);
    target.tvShopDes = Utils.findRequiredViewAsType(source, R.id.tv_shop_des, "field 'tvShopDes'", TextView.class);
    target.imgShop = Utils.findRequiredViewAsType(source, R.id.img_shop, "field 'imgShop'", ImageView.class);
    target.linImgContent = Utils.findRequiredViewAsType(source, R.id.lin_img_content, "field 'linImgContent'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.rel_into_shop, "method 'onViewClicked'");
    view7f0801c6 = view;
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
    ShopGoodsDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.banner = null;
    target.evaluateListView = null;
    target.relBack = null;
    target.relShare = null;
    target.linToShop = null;
    target.linToKefu = null;
    target.linToCollection = null;
    target.tvDoCar = null;
    target.tvDoPay = null;
    target.tvGoodsName = null;
    target.tvGoodsPrice = null;
    target.tvFahuo = null;
    target.tvPostage = null;
    target.tvShopName = null;
    target.tvShopDes = null;
    target.imgShop = null;
    target.linImgContent = null;

    view7f0801b7.setOnClickListener(null);
    view7f0801b7 = null;
    view7f0801cb.setOnClickListener(null);
    view7f0801cb = null;
    view7f08014d.setOnClickListener(null);
    view7f08014d = null;
    view7f08014c.setOnClickListener(null);
    view7f08014c = null;
    view7f08014b.setOnClickListener(null);
    view7f08014b = null;
    view7f08025f.setOnClickListener(null);
    view7f08025f = null;
    view7f080261.setOnClickListener(null);
    view7f080261 = null;
    view7f0801c6.setOnClickListener(null);
    view7f0801c6 = null;
  }
}
