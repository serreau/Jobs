package sero.com.jobs.ui.fragment

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import sero.com.jobs.data.helper.UIState

abstract class BaseViewModel<T> : ViewModel() {
    protected val uiState = MutableLiveData<UIState>()
    protected val model = MutableLiveData<T>()

    abstract fun initObserver(owner: LifecycleOwner, statusObserver: Observer<UIState>, dataObserver: Observer<T>): BaseViewModel<T>
    abstract fun loadData()
}