package com.example.retrofitwithcoroutines.network

import com.example.retrofitwithcoroutines.models.MainResponse
import retrofit2.Response
import retrofit2.http.GET


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 20/02/2021
 */
interface ApiService {
    @GET("posts")
    suspend fun getPostsService(): Response<MainResponse>
}