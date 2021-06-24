package com.caglacetin.fakeposts.ui.postlist

data class PostItemViewState(
  private val postItem: PostItem
) {
  fun getPostTitle() = postItem.title
  fun getPostBody() = postItem.body
}