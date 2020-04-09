package sero.com.jobs.utils.preferences

import sero.com.jobs.R

enum class ColorMode(val id: Int, val theme: Int) {
    LIGHT(0, R.style.LightTheme),
    DARK(1, R.style.DarkTheme);

    companion object {
        fun fromId(id: Int) = values().find { it.id == id } ?: LIGHT
    }
}