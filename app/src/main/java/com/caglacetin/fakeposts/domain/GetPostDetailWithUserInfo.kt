package com.caglacetin.fakeposts.domain

import com.caglacetin.fakeposts.data.FakePostsRepository
import com.caglacetin.fakeposts.ui.postdetail.PostDetailItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetPostDetailWithUserInfo @Inject constructor(
  private val repository: FakePostsRepository,
  private val mapper: PostDetailMapper
) {
  fun getPostDetail(postId: Int): Observable<PostDetailItem> =
    repository.getPostDetail(postId)
      .flatMap { post ->
          repository.getAUser(post.userId)
            .map {
              mapper.mapFrom(post, it)
            }
        }
}