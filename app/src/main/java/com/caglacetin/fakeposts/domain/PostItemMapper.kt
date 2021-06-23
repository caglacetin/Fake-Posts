package com.caglacetin.fakeposts.domain

import com.caglacetin.fakeposts.common.Mapper
import com.caglacetin.fakeposts.data.response.PostResponse
import com.caglacetin.fakeposts.ui.PostItem
import javax.inject.Inject

class PostItemMapper @Inject constructor(): Mapper<List<PostResponse>, List<PostItem>> {

  override fun mapFrom(type: List<PostResponse>): List<PostItem> {
    return type.map { post ->
      PostItem(
        title = post.title,
        body = post.body,
      )
    }
  }
}
