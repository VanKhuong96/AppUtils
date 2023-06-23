package com.coka.app_utils.mvp_example

import com.coka.base_mvp.base.BaseViewMVP

interface ITestMvpContract {
    interface Presenter{
        fun getApi()
    }

    interface View : BaseViewMVP {
        fun bindGetApi(list: List<String>)
    }
}