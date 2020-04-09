package sero.com.jobs.view.fragment.home

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_home.*
import sero.com.jobs.R
import sero.com.jobs.utils.extension.getViewModel
import sero.com.jobs.utils.extension.goToResearch
import sero.com.jobs.utils.extension.setOnSafeClickListener
import sero.com.jobs.view.fragment.BaseFragment

class HomeFragment : BaseFragment(R.layout.fragment_home) {

    private lateinit var homeViewModel: HomeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupInterface()
    }

    private fun setupViewModel() {
        homeViewModel = getViewModel<HomeViewModel>().apply {
            observe(text) {
                text_home.text = it
            }
        }
    }

    private fun setupInterface() {
        go_to_research_button.setOnSafeClickListener { goToResearch() }
    }
}