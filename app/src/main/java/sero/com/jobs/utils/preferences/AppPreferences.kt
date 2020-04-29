package sero.com.jobs.utils.preferences

enum class AppPreference(val id: Int, val prefName: String, val defaultValue: Int) {
    COLOR_MODE(0, "color_mode", ColorMode.DEFAULT.id),
    SORT_TYPE(1, "sort_type", SortType.Default.id),
    FILTER_TYPE(2, "filter_type", FilterType.Default.id);

    companion object {
        const val FILENAME = "sero.com.jobs.prefs"
    }
}