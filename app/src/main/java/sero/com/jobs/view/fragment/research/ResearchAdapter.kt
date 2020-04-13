package sero.com.jobs.view.fragment.research

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.item_research_result.view.*
import sero.com.jobs.R
import sero.com.jobs.data.entity.Job
import sero.com.jobs.view.adapter.AdapterItem
import sero.com.jobs.view.adapter.CustomAdapter

class ResearchAdapter(list: MutableList<AdapterItem>): CustomAdapter(list) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val item = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_research_result, parent, false) as ConstraintLayout
        return ResearchViewHolder(item)
    }

    inner class ResearchViewHolder(view: View) : ViewHolder(view){
        override fun bind(adapterItem: AdapterItem) {
            val job = adapterItem as Job
            with(itemView){
                val separator = context.getString(R.string.research_view__separator)
                result.text = job.title + separator + job.category
            }
        }
    }
}