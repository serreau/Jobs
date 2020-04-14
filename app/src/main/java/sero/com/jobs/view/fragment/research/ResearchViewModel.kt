package sero.com.jobs.view.fragment.research

import android.os.Handler
import androidx.core.os.postDelayed
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import sero.com.jobs.data.repository.JobRepository
import sero.com.jobs.utils.RESEARCH_RESULTS_DELAY
import sero.com.jobs.view.adapter.AdapterItem

class ResearchViewModel : ViewModel() {

    private val jobRepository = JobRepository

    val results = MutableLiveData<MutableList<AdapterItem>>()

    private  val handler = Handler()
    private  var getResults: Runnable? = null

    fun setResearch(text: String) {
        getResults?.let { handler.removeCallbacks(it) }
        getResults = handler.postDelayed(RESEARCH_RESULTS_DELAY) {
            viewModelScope.launch {
                jobRepository.getResearchResults(text).let {
                    results.value = it.toMutableList()
                }
            }
        }
    }

}