package com.vivek.coroutin_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vivek.coroutin_demo.adapter.PostAdapter
import com.vivek.coroutin_demo.repository.PostRepository
import com.vivek.coroutin_demo.viewmodel.PostViewModel
import com.vivek.coroutin_demo.viewmodel.PostViewModelFactory
import com.vivek.coroutin_demo.model.Post

class MainActivity : AppCompatActivity() {
   private lateinit var recyclerView: RecyclerView
   private lateinit var postAdapter: PostAdapter
   private lateinit var progressBar: ProgressBar
   private lateinit var postViewModel: PostViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        val postRepository = PostRepository()
        val viewModelFactory = PostViewModelFactory(postRepository)
        postViewModel = ViewModelProvider(this,viewModelFactory)[PostViewModel::class.java]
        postViewModel.getPost()
        postViewModel.postMutableLiveData.observe(this, Observer {
            postAdapter.setData(it as ArrayList<Post>)
            progressBar.visibility = View.GONE
            recyclerView.visibility = View.VISIBLE
        })
    }

    private fun initRecyclerView() {
        recyclerView = findViewById(R.id.listView)
        progressBar = findViewById(R.id.progressBar)
        postAdapter = PostAdapter(this, ArrayList())
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = postAdapter
        }

    }


}