package com.vivek.coroutin_demo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.vivek.coroutin_demo.repository.PostRepository

class PostViewModelFactory(private val postRepository: PostRepository) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PostViewModel(postRepository) as T
    }


}