package com.coka.app_utils

import com.coka.base_mvp.base.BaseViewMVP

interface IMainContract {
    interface Presenter{
        fun getApi()
    }

    interface View : BaseViewMVP {
        fun bindGetApi(list: List<String>)
    }
}