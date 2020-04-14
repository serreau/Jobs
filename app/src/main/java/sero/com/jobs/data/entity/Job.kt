package sero.com.jobs.data.entity

import com.google.gson.annotations.SerializedName
import sero.com.jobs.view.adapter.AdapterItem

data class Job(@SerializedName("idJob") val id: Int,
               @SerializedName("titreJob") val title: String,
               @SerializedName("descriptifJob") val description: String,
               @SerializedName("categorie") val category: String) : AdapterItem