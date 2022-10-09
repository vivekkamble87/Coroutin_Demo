package com.vivek.coroutin_demo.repository

import com.vivek.coroutin_demo.model.Post
import com.vivek.coroutin_demo.network.RetrofitBuilder

class PostRepository {
    suspend fun getPost(): List<Post> = RetrofitBuilder.api.getPost()
}