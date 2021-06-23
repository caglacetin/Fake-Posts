package com.caglacetin.fakeposts.ui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caglacetin.fakeposts.R
import com.caglacetin.fakeposts.common.inflate
import com.caglacetin.fakeposts.databinding.ItemPostBinding
import javax.inject.Inject

class PostListAdapter @Inject constructor() : RecyclerView.Adapter<PostListAdapter.PostItemViewHolder>() {

  private val postList: MutableList<PostItem> = mutableListOf()

  fun setPosts(posts: List<PostItem>) {
    postList.addAll(posts)
    notifyDataSetChanged()
  }

  override fun onCreateViewHolder(
    parent: ViewGroup,
    viewType: Int
  ): PostItemViewHolder {
    val itemBinding = parent.inflate<ItemPostBinding>(R.layout.item_post, false)
    return PostItemViewHolder(itemBinding)
  }

  override fun onBindViewHolder(
    holder: PostItemViewHolder,
    position: Int
  ) {
    holder.bind(postList[position])
  }

  override fun getItemCount(): Int = postList.size

  inner class PostItemViewHolder(private val binding: ItemPostBinding) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(postItem: PostItem) {
      with(binding) {
        viewState = PostItemViewState(postItem)
        executePendingBindings()
      }
    }
  }

}
