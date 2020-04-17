package sero.com.jobs.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_category.view.*
import sero.com.jobs.R
import sero.com.jobs.data.model.Category
import sero.com.jobs.utils.extension.getResDimen
import sero.com.jobs.utils.extension.setMargin
import sero.com.jobs.utils.extension.setOnSafeClickListener


class CategoryAdapter(categories: List<Category>, private val onClick: (String) -> Unit) : CustomAdapter(categories.toMutableList()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ThemeViewHolder {
        return ThemeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false))
    }

    override fun getItemCount() = adapterItemList.size

    inner class ThemeViewHolder(itemView: View) : ViewHolder(itemView) {

        override fun bind(adapterItem: AdapterItem) {
            bind(adapterItem as Category)
        }

        private fun bind(category: Category) = with(itemView) {
            val name = context.getString(category.label)
            label?.text = name
            icon?.setImageResource(category.icon)
            item?.run {
                val smallMargin = context.getResDimen(R.dimen.small_margin)
                val largeMargin = context.getResDimen(R.dimen.large_margin)
                val startMargin = if (adapterPosition == 0) largeMargin else smallMargin
                val endMargin = if (adapterPosition == adapterItemList.size - 1) largeMargin else smallMargin
                setMargin(startMargin, largeMargin, endMargin, largeMargin)
                setOnSafeClickListener { onClick(name) }
            }
        }
    }
}