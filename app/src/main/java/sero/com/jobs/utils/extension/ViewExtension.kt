package sero.com.jobs.utils.extension

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.shimmer.ShimmerFrameLayout
import com.google.android.material.textfield.TextInputEditText
import sero.com.jobs.ui.adapter.AdapterItem
import sero.com.jobs.ui.adapter.CustomAdapter
import sero.com.jobs.utils.tools.SafeClickListener

fun ShimmerFrameLayout.beginShimmerAnim() {
    if (!isShimmerStarted) startShimmer()
    show()
}

fun ShimmerFrameLayout.endShimmerAnim() {
    hide()
    if (isShimmerStarted) stopShimmer()
}

fun View.show() {
    animate().alpha(1.0f)
}

fun View.hide() {
    animate().alpha(0.0f)
}

fun View.setOnSafeClickListener(onSafeClick: (View) -> Unit) = setOnClickListener(SafeClickListener { onSafeClick(it) })

fun View.setMargin(startMargin: Int, topMargin: Int, endMargin: Int, bottomMargin: Int) {
    layoutParams = (layoutParams as ViewGroup.MarginLayoutParams).apply {
        setMargins(startMargin, topMargin, endMargin, bottomMargin)
    }
}

fun TextInputEditText.get(): String = text.toString()

fun RecyclerView.createOrUpdate(adapter: CustomAdapter, adapterItemList: List<AdapterItem>) {
    this.visibility = if (adapterItemList.isEmpty()) View.GONE else View.VISIBLE
    if (this.adapter == null) this.adapter = adapter
    else (this.adapter as? CustomAdapter)?.update(adapterItemList)
}

fun RecyclerView.init(hasFixedSize: Boolean, orientation: Int) {
    setHasFixedSize(hasFixedSize)
    layoutManager = LinearLayoutManager(context, orientation, false)
}