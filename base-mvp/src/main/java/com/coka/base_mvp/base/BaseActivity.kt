package com.coka.base_mvp.base

import android.os.Bundle
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import butterknife.ButterKnife
import butterknife.Unbinder
import com.coka.base_mvp.R
import com.coka.base_mvp.ext.setStatusBarColor
import com.coka.progressdialog.ProgressDialogHolder

abstract class BaseActivity : AppCompatActivity(), BaseView {
    private var unBinder: Unbinder? = null
    protected abstract fun initView()
    protected abstract fun initData()
    @LayoutRes
    abstract fun getLayoutId(): Int
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
        unBinder?.unbind()
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