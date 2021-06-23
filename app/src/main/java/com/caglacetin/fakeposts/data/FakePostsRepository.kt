package com.caglacetin.fakeposts.data

import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.data.response.PostResponse
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class FakePostsRepository @Inject constructor(
  private val service: JsonPlaceholderService) {

  fun fetchPosts(): Observable<Resource<List<PostResponse>>> =
    service.fetchPosts()
      .map<Resource<List<PostResponse>>> {
        Resource.Success(it)
      }.onErrorReturn { throwable ->
        Resource.Error(throwable)
      }
}
