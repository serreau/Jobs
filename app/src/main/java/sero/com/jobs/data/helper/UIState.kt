package sero.com.jobs.data.helper

import sero.com.jobs.R

sealed class UIState(val icon: Int = R.drawable.ic_smiley_sad, val msg: Int = R.string.default_error_msg) {
    object Loading : UIState()
    object Success : UIState()
    object NoData : UIState(msg = R.string.no_data_msg)
    object NetworkError : UIState(icon = R.drawable.ic_smiley_very_sad, msg = R.string.network_error_msg)
}