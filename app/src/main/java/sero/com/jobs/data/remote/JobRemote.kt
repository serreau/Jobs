package sero.com.jobs.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import sero.com.jobs.data.entity.Job

interface JobRemote {
    @GET("/searchJobs")
    suspend fun getResearchResults(@Query("key") key: String) : List<Job>
}