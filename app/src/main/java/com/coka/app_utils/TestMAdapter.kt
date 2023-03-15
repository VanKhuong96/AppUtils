package com.coka.app_utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.coka.AppUtils.R


import com.coka.base_mvp.base.BaseRecyclerAdapter

class TestMAdapter(var context: Context) : BaseRecyclerAdapter<String>(context) {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {


    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: String, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateDefaultViewHolder(parent: ViewGroup?, type: Int): RecyclerView.ViewHolder {
        return ViewHolder(mInflater.inflate(R.layout.item_main_adapter,parent,false))
    }
}