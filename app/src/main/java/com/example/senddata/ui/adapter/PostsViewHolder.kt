package com.example.senddata.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.senddata.data.model.postsItem
import com.example.senddata.databinding.DataItemBinding

class PostsViewHolder(private val binding: DataItemBinding) :
    RecyclerView.ViewHolder(binding.root) {
    fun bindViews(postsModel: postsItem) {
        binding.apply {
            txtBody.text=postsModel.body
            txtTitle.text=postsModel.title
        }
    }
}