package com.coka.app_utils.mvp_example

import android.content.Context
import android.util.Log
import com.coka.base_mvp.base.BasePresenter

class MainPresenter(private val view: ITestMvpContract.View, var context: Context):
    ITestMvpContract.Presenter,BasePresenter(context,"") {
    private val mutableList : MutableList<String> = ArrayList()
    override fun getApi() {
        Log.e("khuongnv","run getData")
       if (checkToken().first){
           for (i in 1..20) {
               mutableList.add("Item "+i)
           }
           view.bindGetApi(mutableList)
       }else{
           Log.e("khuongnv","TokenErr:"+checkToken().second)
       }
    }

}