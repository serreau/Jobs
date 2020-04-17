package sero.com.jobs.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_job_summary.view.*
import sero.com.jobs.R
import sero.com.jobs.data.model.Category
import sero.com.jobs.data.model.JobSummary
import sero.com.jobs.utils.extension.setOnSafeClickListener

class JobSummaryAdapter(jobs: List<JobSummary>, private val onClick: (String) -> Unit) : CustomAdapter(jobs.toMutableList()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JobViewHolder {
        return JobViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_job_summary, parent, false))
    }

    override fun getItemCount() = adapterItemList.size

    inner class JobViewHolder(itemView: View) : ViewHolder(itemView) {

        override fun bind(adapterItem: AdapterItem) {
            bind(adapterItem as JobSummary)
        }

        private fun bind(job: JobSummary) = with(itemView) {
            val category = Category.fromId(job.categoryId)
            category_icon?.setImageResource(category.icon)
            category_label?.text = context.getString(category.label)
            price?.text = job.price
            title?.text = job.title
            location?.text = job.location
            item?.setOnSafeClickListener { onClick(job.title) }
        }
    }
}