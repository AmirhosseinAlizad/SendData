package com.example.senddata.data.remote

import com.example.senddata.data.model.postsItem
import com.example.senddata.utils.Constance
import retrofit2.Response
import retrofit2.http.GET

interface SimpleApi {

    @GET(value = Constance.END_POINT)
    suspend fun getPosts(): Response<postsItem>
}