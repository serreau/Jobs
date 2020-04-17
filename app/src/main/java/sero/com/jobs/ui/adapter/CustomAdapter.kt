package sero.com.jobs.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class CustomAdapter(val adapterItemList: MutableList<AdapterItem>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    fun update(newAdapterItemList: List<AdapterItem>, forceUpdate: Boolean = true): Boolean {
        return if (newAdapterItemList.isDifferent() || forceUpdate) {
            adapterItemList.clear()
            adapterItemList.addAll(newAdapterItemList)
            notifyDataSetChanged()
            true
        } else {
            false
        }
    }

    private fun List<AdapterItem>.isDifferent(): Boolean {
        if (size == adapterItemList.size) {
            forEachIndexed { index, item -> if (item != adapterItemList[index]) return true }
            return false
        } else {
            return true
        }
    }

    override fun getItemCount(): Int = adapterItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(adapterItemList[position])

    abstract class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(adapterItem: AdapterItem)
    }
}