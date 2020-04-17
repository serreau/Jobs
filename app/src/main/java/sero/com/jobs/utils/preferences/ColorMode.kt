package sero.com.jobs.utils.preferences

import sero.com.jobs.R

enum class ColorMode(val id: Int, val theme: Int) {
    DEFAULT(0, R.style.DefaultTheme),
    DARK(1, R.style.DarkTheme);

    companion object {
        fun fromId(id: Int) = values().find { it.id == id } ?: DEFAULT
    }
}