// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.bbs;

import android.view.View;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PushBBSActivity_ViewBinding implements Unbinder {
  private PushBBSActivity target;

  @UiThread
  public PushBBSActivity_ViewBinding(PushBBSActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PushBBSActivity_ViewBinding(PushBBSActivity target, View source) {
    this.target = target;

    target.imgAdd = Utils.findRequiredViewAsType(source, R.id.img_add, "field 'imgAdd'", ImageView.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    PushBBSActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgAdd = null;
    target.listView = null;
  }
}
