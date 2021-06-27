package com.caglacetin.fakeposts.domain

import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.common.map
import com.caglacetin.fakeposts.data.FakePostsRepository
import com.caglacetin.fakeposts.ui.postdetail.PostDetailItem
import com.caglacetin.fakeposts.ui.postlist.PostItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetAPost @Inject constructor(
  private val repository: FakePostsRepository,
  private val mapper: PostItemMapper
) {
  fun getAPost(postId: Int): Observable<Resource<PostDetailItem>> =
    repository.getPostDetail(postId)
      .map { resource ->
        resource.map { response ->
          mapper.mapFrom(response)
        }
      }.startWithItem(
        Resource.Loading
      )
}
