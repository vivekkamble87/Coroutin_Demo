package com.vivek.coroutin_demo.network

import com.vivek.coroutin_demo.model.Post
import retrofit2.http.GET

interface Api {
    @GET("posts")
    suspend fun getPost() : List<Post>
}