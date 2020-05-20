// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.takeOut;

import android.view.View;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ms.banner.Banner;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class TakeOutGoodsDetailsActivity_ViewBinding implements Unbinder {
  private TakeOutGoodsDetailsActivity target;

  @UiThread
  public TakeOutGoodsDetailsActivity_ViewBinding(TakeOutGoodsDetailsActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public TakeOutGoodsDetailsActivity_ViewBinding(TakeOutGoodsDetailsActivity target, View source) {
    this.target = target;

    target.banner = Utils.findRequiredViewAsType(source, R.id.banner, "field 'banner'", Banner.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    TakeOutGoodsDetailsActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.banner = null;
  }
}
