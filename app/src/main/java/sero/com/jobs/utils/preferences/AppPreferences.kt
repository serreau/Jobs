package sero.com.jobs.utils.preferences

enum class AppPreference(val id: Int, val prefName: String, val defaultValue: Int) {
    COLOR_MODE(0, "color_mode", ColorMode.LIGHT.id);

    companion object {
        const val FILENAME = "sero.com.jobs.prefs"
    }
}