package sero.com.jobs.utils.tools

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import sero.com.jobs.utils.BASE_URL

private val logging =  HttpLoggingInterceptor().apply { level= HttpLoggingInterceptor.Level.BODY }
private val httpClient =  OkHttpClient.Builder().apply { addInterceptor(logging) }
val retrofit : Retrofit = Retrofit.Builder()
    .baseUrl(BASE_URL)
    .client(httpClient.build())
    .addConverterFactory(GsonConverterFactory.create())
    .build()