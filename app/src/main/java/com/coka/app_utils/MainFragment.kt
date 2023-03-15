package com.coka.app_utils

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.coka.AppUtils.R
import com.coka.base_mvp.base.BaseFragmentMVP
import com.coka.base_mvp.base.BaseRecyclerAdapter.OnItemClickListener

class MainFragment:BaseFragmentMVP() {
    fun newInstance(): MainFragment {
        return MainFragment()
    }

    override fun getLayoutId(): Int = R.layout.main_fragment


    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView
    override fun initView() {
        var testMAdapter=TestMAdapter(requireContext())
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.adapter=testMAdapter
        for (i in 1..20) {
            testMAdapter.addItem("Item " + i)
        }
        testMAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int, itemId: Long) {
                Log.e("khuongnv","position:"+position)
                Log.e("khuongnv","itemId:"+itemId)
            }

        })

    }

    override fun initData() {


    }
}