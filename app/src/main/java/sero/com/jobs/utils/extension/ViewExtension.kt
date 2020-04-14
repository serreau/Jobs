package sero.com.jobs.utils.extension

import android.view.View
import androidx.appcompat.widget.AppCompatImageView
import com.google.android.material.textfield.TextInputEditText
import sero.com.jobs.utils.tools.SafeClickListener

fun AppCompatImageView.tint(colorAttr: Int) {
    setColorFilter(context.getColorFromAttr(colorAttr), android.graphics.PorterDuff.Mode.SRC_IN)
}

fun View.setOnSafeClickListener(onSafeClick: (View) -> Unit) = setOnClickListener(SafeClickListener { onSafeClick(it) })

fun TextInputEditText.get(): String = text.toString()