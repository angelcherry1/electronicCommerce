// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.life;

import android.view.View;
import android.widget.ImageView;
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

public class ConvenientLifeListActivity_ViewBinding implements Unbinder {
  private ConvenientLifeListActivity target;

  @UiThread
  public ConvenientLifeListActivity_ViewBinding(ConvenientLifeListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ConvenientLifeListActivity_ViewBinding(ConvenientLifeListActivity target, View source) {
    this.target = target;

    target.tvScreen1 = Utils.findRequiredViewAsType(source, R.id.tv_screen_1, "field 'tvScreen1'", TextView.class);
    target.imgScreen1 = Utils.findRequiredViewAsType(source, R.id.img_screen_1, "field 'imgScreen1'", ImageView.class);
    target.linScreen1 = Utils.findRequiredViewAsType(source, R.id.lin_screen_1, "field 'linScreen1'", LinearLayout.class);
    target.tvScreen2 = Utils.findRequiredViewAsType(source, R.id.tv_screen_2, "field 'tvScreen2'", TextView.class);
    target.imgScreen2 = Utils.findRequiredViewAsType(source, R.id.img_screen_2, "field 'imgScreen2'", ImageView.class);
    target.linScreen2 = Utils.findRequiredViewAsType(source, R.id.lin_screen_2, "field 'linScreen2'", LinearLayout.class);
    target.tvScreen3 = Utils.findRequiredViewAsType(source, R.id.tv_screen_3, "field 'tvScreen3'", TextView.class);
    target.imgScreen3 = Utils.findRequiredViewAsType(source, R.id.img_screen_3, "field 'imgScreen3'", ImageView.class);
    target.linScreen3 = Utils.findRequiredViewAsType(source, R.id.lin_screen_3, "field 'linScreen3'", LinearLayout.class);
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ConvenientLifeListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.tvScreen1 = null;
    target.imgScreen1 = null;
    target.linScreen1 = null;
    target.tvScreen2 = null;
    target.imgScreen2 = null;
    target.linScreen2 = null;
    target.tvScreen3 = null;
    target.imgScreen3 = null;
    target.linScreen3 = null;
    target.listView = null;
  }
}
