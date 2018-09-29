package com.singpaulee.sandec.monthlypointofsale.rest

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ConfigRetrofit {
    //TODO Set BET BASE URL
    var BASE_URL_API:String = "http://172.24.250.113/possandec/"

    val httpClient : OkHttpClient =
            OkHttpClient.Builder()
                    .connectTimeout(100, TimeUnit.SECONDS)
                    .readTimeout(100, TimeUnit.SECONDS)
                    .build()

    val retrofits = Retrofit.Builder()
            .baseUrl(BASE_URL_API)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
}