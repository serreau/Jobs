package sero.com.jobs.data.model

import com.google.gson.annotations.SerializedName
import sero.com.jobs.ui.adapter.AdapterItem

data class JobSummary(@SerializedName("id")
                      val id: Int,
                      @SerializedName("categoryId")
                      val categoryId: Int,
                      @SerializedName("location")
                      val location: String,
                      @SerializedName("price")
                      val price: String,
                      @SerializedName("title")
                      val title: String) : AdapterItem