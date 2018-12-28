package com.cnpeng.android2.d_mine.a05_extract_rv_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer

/**
 * 作者：CnPeng
 * 时间：2018/12/28
 * 功用：
 * 其他：
 */
class CommonRvAdapter<T>(var itemLayoutId: Int, private var itemList: List<T>, val initItemView: (View, T) -> Unit) : RecyclerView.Adapter<CommonRvAdapter.BaseItemHolder<T>>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommonRvAdapter.BaseItemHolder<T> {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(itemLayoutId, parent, false)
        return BaseItemHolder(itemView, initItemView)
    }

    override fun getItemCount(): Int = itemList.size


    override fun onBindViewHolder(holder: CommonRvAdapter.BaseItemHolder<T>, position: Int) {
        holder.setDataToItem(itemList[position])
    }

    /**
     * CnPeng 2018/12/28 5:36 PM
     * 功用：
     * 说明：
     * - 因为setDataToItem的参数为条目Bean，类型不明确，所以定义为T，所以BaseItemHolder就必须是一个模板类，所以BaseRvAdapter也必须是一个模板类
     * - 不能声明为inner，否则 BaseRvAdapter中引用该Holder的地方会报错，提示：One type argument excepted for class BaseItemHolder<T>
     */
    class BaseItemHolder<T>(override val containerView: View, val initItem: (View, T) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

        fun setDataToItem(itemBean: T) {
            initItem(containerView, itemBean)
        }
    }
}