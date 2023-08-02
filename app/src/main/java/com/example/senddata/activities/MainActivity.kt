package com.example.senddata.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.senddata.R
import com.example.senddata.data.remote.RetrofitInstance
import com.example.senddata.data.repository.PostsRepository
import com.example.senddata.databinding.ActivityMainBinding
import com.example.senddata.ui.adapter.PostsAdapter
import com.example.senddata.ui.viewmodel.MainViewModelFactory
import com.example.senddata.ui.viewmodel.PostsViewModel

private lateinit var model: PostsViewModel
private lateinit var Adapter:PostsAdapter
private lateinit var viewModel: PostsViewModel
lateinit var binding: ActivityMainBinding
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }

    private fun bindViews() {
        val repository = PostsRepository()
        val viewModelFactory = MainViewModelFactory(application, repository)
        model = ViewModelProvider(this, viewModelFactory)[PostsViewModel::class.java]
        model.getPosts()
        model.postResponse.observe(this) { response ->
            if (response.isSuccessful) {
                Adapter.differ.submitList(response)
            }
        }
       Adapter= PostsAdapter()
        binding.recycler.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = Adapter
        }
    }
    private fun setViewModel() {
        //val postRepository = PostsRepository(
          //  RetrofitInstance(applicationContext)
        //)

        val viewModelProviderFactory =
            MainViewModelFactory(
                application, postRepository
            )

        viewModel = ViewModelProvider(
            this,
            viewModelProviderFactory
        )[viewModel::class.java]
    }
}