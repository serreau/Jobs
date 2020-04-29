package sero.com.jobs.ui.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.facebook.shimmer.ShimmerFrameLayout
import kotlinx.android.synthetic.main.layout_error.*
import sero.com.jobs.data.helper.UIState
import sero.com.jobs.utils.extension.beginShimmerAnim
import sero.com.jobs.utils.extension.endShimmerAnim
import sero.com.jobs.utils.extension.hide
import sero.com.jobs.utils.extension.show
import sero.com.jobs.utils.preferences.AppPreference
import sero.com.jobs.utils.preferences.FilterType
import sero.com.jobs.utils.preferences.SortType

abstract class BaseFragment(private val layoutId: Int) : Fragment() {

    protected val shimmerViews: MutableList<ShimmerFrameLayout?> = mutableListOf()
    protected val contentView: MutableList<View?> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    protected fun handleUIState(uiState: UIState) {
        when (uiState) {
            UIState.Loading -> {
                hideError()
                hideContent()
                startShimmerAnim()
            }
            UIState.Success -> {
                endShimmerAnim()
                showContent()
            }
            UIState.NoData, UIState.NetworkError -> {
                endShimmerAnim()
                showError(uiState)
            }
        }
    }

    private fun startShimmerAnim() = shimmerViews.forEach { it?.beginShimmerAnim() }

    private fun endShimmerAnim() = shimmerViews.forEach { it?.endShimmerAnim() }

    private fun showContent() = contentView.forEach { it?.show() }

    private fun hideContent() = contentView.forEach { it?.hide() }

    private fun showError(uiState: UIState) {
        error_icon?.setImageResource(uiState.icon)
        error_msg?.text = getString(uiState.msg)
        error_container?.show()
    }

    private fun hideError() {
        error_container?.hide()
    }

    protected fun <T> observe(liveData: LiveData<T>, block: (T) -> Unit) {
        liveData.observe(viewLifecycleOwner, Observer { block(it) })
    }

    protected fun hideKeyboard() {
        (activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    protected fun showKeyboard(view: View) {
        if (view.requestFocus()) (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    protected fun getSortTypeFromPrefs(): SortType<out Comparable<Nothing>> {
        val sortTypeId = requireActivity().getSharedPreferences(AppPreference.FILENAME, 0)
            .getInt(AppPreference.SORT_TYPE.prefName, AppPreference.SORT_TYPE.defaultValue)
        return SortType.fromId(sortTypeId)
    }

    protected fun getFilterTypeFromPrefs(): FilterType {
        val filterTypeId = requireActivity().getSharedPreferences(AppPreference.FILENAME, 0)
            .getInt(AppPreference.FILTER_TYPE.prefName, AppPreference.FILTER_TYPE.defaultValue)
        return FilterType.fromId(filterTypeId)
    }
}