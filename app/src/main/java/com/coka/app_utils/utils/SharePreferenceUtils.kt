package com.coka.app_utils.utils

import android.annotation.SuppressLint
import com.coka.base_mvp.Utils.PreferenceUtils

object SharePreferenceUtils {
    @SuppressLint("StaticFieldLeak")
    var pref = PreferenceUtils.instance
    private const val REFRESH_TOKEN = "REFRESH_TOKEN"
    var refresh_token: String = ""
        get() {
            return pref[REFRESH_TOKEN, String::class.java] ?: ""
        }
        set(value){
            pref.put(REFRESH_TOKEN,value)
            field=value
        }
}