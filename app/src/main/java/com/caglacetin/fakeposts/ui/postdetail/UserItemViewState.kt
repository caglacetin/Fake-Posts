package com.caglacetin.fakeposts.ui.postdetail

data class UserItemViewState(
  private val userItem: UserItem
){
  fun getName() = userItem.name
  fun getUsername() = userItem.username
}
