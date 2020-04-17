package sero.com.jobs.data.remote

import retrofit2.Response
import retrofit2.http.GET
import sero.com.jobs.data.model.HomeContent

interface MockyRetrofitRestApi {
    @GET("v2/5e9834a23500002b00c47fb3")
    fun getHomeContentNoData(): Response<HomeContent>

    @GET("v2/5e9843303500006f00c48074")
    fun getHomeContentError(): Response<HomeContent>

    @GET("v2/5e997a9733000096297b2307")
    suspend fun getHomeContent(): Response<HomeContent>
}