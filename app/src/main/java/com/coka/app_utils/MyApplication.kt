package com.coka.app_utils

import android.app.Application
import com.coka.base_mvp.Utils.PreferenceUtils

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceUtils.initPreference(this,"AppUtils")
    }
}