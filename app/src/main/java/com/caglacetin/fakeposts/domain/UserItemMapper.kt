package com.caglacetin.fakeposts.domain

import com.caglacetin.fakeposts.common.Mapper
import com.caglacetin.fakeposts.data.response.UserResponse
import com.caglacetin.fakeposts.ui.postdetail.UserItem
import javax.inject.Inject

class UserItemMapper @Inject constructor(): Mapper<UserResponse, UserItem> {

  override fun mapFrom(type: UserResponse): UserItem {
    return UserItem(
      username = type.username,
      name = type.name
    )
  }
}
