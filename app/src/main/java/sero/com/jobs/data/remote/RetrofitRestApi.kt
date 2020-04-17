package sero.com.jobs.data.remote

import retrofit2.http.GET
import retrofit2.http.Query
import sero.com.jobs.data.model.Job

interface RetrofitRestApi {
    @GET("/searchJobs")
    suspend fun getResearchResults(@Query("key")
                                   key: String): List<Job>
}