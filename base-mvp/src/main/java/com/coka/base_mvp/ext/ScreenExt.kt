package com.coka.base_mvp.ext

import android.app.Activity
import android.os.Build
import com.coka.base_mvp.R

 fun setStatusBarColor(activity: Activity) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        activity.window.statusBarColor = activity.resources.getColor(R.color.white, activity.theme)
    } else
        activity.window.statusBarColor = activity.resources.getColor(R.color.white)
    //activity.getWindow().setNavigationBarColor(activity.getResources().getColor(R.color.white))
}
