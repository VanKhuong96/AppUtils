package com.coka.base_mvp.base

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

abstract class BaseRecyclerAdapter<T>(context: Context?) : Adapter<RecyclerView.ViewHolder>() {
     var mInflater: LayoutInflater
    private var mItems: MutableList<T>
    private var onItemClickListener: OnItemClickListener? = null
    private val onClickListener: OnClickListener

    init {
        mItems = ArrayList()
        mInflater = LayoutInflater.from(context)
        onClickListener = object : OnClickListener() {
            override fun onClick(position: Int, itemId: Long) {
                if (onItemClickListener != null) onItemClickListener!!.onItemClick(position, itemId)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holder = onCreateDefaultViewHolder(parent, viewType)
        holder.itemView.tag = holder
        holder.itemView.setOnClickListener(onClickListener)
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        onBindViewHolder(holder, mItems[position], position)
    }

    protected abstract fun onCreateDefaultViewHolder(parent: ViewGroup?, type: Int): RecyclerView.ViewHolder

    protected abstract fun onBindViewHolder(holder: RecyclerView.ViewHolder?, item: T, position: Int)

    override fun getItemCount(): Int {
        return mItems.size
    }

    fun setOnItemClickListener(onItemClickListener: OnItemClickListener?) {
        this.onItemClickListener = onItemClickListener
    }

    fun addAll(items: List<T>?) {
        if (items != null && items.isNotEmpty()) {
            mItems.addAll(items)
            notifyItemRangeInserted(mItems.size, items.size)
        }
    }


    @SuppressLint("NotifyDataSetChanged")
    fun onFreshData(list: MutableList<T>) {
        mItems = list
        notifyDataSetChanged()
    }

    fun addItem(item: T?) {
        if (item != null) {
            mItems.add(item)
            notifyItemChanged(mItems.size)
        }
    }

    val items: List<T>
        get() = mItems

    fun getItem(position: Int): T? {
        return if (position < 0 || position >= mItems.size) null else mItems[position]
    }

    internal abstract class OnClickListener : View.OnClickListener {
        override fun onClick(v: View) {
            val holder = v.tag as RecyclerView.ViewHolder
            onClick(holder.adapterPosition, holder.itemId)
        }

        abstract fun onClick(position: Int, itemId: Long)
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int, itemId: Long)
    }

    fun removeItem(item: T) {
        if (mItems.contains(item)) {
            val position = mItems.indexOf(item)
            mItems.remove(item)
            notifyItemRemoved(position)
        }
    }

    fun updateItem(index: Int, item: T?) {
        if (item != null) {
            mItems[index] = item
            notifyItemChanged(index)
        }
    }

    protected fun removeItem(position: Int) {
        if (this.itemCount > position) {
            mItems.removeAt(position)
            notifyItemRemoved(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun clear() {
        mItems.clear()
        notifyDataSetChanged()
    }
}
