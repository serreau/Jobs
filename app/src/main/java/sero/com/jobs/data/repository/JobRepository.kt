package sero.com.jobs.data.repository

import sero.com.jobs.data.remote.JobRemote
import sero.com.jobs.utils.tools.retrofit

object JobRepository {
    private val remote = retrofit.create(JobRemote::class.java)

    suspend fun getResearchResults(text : String) = remote.getResearchResults(text)
}

