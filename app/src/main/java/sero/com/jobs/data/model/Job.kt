package sero.com.jobs.data.model

import sero.com.jobs.ui.adapter.AdapterItem

data class Job(val id: Int, val title: String, val description: String, val category: String) : AdapterItem