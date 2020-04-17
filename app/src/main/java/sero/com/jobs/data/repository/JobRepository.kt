package sero.com.jobs.data.repository

import sero.com.jobs.data.helper.RetrofitHelper

object JobRepository {
    private val remote = RetrofitHelper.create()

    suspend fun getResearchResults(text: String) = remote.getResearchResults(text)
}

