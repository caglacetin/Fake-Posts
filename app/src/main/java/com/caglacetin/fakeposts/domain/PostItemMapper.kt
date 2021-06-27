package com.caglacetin.fakeposts.domain

import com.caglacetin.fakeposts.common.Mapper
import com.caglacetin.fakeposts.data.response.PostResponse
import com.caglacetin.fakeposts.ui.postdetail.PostDetailItem
import javax.inject.Inject

class PostItemMapper @Inject constructor(): Mapper<PostResponse, PostDetailItem> {

  override fun mapFrom(type: PostResponse): PostDetailItem {
    return PostDetailItem(
      userId = type.userId,
      title = type.title,
      body = type.body,
    )
  }
}
