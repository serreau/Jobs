package sero.com.jobs.utils.extension

import android.content.Context
import android.util.TypedValue
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import sero.com.jobs.utils.preferences.AppPreference
import sero.com.jobs.utils.preferences.ColorMode

fun doNothing() {}

fun Context.getColorFromAttr(attrId: Int): Int {
    val value = TypedValue()
    theme.resolveAttribute(attrId, value, true)
    return ContextCompat.getColor(this, value.resourceId)
}

fun AppCompatActivity.setThemeFromPrefs() {
    val colorModeId = getSharedPreferences(AppPreference.FILENAME, 0).getInt(AppPreference.COLOR_MODE.prefName, AppPreference.COLOR_MODE.defaultValue)
    setTheme(ColorMode.fromId(colorModeId).theme)
}

inline fun <reified T : ViewModel> ViewModelStoreOwner.getViewModel() = ViewModelProvider(this).get(T::class.java)