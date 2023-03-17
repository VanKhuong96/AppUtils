package com.coka.base_mvp.base

import android.content.Context
import com.coka.base_mvp.Utils.Utils
import com.coka.base_mvp.network.ApiClient
import com.coka.base_mvp.network.ApiService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.SocketTimeoutException
import java.net.UnknownHostException

abstract class BasePresenter(var mContext: Context, token: String) {
    var apiInterface: ApiService = ApiClient.getClient(token).create(ApiService::class.java)

    // trạng thái check token - mã lỗi
    fun checkToken(): Pair<Boolean, String> {
        if (!Utils.hasInternetConnection(mContext)) {
            return Pair(false, "lỗi kết nối internet")
        }
        return Pair(true, "thành công")
    }
}