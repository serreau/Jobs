package sero.com.jobs.view.fragment.research

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fragment_research.*
import sero.com.jobs.R
import sero.com.jobs.utils.extension.getViewModel
import sero.com.jobs.utils.extension.goToResult
import sero.com.jobs.utils.extension.setOnSafeClickListener
import sero.com.jobs.view.fragment.BaseFragment

class ResearchFragment : BaseFragment(R.layout.fragment_research) {

    private lateinit var researchViewModel: ResearchViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupInterface()
    }

    private fun setupViewModel() {
        researchViewModel = getViewModel<ResearchViewModel>().apply {
            observe(text) {
                text_research.text = it
            }
        }
    }

    private fun setupInterface() {
        back_button?.setOnSafeClickListener { activity?.onBackPressed() }
        go_to_result_button?.setOnSafeClickListener { goToResult() }
    }
}