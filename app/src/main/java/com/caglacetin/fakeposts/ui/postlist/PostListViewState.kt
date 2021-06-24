package com.caglacetin.fakeposts.ui.postlist

import com.caglacetin.fakeposts.common.Status

data class PostListViewState(
  val status: Status
) {
  fun isLoading() = status is Status.Loading
  fun getErrorMessage() = if (status is Status.Error) status.exception.message else ""
  fun shouldShowErrorMessage() = status is Status.Error
}