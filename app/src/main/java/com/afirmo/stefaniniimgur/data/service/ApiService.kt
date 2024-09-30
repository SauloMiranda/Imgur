package com.afirmo.stefaniniimgur.data.service

import com.afirmo.stefaniniimgur.data.dto.ImgurData
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService {
    @Headers("Authorization: Client-ID b88477ac46042a7")
    @GET("3/gallery/search/")
    suspend fun fetchImages(@Query("q") query: String = "cats",
                            @Query("q_type") type: String = "image"): ImgurData
}