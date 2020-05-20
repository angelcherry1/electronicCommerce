// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.me;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class MyShopGoodsAddressListActivity_ViewBinding implements Unbinder {
  private MyShopGoodsAddressListActivity target;

  @UiThread
  public MyShopGoodsAddressListActivity_ViewBinding(MyShopGoodsAddressListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public MyShopGoodsAddressListActivity_ViewBinding(MyShopGoodsAddressListActivity target,
      View source) {
    this.target = target;

    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    MyShopGoodsAddressListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
  }
}
