package com.example.retrofitwithcoroutines.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 20/02/2021
 */
const val BASE_URL = "https://jsonplaceholder.typicode.com/"

object RetrofitClient {

    private fun getRetrofitBuilder() =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    fun getRetrofitClient()=
        getRetrofitBuilder().create(ApiService::class.java)
}