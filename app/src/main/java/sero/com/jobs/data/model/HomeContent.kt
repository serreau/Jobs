package sero.com.jobs.data.model

import com.google.gson.annotations.SerializedName

data class HomeContent(@SerializedName("categories")
                       val categories: List<Int>,
                       @SerializedName("jobs")
                       val jobs: List<JobSummary>)