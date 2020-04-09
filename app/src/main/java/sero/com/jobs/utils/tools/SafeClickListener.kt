package sero.com.jobs.utils.tools

import android.os.SystemClock
import android.view.View
import sero.com.jobs.utils.SAFE_CLICK_DELAY

class SafeClickListener(private var interval: Int = SAFE_CLICK_DELAY, private val onSafeCLick: (View) -> Unit) : View.OnClickListener {

    private var lastTimeClicked: Long = 0

    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < interval) return
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeCLick(v)
    }
}