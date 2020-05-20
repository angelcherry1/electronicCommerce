package com.tuhualong.policylibrary;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.TextView;
import com.tuhualong.policylibrary.R;
import androidx.core.app.ActivityCompat;


public class Policy {

    private static volatile Policy instance = null;
    private String title = "应用需要下列权限才可以正常使用";

    private Policy() {
    }

    public static Policy getInstance() {
        if (instance == null) {
            synchronized (Policy.class) {
                if (instance == null) {
                    instance = new Policy();
                }
            }
        }
        return instance;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }



    public void showRuleDialog(final Context context, String title, String text, int tagColor, final RuleListener ruleListener) {
        if (hasShowRule(context)) {
            if (ruleListener != null) {
                ruleListener.rule(true);
            }
            return;
        }

        final Dialog dialog = new Dialog(context, com.tuhualong.policylibrary.R.style.POLICY_DIALOG);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.layout_rule);
        dialog.show();
        TextView tv_ok = dialog.findViewById(R.id.tv_ok);
        TextView tv_cancel = dialog.findViewById(R.id.tv_cancel);
        TextView tv_title = dialog.findViewById(R.id.tv_title);
        TextView tv_text = dialog.findViewById(R.id.tv_text);
        tv_title.setText(title);
        String tag1 = "《";
        String tag2 = "》";
        int firstIndex = text.indexOf(tag1);
        int secondIndex = text.indexOf(tag2) + 1;
        int thirdIndex = text.indexOf(tag1, firstIndex + 1);

        SpannableStringBuilder style = new SpannableStringBuilder();
        style.append(text);
        ClickableSpan clickableSpanOne = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                if (ruleListener != null) {
                    ruleListener.oneClick();
                }
            }
        };

        style.setSpan(clickableSpanOne, firstIndex, secondIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_text.setText(style);

        ForegroundColorSpan foregroundColorSpanOne = new ForegroundColorSpan(context.getResources().getColor(tagColor));
        style.setSpan(foregroundColorSpanOne, firstIndex, secondIndex, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_text.setMovementMethod(LinkMovementMethod.getInstance());
        tv_text.setText(style);

        if (thirdIndex != -1) {
            ClickableSpan clickableSpanTwo = new ClickableSpan() {
                @Override
                public void onClick(View widget) {
                    if (ruleListener != null) {
                        ruleListener.twoClick();
                    }
                }
            };
            style.setSpan(clickableSpanTwo, thirdIndex, text.lastIndexOf(tag2) + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_text.setText(style);

            ForegroundColorSpan foregroundColorSpanTwo = new ForegroundColorSpan(context.getResources().getColor(tagColor));
            style.setSpan(foregroundColorSpanTwo, thirdIndex, text.lastIndexOf(tag2) + 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_text.setMovementMethod(LinkMovementMethod.getInstance());
            tv_text.setText(style);
        }

        tv_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (ruleListener != null) {
                    ruleListener.rule(true);
                    putShowRule(context);
                }
            }
        });
        tv_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                if (ruleListener != null) {
                    ruleListener.rule(false);
                }
            }
        });
    }

    public interface RuleListener {
        void rule(boolean agree);

        void oneClick();

        void twoClick();
    }

    public boolean hasRefusedPermission(Context mContexts, String permission) {
        return ActivityCompat.shouldShowRequestPermissionRationale((Activity) mContexts, permission);
    }

//    public boolean getRefusedList(Context context, ArrayList<String> list) {
//        for (int i = 0; i < list.size(); i++) {
//            String permissionItem = list.get(i);
//            if (!hasPermission(context, permissionItem) &&
//                    hasRefusedPermission(context, permissionItem)) {
//                return true;
//            }
//        }
//        return false;
//    }

    public boolean hasShowRule(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rule", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("rule", false);
    }

    public void putShowRule(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rule", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("rule", true).commit();
    }

    public void clearShowRule(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rule", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("rule", false).commit();
    }

    public void putString(Context context, String permission) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rule", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean(permission, true).commit();
    }

    public boolean getString(Context context, String permission) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("rule", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(permission, false);
    }

    public boolean getStringList(Context context,String... perms) {
        for (int i = 0; i < perms.length; i++) {
            if (!getString(context, perms[i])) {
                return false;
            }
        }
        return true;
    }
}
