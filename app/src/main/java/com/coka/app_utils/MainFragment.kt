package com.coka.app_utils

import android.util.Base64
import android.util.Log
import android.widget.TextView
import butterknife.BindView
import com.coka.AppUtils.R
import com.coka.base_mvp.base.BaseFragmentMVP
import java.io.UnsupportedEncodingException

class MainFragment:BaseFragmentMVP() {
    fun newInstance(): MainFragment {
        return MainFragment()
    }

    override fun getLayoutId(): Int = R.layout.main_fragment


    @BindView(R.id.tvText)
    lateinit var tvText: TextView
    override fun initView() {
        tvText.text = "Main Fragment"
    }

    override fun initData() {


    }
}