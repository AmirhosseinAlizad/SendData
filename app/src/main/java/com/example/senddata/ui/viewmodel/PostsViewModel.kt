package com.example.senddata.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.senddata.data.model.postsItem
import com.example.senddata.data.repository.PostsRepository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response

class PostsViewModel(private val repository: PostsRepository) : ViewModel() {
    val postResponse: MutableLiveData<Response<postsItem>> = MutableLiveData()
    fun getPosts() {
        viewModelScope.launch {
            val response: Response<postsItem> = repository.getPosts()
            postResponse.value = response
        }
    }

}