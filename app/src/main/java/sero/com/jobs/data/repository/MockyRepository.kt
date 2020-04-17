package sero.com.jobs.data.repository

import sero.com.jobs.data.helper.RetrofitHelper

object MockyRepository {
    suspend fun getMockyHomeContent() = RetrofitHelper.getMockyHomeContent()
}