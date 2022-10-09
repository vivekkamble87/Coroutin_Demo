package com.vivek.coroutin_demo.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.material.tabs.TabLayout
import com.vivek.coroutin_demo.model.Post
import com.vivek.coroutin_demo.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel(){
    val postMutableLiveData: MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            try {
                val response = postRepository.getPost()
                postMutableLiveData.value = response
            } catch (e:Exception){
                Log.d("Error","getPost: ${e.message}")
            }

        }
    }
}