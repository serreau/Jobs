package sero.com.jobs.ui.fragment.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.shimmer_fragment_home.*
import sero.com.jobs.R
import sero.com.jobs.data.model.Category
import sero.com.jobs.ui.adapter.JobSummaryAdapter
import sero.com.jobs.ui.fragment.BaseFragment
import sero.com.jobs.utils.extension.*

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInterface()
        setupViewModel()
    }

    private fun setupInterface() {
        shimmerViews.addAll(listOf(theme_list_shimmer, job_title_shimmer, job_list_shimmer))
        contentView.add(content)
        theme_list?.init(true, RecyclerView.HORIZONTAL)
        job_list?.init(false, RecyclerView.VERTICAL)
        search_container?.setOnSafeClickListener { goToResearch() }
    }

    private fun setupViewModel() {
        homeViewModel = getViewModel<HomeViewModel>().initObserver(this@HomeFragment, Observer {
            handleUIState(it)
        }, Observer {
            val categories = it.categories.map { categoryId -> Category.fromId(categoryId) }
            theme_list?.createOrUpdate(sero.com.jobs.ui.adapter.CategoryAdapter(categories, ::onThemeClicked), categories)
            job_list?.createOrUpdate(JobSummaryAdapter(it.jobs, ::onJobClicked), it.jobs)
        })
    }

    private fun onThemeClicked(name: String) {
        context?.showToast("Theme = $name")
    }

    private fun onJobClicked(title: String) {
        context?.showToast("Job = $title")
    }
}