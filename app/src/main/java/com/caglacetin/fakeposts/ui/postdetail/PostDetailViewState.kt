package com.caglacetin.fakeposts.ui.postdetail

data class PostDetailViewState(
  private val postDetailItem: PostDetailItem
  ) {
  fun getPostTitle() = postDetailItem.title
  fun getPostBody() = postDetailItem.body
}
