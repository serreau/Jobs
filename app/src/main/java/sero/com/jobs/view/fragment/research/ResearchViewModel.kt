package sero.com.jobs.view.fragment.research

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResearchViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Research Fragment"
    }

    val text: LiveData<String> = _text
}