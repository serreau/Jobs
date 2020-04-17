package sero.com.jobs.data.model

import sero.com.jobs.R
import sero.com.jobs.ui.adapter.AdapterItem

enum class Category(val id: Int, val label: Int, val icon: Int) : AdapterItem {
    COMPUTER_SCIENCE(0, R.string.computer_science, R.drawable.ic_category_computer_science),
    GARDENING(1, R.string.gardening, R.drawable.ic_category_gardening),
    MANUAL_LABOR(2, R.string.manual_labor, R.drawable.ic_category_manual_labor),
    SHOPPING(3, R.string.shopping, R.drawable.ic_category_shopping),
    CHILD_CARE(4, R.string.child_care, R.drawable.ic_category_child_care);

    companion object {
        fun fromId(id: Int) = values().find { it.id == id } ?: COMPUTER_SCIENCE
    }
}