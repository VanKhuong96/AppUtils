package com.coka.base_mvp.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.Nullable
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.Unbinder
import com.coka.base_mvp.R
import com.coka.base_mvp.ext.setStatusBarColor
import com.coka.progressdialog.ProgressDialogHolder


abstract class BaseActivityMVP : AppCompatActivity(), BaseViewMVP {
    private var unBinder: Unbinder? = null
    protected abstract fun initView()
    protected abstract fun initData()
    @LayoutRes
    abstract fun getLayoutId(): Int
    protected open fun addFragment(@IdRes containerViewId: Int, fragment: Fragment, fragmentTag: String) {
        supportFragmentManager
            .beginTransaction()
            .add(containerViewId, fragment, fragmentTag)
            .disallowAddToBackStack()
            .commit()
    }
    protected open fun replaceFragment(@IdRes containerViewId: Int, fragment: Fragment, fragmentTag: String, backStackStateName: String?) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment, fragmentTag)
            .addToBackStack(backStackStateName)
            .commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStatusBarColor(this)
        setContentView(getLayoutId())
        unBinder = ButterKnife.bind(this)
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
        if (unBinder != null) {
            unBinder!!.unbind()
        }
    }

    override fun showLoading() {
        ProgressDialogHolder.getInstance(this).showDialog("")
    }

    override fun hideLoading() {
        ProgressDialogHolder.getInstance(this).dismissDialog()
    }

    override fun showRetry() {
    }

    override fun hideRetry() {
    }

    override fun showNetWorkError() {
        Toast.makeText(this, resources.getString(R.string.network_error), Toast.LENGTH_SHORT).show()
    }

    override fun showErrorServer() {
        Toast.makeText(this, resources.getString(R.string.server_error), Toast.LENGTH_SHORT).show()
    }

    override fun showErrorServer(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }


}