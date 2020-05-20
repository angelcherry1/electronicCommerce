// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.me.setting;

import android.view.View;
import android.widget.EditText;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.android.library.YLCircleImageView;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PersonalInfoActivity_ViewBinding implements Unbinder {
  private PersonalInfoActivity target;

  private View view7f0801bf;

  @UiThread
  public PersonalInfoActivity_ViewBinding(PersonalInfoActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public PersonalInfoActivity_ViewBinding(final PersonalInfoActivity target, View source) {
    this.target = target;

    View view;
    target.imgAvatar = Utils.findRequiredViewAsType(source, R.id.img_avatar, "field 'imgAvatar'", YLCircleImageView.class);
    target.etNickName = Utils.findRequiredViewAsType(source, R.id.et_nick_name, "field 'etNickName'", EditText.class);
    view = Utils.findRequiredView(source, R.id.rel_choose_avatar, "method 'onViewClicked'");
    view7f0801bf = view;
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
    PersonalInfoActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.imgAvatar = null;
    target.etNickName = null;

    view7f0801bf.setOnClickListener(null);
    view7f0801bf = null;
  }
}
