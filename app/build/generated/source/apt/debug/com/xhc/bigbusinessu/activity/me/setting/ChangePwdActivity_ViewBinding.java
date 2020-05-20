// Generated code from Butter Knife. Do not modify!
package com.xhc.bigbusinessu.activity.me.setting;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.UiThread;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.xhc.bigbusinessu.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ChangePwdActivity_ViewBinding implements Unbinder {
  private ChangePwdActivity target;

  @UiThread
  public ChangePwdActivity_ViewBinding(ChangePwdActivity target) {
    this(target, target.getWindow().getDecorView());
  }

  @UiThread
  public ChangePwdActivity_ViewBinding(ChangePwdActivity target, View source) {
    this.target = target;

    target.etOldPwd = Utils.findRequiredViewAsType(source, R.id.et_old_pwd, "field 'etOldPwd'", EditText.class);
    target.etPwd = Utils.findRequiredViewAsType(source, R.id.et_pwd, "field 'etPwd'", EditText.class);
    target.etPwd2 = Utils.findRequiredViewAsType(source, R.id.et_pwd2, "field 'etPwd2'", EditText.class);
    target.tvDoChange = Utils.findRequiredViewAsType(source, R.id.tv_do_change, "field 'tvDoChange'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    ChangePwdActivity target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");
    this.target = null;

    target.etOldPwd = null;
    target.etPwd = null;
    target.etPwd2 = null;
    target.tvDoChange = null;
  }
}
