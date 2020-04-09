package sero.com.jobs.view.fragment.result

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_filter.*
import sero.com.jobs.R
import sero.com.jobs.utils.extension.getViewModel
import sero.com.jobs.utils.extension.setOnSafeClickListener
import sero.com.jobs.view.fragment.BaseFragment

class FilterFragment : BaseFragment(R.layout.fragment_filter) {

    private lateinit var resultViewModel: ResultViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupInterface()
    }

    private fun setupViewModel() {
        resultViewModel = getViewModel<ResultViewModel>().apply {
            observe(text) {
                //text_filter.text = it
            }
        }
    }

    private fun setupInterface() {
        back_button?.setOnSafeClickListener { activity?.onBackPressed() }
    }
}