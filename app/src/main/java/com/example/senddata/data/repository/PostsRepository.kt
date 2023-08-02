package com.example.senddata.data.repository

import com.example.senddata.data.model.postsItem
import com.example.senddata.data.remote.RetrofitInstance
import retrofit2.Response

class PostsRepository {
    suspend fun getPosts(): Response<postsItem> = RetrofitInstance.api.getPosts()
    //suspend fun getPostsNumber(number: Int): Response<postsItem> =
      //  RetrofitInstance.api.getPostsNumber(number)

   // suspend fun getCustomPosts(userId: Int, sort: String, order: String): Response<List<postsItem>> =
      //  RetrofitInstance.api.getCustomPost(userId, sort, order)
}