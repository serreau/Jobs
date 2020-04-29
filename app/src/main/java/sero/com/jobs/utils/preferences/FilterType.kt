package sero.com.jobs.utils.preferences

import sero.com.jobs.data.model.Category
import sero.com.jobs.data.model.JobSummary

sealed class FilterType(val id: Int, private val categoryList: List<Category> = Category.values().toList()) {

    object Default : FilterType(0)
    data class Specified(val list: List<Category>) : FilterType(1, list)

    fun filter(list: List<JobSummary>) = list.filter { it.categoryId in categoryList.map { it.id } }

    companion object {
        fun fromId(id: Int) = FilterType::class.nestedClasses.filterIsInstance(FilterType::class.java)
            .find { it.id == id } ?: Default
    }
}