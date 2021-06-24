package com.caglacetin.fakeposts.ui.postdetail

import com.caglacetin.fakeposts.common.ReactiveViewModel
import com.caglacetin.fakeposts.domain.GetPostDetailWithUserInfo
import javax.inject.Inject

class PostDetailViewModel @Inject constructor(
  private val useCase: GetPostDetailWithUserInfo
) : ReactiveViewModel() {



}