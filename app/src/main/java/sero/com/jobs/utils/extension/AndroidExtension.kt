package sero.com.jobs.utils.extension

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import sero.com.jobs.utils.preferences.AppPreference
import sero.com.jobs.utils.preferences.ColorMode

fun doNothing() {}

fun Context.showToast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

fun Context.getResDimen(res: Int) = resources.getDimension(res).toInt()

fun AppCompatActivity.setThemeFromPrefs() {
    val colorModeId = getSharedPreferences(AppPreference.FILENAME, 0).getInt(AppPreference.COLOR_MODE.prefName, AppPreference.COLOR_MODE.defaultValue)
    setTheme(ColorMode.fromId(colorModeId).theme)
}

inline fun <reified T : ViewModel> ViewModelStoreOwner.getViewModel() = ViewModelProvider(this).get(T::class.java)