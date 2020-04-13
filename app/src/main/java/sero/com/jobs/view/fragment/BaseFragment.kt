package sero.com.jobs.view.fragment

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.activity.addCallback
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.util.*

abstract class BaseFragment(private val layoutId: Int) : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    protected fun addBackPressCallback(block: () -> Unit) {
        activity?.onBackPressedDispatcher?.addCallback(this) { block() }
    }

    protected fun <T> observe(liveData: LiveData<T>, block: (T) -> Unit) {
        liveData.observe(viewLifecycleOwner, Observer { block(it) })
    }

    protected fun hideKeyboard() {
        (activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as? InputMethodManager)?.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    fun showKeyboard(view: View) {
        if (view.requestFocus())
            (context?.getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager)?.showSoftInput(view, InputMethodManager.SHOW_IMPLICIT)
    }

    protected fun getRawIdentifier(name: String): Int {
        return resources.getIdentifier(name.toLowerCase(Locale.ENGLISH), "raw", this.activity?.packageName)
    }
}