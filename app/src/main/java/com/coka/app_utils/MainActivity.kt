package com.coka.app_utils

import android.os.Bundle
import com.coka.AppUtils.R
import com.coka.app_utils.utils.SharePreferenceUtils
import com.coka.base_mvp.base.BaseActivityMVP

class MainActivity : BaseActivityMVP() {
    override fun initView() {
        replaceFragment(R.id.fragmentContainer,MainFragment().newInstance(),"","")
        //giả định login thành công save lại token
        SharePreferenceUtils.refresh_token="abc"
    }

    override fun initData() {
       //cal api
    }

    override fun getLayoutId(): Int =R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}