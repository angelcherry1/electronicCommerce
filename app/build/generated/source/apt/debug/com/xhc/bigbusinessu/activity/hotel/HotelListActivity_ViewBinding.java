// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.hotel;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class HotelListActivity_ViewBinding implements Unbinder {
  private HotelListActivity target;

  private View view7f08013c;

  private View view7f08013d;

  private View view7f08013e;

  private View view7f08013f;

  @UiThread
  public HotelListActivity_ViewBinding(HotelListActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public HotelListActivity_ViewBinding(final HotelListActivity target, View source) {
    this.target = target;

    View view;
    target.listView = Utils.findRequiredViewAsType(source, R.id.list_view, "field 'listView'", RecyclerView.class);
    target.tvScreen1 = Utils.findRequiredViewAsType(source, R.id.tv_screen_1, "field 'tvScreen1'", TextView.class);
    target.imgScreen1 = Utils.findRequiredViewAsType(source, R.id.img_screen_1, "field 'imgScreen1'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.lin_screen_1, "field 'linScreen1' and method 'onViewClicked'");
    target.linScreen1 = Utils.castView(view, R.id.lin_screen_1, "field 'linScreen1'", LinearLayout.class);
    view7f08013c = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvScreen2 = Utils.findRequiredViewAsType(source, R.id.tv_screen_2, "field 'tvScreen2'", TextView.class);
    target.imgScreen2 = Utils.findRequiredViewAsType(source, R.id.img_screen_2, "field 'imgScreen2'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.lin_screen_2, "field 'linScreen2' and method 'onViewClicked'");
    target.linScreen2 = Utils.castView(view, R.id.lin_screen_2, "field 'linScreen2'", LinearLayout.class);
    view7f08013d = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvScreen3 = Utils.findRequiredViewAsType(source, R.id.tv_screen_3, "field 'tvScreen3'", TextView.class);
    target.imgScreen3 = Utils.findRequiredViewAsType(source, R.id.img_screen_3, "field 'imgScreen3'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.lin_screen_3, "field 'linScreen3' and method 'onViewClicked'");
    target.linScreen3 = Utils.castView(view, R.id.lin_screen_3, "field 'linScreen3'", LinearLayout.class);
    view7f08013e = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.tvScreen4 = Utils.findRequiredViewAsType(source, R.id.tv_screen_4, "field 'tvScreen4'", TextView.class);
    target.imgScreen4 = Utils.findRequiredViewAsType(source, R.id.img_screen_4, "field 'imgScreen4'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.lin_screen_4, "field 'linScreen4' and method 'onViewClicked'");
    target.linScreen4 = Utils.castView(view, R.id.lin_screen_4, "field 'linScreen4'", LinearLayout.class);
    view7f08013f = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onViewClicked(p0);
      }
    });
    target.etSearch = Utils.findRequiredViewAsType(source, R.id.et_search, "field 'etSearch'", EditText.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    HotelListActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.listView = null;
    target.tvScreen1 = null;
    target.imgScreen1 = null;
    target.linScreen1 = null;
    target.tvScreen2 = null;
    target.imgScreen2 = null;
    target.linScreen2 = null;
    target.tvScreen3 = null;
    target.imgScreen3 = null;
    target.linScreen3 = null;
    target.tvScreen4 = null;
    target.imgScreen4 = null;
    target.linScreen4 = null;
    target.etSearch = null;

    view7f08013c.setOnClickListener(null);
    view7f08013c = null;
    view7f08013d.setOnClickListener(null);
    view7f08013d = null;
    view7f08013e.setOnClickListener(null);
    view7f08013e = null;
    view7f08013f.setOnClickListener(null);
    view7f08013f = null;
  }
}
