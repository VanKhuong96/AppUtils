package com.coka.app_utils.mvp_example

import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import butterknife.BindView
import com.coka.AppUtils.R
import com.coka.base_mvp.base.BaseFragmentMVP
import com.coka.base_mvp.base.BaseRecyclerAdapter.OnItemClickListener
import com.coka.progressdialog.ProgressDialogHolder

class TestMvpFragment:BaseFragmentMVP(), ITestMvpContract.View {
    fun newInstance(): TestMvpFragment {
        return TestMvpFragment()
    }

    override fun getLayoutId(): Int = R.layout.test_mvp_fragment

    private lateinit var testMAdapter: TestMAdapter
    @BindView(R.id.recyclerView)
    lateinit var recyclerView: RecyclerView
    override fun initView() {
        testMAdapter= TestMAdapter(requireContext())
        recyclerView.layoutManager=LinearLayoutManager(requireContext())
        recyclerView.adapter=testMAdapter
        testMAdapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(position: Int, itemId: Long) {
                Log.e("khuongnv","position:"+position)
                Log.e("khuongnv","itemId:"+itemId)
            }

        })

    }
    private lateinit var  presenter: MainPresenter
    override fun initData() {
        presenter= MainPresenter(this,requireContext())
        presenter.checkToken()
        presenter.getApi()
    }

    override fun showLoading() {
        ProgressDialogHolder.getInstance(requireActivity()).showDialog("")
    }

    override fun hideLoading() {
        ProgressDialogHolder.getInstance(requireActivity()).dismissDialog()
    }

    override fun showRetry() {
    }

    override fun hideRetry() {
    }

    override fun showNetWorkError() {
    }

    override fun showErrorServer() {
    }

    override fun showErrorServer(message: String?) {
    }

    override fun bindGetApi(list: List<String>) {
        Log.e("khuongnv","bindGetData:"+list.size)
        testMAdapter.addAll(list)
    }
}