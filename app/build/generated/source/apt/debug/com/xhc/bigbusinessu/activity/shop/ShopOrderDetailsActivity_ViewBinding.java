// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.shop;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ShopOrderDetailsActivity_ViewBinding implements Unbinder {
  private ShopOrderDetailsActivity target;

  @UiThread
  public ShopOrderDetailsActivity_ViewBinding(ShopOrderDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ShopOrderDetailsActivity_ViewBinding(ShopOrderDetailsActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    target.tvShopName = Utils.findRequiredViewAsType(source, R.id.tv_shop_name, "field 'tvShopName'", TextView.class);
    target.tvOrderDes = Utils.findRequiredViewAsType(source, R.id.tv_order_des, "field 'tvOrderDes'", TextView.class);
    target.rightBtn = Utils.findRequiredViewAsType(source, R.id.right_btn, "field 'rightBtn'", TextView.class);
    target.leftBtn = Utils.findRequiredViewAsType(source, R.id.left_btn, "field 'leftBtn'", TextView.class);
    target.leftBtn2 = Utils.findRequiredViewAsType(source, R.id.left_btn2, "field 'leftBtn2'", TextView.class);
    target.leftBtn3 = Utils.findRequiredViewAsType(source, R.id.left_btn3, "field 'leftBtn3'", TextView.class);
    target.linOrderInfo = Utils.findRequiredViewAsType(source, R.id.lin_order_no, "field 'linOrderInfo'", LinearLayout.class);
    target.tvOrderNo = Utils.findRequiredViewAsType(source, R.id.tv_order_no, "field 'tvOrderNo'", TextView.class);
    target.linOrderPayTime = Utils.findRequiredViewAsType(source, R.id.lin_order_pay_time, "field 'linOrderPayTime'", LinearLayout.class);
    target.tvOrderPayTime = Utils.findRequiredViewAsType(source, R.id.tv_order_pay_time, "field 'tvOrderPayTime'", TextView.class);
    target.linOrderSendTime = Utils.findRequiredViewAsType(source, R.id.lin_order_send_time, "field 'linOrderSendTime'", LinearLayout.class);
    target.tvOrderSendTime = Utils.findRequiredViewAsType(source, R.id.tv_order_send_time, "field 'tvOrderSendTime'", TextView.class);
    target.tvConsignee = Utils.findRequiredViewAsType(source, R.id.tv_consignee, "field 'tvConsignee'", TextView.class);
    target.tvAddress = Utils.findRequiredViewAsType(source, R.id.tv_address, "field 'tvAddress'", TextView.class);
    target.tvTopTitle = Utils.findRequiredViewAsType(source, R.id.tv_top_title, "field 'tvTopTitle'", TextView.class);
    target.tvTopDes = Utils.findRequiredViewAsType(source, R.id.tv_top_des, "field 'tvTopDes'", TextView.class);
    target.linearLayout = Utils.findRequiredViewAsType(source, R.id.lin_express_info, "field 'linearLayout'", LinearLayout.class);
    target.tvExpressInfo = Utils.findRequiredViewAsType(source, R.id.tv_express_info, "field 'tvExpressInfo'", TextView.class);
    target.tvExpressTime = Utils.findRequiredViewAsType(source, R.id.tv_express_time, "field 'tvExpressTime'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ShopOrderDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.tvShopName = null;
    target.tvOrderDes = null;
    target.rightBtn = null;
    target.leftBtn = null;
    target.leftBtn2 = null;
    target.leftBtn3 = null;
    target.linOrderInfo = null;
    target.tvOrderNo = null;
    target.linOrderPayTime = null;
    target.tvOrderPayTime = null;
    target.linOrderSendTime = null;
    target.tvOrderSendTime = null;
    target.tvConsignee = null;
    target.tvAddress = null;
    target.tvTopTitle = null;
    target.tvTopDes = null;
    target.linearLayout = null;
    target.tvExpressInfo = null;
    target.tvExpressTime = null;
  }
}
