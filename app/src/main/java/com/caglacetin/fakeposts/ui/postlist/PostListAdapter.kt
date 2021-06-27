package com.caglacetin.fakeposts.ui.postlist

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.caglacetin.fakeposts.R
import com.caglacetin.fakeposts.common.inflate
import com.caglacetin.fakeposts.databinding.ItemPostBinding
import com.caglacetin.fakeposts.ui.postlist.PostListAdapter.PostItemViewHolder
import javax.inject.Inject

class PostListAdapter @Inject constructor() : RecyclerView.Adapter<PostItemViewHolder>() {

  private val postList: MutableList<PostItem> = mutableListOf()
  var itemClicked: ((id: Int) -> Unit)? = null

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
        itemView.setOnClickListener {
          itemClicked?.invoke(postItem.id)
        }
      }
    }
  }

}
