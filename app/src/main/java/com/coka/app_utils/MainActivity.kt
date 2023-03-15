package com.coka.app_utils

import android.os.Bundle
import com.coka.AppUtils.R
import com.coka.base_mvp.base.BaseActivityMVP

class MainActivity : BaseActivityMVP() {
    override fun initView() {
        addFragment(R.id.fragmentContainer,MainFragment().newInstance(),"")
    }

    override fun initData() {
       //cal api
    }

    override fun getLayoutId(): Int =R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}