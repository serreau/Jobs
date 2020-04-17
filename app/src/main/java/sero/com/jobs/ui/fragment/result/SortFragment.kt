package sero.com.jobs.ui.fragment.result

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_sort.*
import sero.com.jobs.R
import sero.com.jobs.utils.extension.getViewModel
import sero.com.jobs.utils.extension.setOnSafeClickListener
import sero.com.jobs.ui.fragment.BaseFragment

class SortFragment : BaseFragment(R.layout.fragment_sort) {

    private lateinit var resultViewModel: ResultViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupInterface()
    }

    private fun setupViewModel() {
        resultViewModel = getViewModel<ResultViewModel>().apply {
            observe(text) {
                //text_sort.text = it
            }
        }
    }

    private fun setupInterface() {
        back_button?.setOnSafeClickListener { activity?.onBackPressed() }
    }
}