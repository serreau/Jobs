package sero.com.jobs.view.fragment.research

import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_research.*
import sero.com.jobs.R
import sero.com.jobs.utils.extension.goToResult
import sero.com.jobs.utils.extension.setOnSafeClickListener
import sero.com.jobs.view.fragment.BaseFragment

class ResearchFragment : BaseFragment(R.layout.fragment_research) {

    private val viewModel : ResearchViewModel by viewModels()
    private val resultAdapter = ResearchAdapter(arrayListOf())

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewModel()
        setupInterface()
    }

    private fun setupViewModel() {
        viewModel.results.observe(activity!!, Observer {
            resultAdapter.update(it)
        })
    }

    private fun setupInterface() {
        back_button?.setOnSafeClickListener { activity?.onBackPressed() }
        go_to_result_button?.setOnSafeClickListener { goToResult() }
        showKeyboard(research_input)
        results_recyclerview.apply {
            adapter = resultAdapter
            layoutManager = LinearLayoutManager(context)
        }
        research_input.doAfterTextChanged {
            viewModel.setResearch(it.toString())
        }
    }
}