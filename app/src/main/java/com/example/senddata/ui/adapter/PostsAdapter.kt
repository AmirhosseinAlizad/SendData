package com.example.senddata.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.senddata.data.model.postsItem
import com.example.senddata.databinding.DataItemBinding

class PostsAdapter : Adapter<PostsViewHolder>() {
    private val differCallback = object : DiffUtil.ItemCallback<postsItem>() {
        override fun areItemsTheSame(oldItem: postsItem, newItem: postsItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: postsItem, newItem: postsItem): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallback)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        return PostsViewHolder(
            DataItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentItem = differ.currentList[position]
        holder.bindViews(currentItem)
    }

}