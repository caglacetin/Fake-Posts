package com.caglacetin.fakeposts.domain

import com.caglacetin.fakeposts.common.DoubleMapper
import com.caglacetin.fakeposts.common.Mapper
import com.caglacetin.fakeposts.data.response.PostDetailAndUserResponse
import com.caglacetin.fakeposts.data.response.PostResponse
import com.caglacetin.fakeposts.data.response.UserResponse
import com.caglacetin.fakeposts.ui.postdetail.PostDetailItem
import javax.inject.Inject

class PostDetailMapper @Inject constructor() : DoubleMapper<PostResponse, UserResponse, PostDetailItem> {

  override fun mapFrom(
    type: PostResponse,
    secondType: UserResponse
  ): PostDetailItem {
    return PostDetailItem(
      title = type.title,
      body = type.body,
      name = secondType.name,
      username = secondType.userName
    )
  }
}
