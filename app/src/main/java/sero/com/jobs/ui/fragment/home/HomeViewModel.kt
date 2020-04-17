package sero.com.jobs.ui.fragment.home

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import sero.com.jobs.data.helper.UIState
import sero.com.jobs.data.model.HomeContent
import sero.com.jobs.data.repository.MockyRepository
import sero.com.jobs.ui.fragment.BaseViewModel
import sero.com.jobs.utils.LOADING_DATA_DELAY

class HomeViewModel : BaseViewModel<HomeContent>() {

    override fun initObserver(owner: LifecycleOwner, statusObserver: Observer<UIState>, dataObserver: Observer<HomeContent>): HomeViewModel {
        uiState.observe(owner, statusObserver)
        model.observe(owner, dataObserver)
        loadData()
        return this
    }

    override fun loadData() {
        viewModelScope.launch {
            uiState.value = UIState.Loading
            MockyRepository.getMockyHomeContent().either({
                delay(LOADING_DATA_DELAY)
                uiState.value = it
            }, {
                model.value = it
                delay(LOADING_DATA_DELAY)
                uiState.value = UIState.Success
            })
        }
    }
}