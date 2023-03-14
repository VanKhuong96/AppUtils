package com.coka.base_mvp.base

interface BaseView {
    fun showLoading()

    fun hideLoading()

    fun showRetry()

    fun hideRetry()

    fun showNetWorkError()

    fun showErrorServer()

    fun showErrorServer(message: String?)
}