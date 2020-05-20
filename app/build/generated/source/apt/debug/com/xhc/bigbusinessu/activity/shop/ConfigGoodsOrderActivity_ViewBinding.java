// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.shop;

import android.view.View;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ConfigGoodsOrderActivity_ViewBinding implements Unbinder {
  private ConfigGoodsOrderActivity target;

  @UiThread
  public ConfigGoodsOrderActivity_ViewBinding(ConfigGoodsOrderActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConfigGoodsOrderActivity_ViewBinding(ConfigGoodsOrderActivity target, View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    target.tvExp1 = Utils.findRequiredViewAsType(source, R.id.tv_exp_type_1, "field 'tvExp1'", TextView.class);
    target.tvExp2 = Utils.findRequiredViewAsType(source, R.id.tv_exp_type_2, "field 'tvExp2'", TextView.class);
    target.relExp1 = Utils.findRequiredViewAsType(source, R.id.rel_exp_type_1, "field 'relExp1'", RelativeLayout.class);
    target.relExp2 = Utils.findRequiredViewAsType(source, R.id.rel_exp_type_2, "field 'relExp2'", RelativeLayout.class);
    target.tvTotalPrice = Utils.findRequiredViewAsType(source, R.id.tv_total_price, "field 'tvTotalPrice'", TextView.class);
    target.tvUserNameMobile = Utils.findRequiredViewAsType(source, R.id.tv_user_name_mobile, "field 'tvUserNameMobile'", TextView.class);
    target.tvUserAddress = Utils.findRequiredViewAsType(source, R.id.tv_user_address, "field 'tvUserAddress'", TextView.class);
    target.linUserAddress = Utils.findRequiredViewAsType(source, R.id.lin_user_address, "field 'linUserAddress'", LinearLayout.class);
    target.tvChooseAddress = Utils.findRequiredViewAsType(source, R.id.tv_choose_address, "field 'tvChooseAddress'", TextView.class);
    target.tvShipPrice = Utils.findRequiredViewAsType(source, R.id.tv_ship_price, "field 'tvShipPrice'", TextView.class);
    target.cbWeChat = Utils.findRequiredViewAsType(source, R.id.cb_type_wechat, "field 'cbWeChat'", CheckBox.class);
    target.cbAli = Utils.findRequiredViewAsType(source, R.id.cb_type_ali, "field 'cbAli'", CheckBox.class);
    target.tvSubOrder = Utils.findRequiredViewAsType(source, R.id.tv_sub_order, "field 'tvSubOrder'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConfigGoodsOrderActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.tvExp1 = null;
    target.tvExp2 = null;
    target.relExp1 = null;
    target.relExp2 = null;
    target.tvTotalPrice = null;
    target.tvUserNameMobile = null;
    target.tvUserAddress = null;
    target.linUserAddress = null;
    target.tvChooseAddress = null;
    target.tvShipPrice = null;
    target.cbWeChat = null;
    target.cbAli = null;
    target.tvSubOrder = null;
  }
}
