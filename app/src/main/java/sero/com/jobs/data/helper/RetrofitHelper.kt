package sero.com.jobs.data.helper

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sero.com.jobs.data.remote.MockyRetrofitRestApi
import sero.com.jobs.data.remote.RetrofitRestApi

object RetrofitHelper {

    private const val BASE_URL = "https://033b6765-042e-4fc2-bae5-ae38e0c5dac0.mock.pstmn.io"
    private const val MOCKY_BASE_URL = "https://www.mocky.io/"

    private val logging = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    private val httpClient = OkHttpClient.Builder().apply { addInterceptor(logging) }

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(httpClient.build())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val mockyRetrofit: Retrofit = Retrofit.Builder()
        .client(httpClient.build())
        .baseUrl(MOCKY_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): RetrofitRestApi {
        return retrofit.create(RetrofitRestApi::class.java)
    }

    private fun createMocky(): MockyRetrofitRestApi {
        return mockyRetrofit.create(MockyRetrofitRestApi::class.java)
    }

    private suspend fun <T : Any> safeApiCall(call: suspend () -> Response<T>): Either<UIState, T> {
        return try {
            val response = call.invoke()
            if (response.isSuccessful && response.body() != null) {
                response.body()?.let {
                    Either.Successful(it)
                } ?: Either.Failure(UIState.NoData)
            } else {
                Either.Failure(UIState.NetworkError)
            }
        } catch (e: Exception) {
            Either.Failure(UIState.NetworkError)
        }
    }

    suspend fun getMockyHomeContent() = safeApiCall { createMocky().getHomeContent() }
}