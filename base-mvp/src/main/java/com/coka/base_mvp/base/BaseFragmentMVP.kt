package com.coka.base_mvp.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import butterknife.ButterKnife
import butterknife.Unbinder

abstract class BaseFragmentMVP : Fragment() {
     var mRootView: View? = null
     var mInflater: LayoutInflater? = null
     var mContext: Context? = null
     var unBinder: Unbinder? = null


    override fun onAttach(context: Context) {
        mContext = context
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (mRootView != null) (mRootView!!.parent as ViewGroup).removeView(mRootView)
        else {
            mRootView = inflater.inflate(getLayoutId(), container, false)
            mInflater = inflater
            unBinder= ButterKnife.bind(this, mRootView!!)
            initView()
            initData()
        }
        return mRootView
    }

    protected abstract fun getLayoutId(): Int
    protected abstract fun initView()
    protected abstract fun initData()

    override fun onDestroyView() {
        super.onDestroyView()
        if (unBinder != null) {
            unBinder!!.unbind()
        }
    }

}