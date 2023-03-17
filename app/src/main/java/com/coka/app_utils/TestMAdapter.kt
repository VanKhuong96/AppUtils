package com.coka.app_utils

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coka.AppUtils.R


import com.coka.base_mvp.base.BaseRecyclerAdapter

class TestMAdapter(var context: Context) : BaseRecyclerAdapter<String>(context) {
    class TestViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val tvMessage: TextView = itemView.findViewById(R.id.tvMessage)
        fun bind(item:String){
            tvMessage.text=item
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: String, position: Int) {
        var viewHolder: TestViewHolder = holder as TestViewHolder
        viewHolder.bind(item)
    }

    override fun onCreateDefaultViewHolder(parent: ViewGroup?, type: Int): RecyclerView.ViewHolder {
        return TestViewHolder(mInflater.inflate(R.layout.item_main_adapter, parent, false))
    }
}