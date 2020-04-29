package sero.com.jobs.utils.preferences

import sero.com.jobs.data.model.JobSummary
import kotlin.reflect.KProperty1

sealed class SortType<T : Comparable<T>>(val id: Int, private val attribute: KProperty1<JobSummary, T>) {

    object Default : SortType<Int>(0, JobSummary::id)
    object Price : SortType<String>(1, JobSummary::price)
    object Location : SortType<String>(2, JobSummary::location)

    fun sort(list: List<JobSummary>) = list.sortedBy { attribute.get(it) }

    companion object {
        fun fromId(id: Int) = SortType::class.nestedClasses.filterIsInstance(SortType::class.java)
            .find { it.id == id } ?: Default
    }
}