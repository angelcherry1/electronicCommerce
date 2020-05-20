package com.xhc.bigbusinessu.base

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.view.Window
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.FragmentActivity

import com.xhc.bigbusinessu.MyApplication
import com.xhc.bigbusinessu.R
import com.xhc.bigbusinessu.appmanager.AppManager

import butterknife.ButterKnife

abstract class BaseActivityK : FragmentActivity() {
    //    protected SpotsDialog dialog;

    val TAG = this.javaClass.getSimpleName()

    /**
     * 返回该类的对象
     */
    protected val activity: FragmentActivity
        get() = this

    protected var progressDialog: ProgressDialog? = null

    override fun onCreate(arg0: Bundle?) {
        super.onCreate(arg0)
        // 将activity对象添加到程序堆栈
        AppManager.getAppManager().addActivity(this)
        //        dialog = new SpotsDialog(this);
        setContentView()
        ButterKnife.bind(this)

        initUI()
        initData()
        initEvent()
        startFunction()
    }

    /**
     * 打开允许通知的设置页
     *
     * @param isEnabled
     */
    private fun goToNotificationSetting(isEnabled: Boolean) {
        if (isEnabled) {
            return
        } else {
            val intent = Intent()
            if (Build.VERSION.SDK_INT >= 26) {
                // android 8.0引导
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("android.provider.extra.APP_PACKAGE", this.packageName)
            } else if (Build.VERSION.SDK_INT >= 21) {
                // android 5.0-7.0
                intent.action = "android.settings.APP_NOTIFICATION_SETTINGS"
                intent.putExtra("app_package", this.packageName)
                intent.putExtra("app_uid", this.applicationInfo.uid)
            } else {
                // 其他
                intent.action = "android.settings.APPLICATION_DETAILS_SETTINGS"
                intent.data = Uri.fromParts("package", this.packageName, null)
            }
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            this.startActivity(intent)
        }

    }

    override fun onPause() {
        hideKeyboard()
        super.onPause()

    }

    /**
     * hide
     */
    protected fun hideKeyboard() {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm?.hideSoftInputFromWindow(window.decorView.windowToken,
                0)
    }

    override fun onDestroy() {
        super.onDestroy()
        // 将activity对象移出堆栈

        AppManager.getAppManager().finishActivity(this)
    }

    // 设置头像的内容界面
    protected abstract fun setContentView()

    // 实例化UI控件
    protected abstract fun initUI()

    // 初始化UI数据
    protected abstract fun initData()

    // 初始化事件
    protected abstract fun initEvent()

    // 开始执行功能
    protected abstract fun startFunction()

    /**
     * 弹出消息提示框
     *
     * @param Title
     * @param Message
     * @param onClickListener
     */
    protected fun showAlertDialogMessage(Title: String, Message: String, onClickListener: DialogInterface.OnClickListener) {
        val builder = AlertDialog.Builder(this)
        builder.setTitle(Title)
        builder.setMessage(Message)
        builder.setPositiveButton("好", onClickListener)
        builder.setNegativeButton("取消") { dialog, which -> dialog.dismiss() }
        builder.show()
    }

    /**
     * 返回上一个界面
     */
    protected fun goBack() {
        this.finish()
    }

    /**
     * 获取组建的实例
     */
    protected fun <T : View> getID(id: Int): T {
        return findViewById<View>(id) as T
    }

    //    @Override
    //    public boolean onKeyDown(int keyCode, KeyEvent event) {
    //        if (keyCode == KeyEvent.KEYCODE_BACK) {
    //            if(!BackPressed)
    //            goBack();
    //            return true;
    //        } else if (keyCode == KeyEvent.KEYCODE_MENU) {
    //            return true;
    //        } else {
    //            return super.onKeyDown(keyCode, event);
    //        }
    //    }


    protected fun ToastMessage(message: String) {
        if (null == MyApplication.getInstance()) {
            return
        } else {
            Toast.makeText(MyApplication.getInstance(), message, Toast.LENGTH_SHORT).show()
        }

    }

    protected fun ToastMessageLong(Message: String) {
        Toast.makeText(MyApplication.getInstance(), Message, Toast.LENGTH_SHORT).show()
    }

    /**
     * 设置程序标题
     */
    protected fun setTitleText(title: String) {
        val mTvTitle = getID<TextView>(R.id.app_title)
        mTvTitle.text = title
    }


    /**
     * 设置title的中间View
     *
     * @param v
     * @return
     */

    protected fun setTitleCenter(v: View): View {
        val mCenterLin = getID<LinearLayout>(R.id.lin_title_center)
        mCenterLin.removeAllViews()
        mCenterLin.addView(v)
        return mCenterLin
    }

    /**
     * 返回上级界面
     */
    protected fun showTitleBack() {
        val mLinBack = getID<LinearLayout>(R.id.lin_title_left)
        val mImgBack = getID<ImageView>(R.id.img_title_left)
        mImgBack.visibility = View.VISIBLE
        mLinBack.setOnClickListener { goBack() }
    }

    /**
     * 返回上级界面
     */
    protected fun showTitleBack(onClickListener: OnClickListener) {
        val mLinBack = getID<LinearLayout>(R.id.lin_title_left)
        val mImgBack = getID<ImageView>(R.id.img_title_left)
        mImgBack.setImageResource(R.mipmap.icon_title_back)
        mLinBack.setOnClickListener(onClickListener)
    }


    /**
     * 标题右边图片
     */
    protected fun setTitleRightImg(id: Int, listener: OnClickListener) {
        val mLinRight = getID<LinearLayout>(R.id.lin_title_right)
        val mImgRight = getID<ImageView>(R.id.img_title_right)
        mImgRight.setImageResource(id)
        mLinRight.setOnClickListener(listener)

    }

    /**
     * 设置Title右边的文字 图片 点击事件
     *
     * @param str
     * @param image_id
     * @param listener
     */
    protected fun setTitleRightText(str: String, image_id: Int,
                                    listener: OnClickListener) {
        val mLinRight = getID<LinearLayout>(R.id.lin_title_right)
        val mTvRight = getID<TextView>(R.id.app_title_right)
        val mIvRight = getID<ImageView>(R.id.img_title_right)
        mIvRight.visibility = View.VISIBLE
        mTvRight.visibility = View.VISIBLE
        mTvRight.text = str
        mIvRight.setBackgroundResource(image_id)
        mLinRight.setOnClickListener(listener)

    }

    /**
     * 设置标题右边文字
     */
    protected fun setTitleRightText(str: String, listener: OnClickListener) {
        val mTvRight = getID<TextView>(R.id.app_title_right)
        mTvRight.visibility = View.VISIBLE
        mTvRight.text = str
        mTvRight.setOnClickListener(listener)

    }

    /**
     * 隐藏标题右边文字
     */
    protected fun setTitleRightTextIsVisible(isVisible: Boolean) {
        val mTvRight = getID<TextView>(R.id.app_title_right)
        if (isVisible) {
            mTvRight.visibility = View.VISIBLE
        } else {
            mTvRight.visibility = View.GONE
        }

    }

    /**
     * 设置标题右边文字
     *
     * @param str
     */
    fun setTitleRightTextName(str: String) {
        val mTvRight = getID<TextView>(R.id.app_title_right)
        mTvRight.visibility = View.VISIBLE
        mTvRight.text = str

    }

    /**
     * 设置标题右边文字颜色
     *
     * @param txtColor
     */
    fun setTitleRightTextColor(txtColor: Int) {
        val mTvRight = getID<TextView>(R.id.app_title_right)
        mTvRight.visibility = View.VISIBLE
        mTvRight.setTextColor(txtColor)

    }

    fun showActivity(classz: Class<*>, finish: Boolean) {
        startActivity(Intent(this, classz))
        if (finish) {
            this@BaseActivityK.finish()
        }
    }

    protected fun showProgressDialog(str: String) {
        if (progressDialog == null) {
            progressDialog = ProgressDialog(this)
            progressDialog!!.setCanceledOnTouchOutside(false)
            progressDialog!!.setOnCancelListener {
            }
            progressDialog!!.setMessage(str)
            progressDialog!!.show()
        }
    }

    protected  fun disProgressDialog() {
            if (progressDialog != null) {
                progressDialog!!.dismiss()
            }
        }

//    private fun getProgressDialog(): ProgressDialog? {

//        }
//        return progressDialog
//    }

        /**
         * 通过Class跳转界面
         */
        protected fun mystartActivity(cls: Class<*>) {
            val intent = Intent()
            intent.setClass(this, cls)
            startActivity(intent)
        }


        /**
         * 含有Bundle通过Class跳转界面
         */
        protected fun mystartActivity(cls: Class<*>, bundle: Bundle?) {
            val intent = Intent()
            intent.setClass(this, cls)
            if (bundle != null) {
                intent.putExtras(bundle)
            }
            startActivity(intent)
        }

        /**
         * 通过Action跳转界面
         */
        protected fun mystartActivity(action: String, uri: Uri) {
            val intent = Intent(action, uri)
            startActivity(intent)
        }

        companion object {

            /**
             * 全透状态栏和字体颜色
             */
            fun setStatusBarFullTransparent(activity: Activity) {
                if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
                    val window = activity.window
                    window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                    window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
                    window.statusBarColor = Color.TRANSPARENT
                } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
                    activity.window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                    //虚拟键盘也透明
                    //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
                }

                val decor = activity.window.decorView
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    decor.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR//字体颜色
                }
            }
        }
    }
