package com.coka.base_mvp.Utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.os.Build

object Utils {
    fun hasInternetConnection(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
        if (Build.VERSION.SDK_INT <= 29) {
            if (connectivityManager != null) {
                val networkInfo = connectivityManager.activeNetworkInfo
                if (networkInfo != null && networkInfo.isConnected) {
                    // device has internet connection
                    return true
                }
            }
        } else {
            val network: Network? = connectivityManager?.getActiveNetwork()
            if (network != null) {
                val networkCapabilities: NetworkCapabilities? =
                    connectivityManager.getNetworkCapabilities(network)
                if (networkCapabilities != null && networkCapabilities.hasCapability(
                        NetworkCapabilities.NET_CAPABILITY_INTERNET)) {
                    return true
                }
            }
        }
        // device does not have internet connection
        return false
    }

}