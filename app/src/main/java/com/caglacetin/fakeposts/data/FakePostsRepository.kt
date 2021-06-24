package com.caglacetin.fakeposts.data

import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.data.response.PostResponse
import com.caglacetin.fakeposts.data.response.UserResponse
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class FakePostsRepository @Inject constructor(
  private val service: JsonPlaceholderService
) {

  fun fetchPosts(): Observable<Resource<List<PostResponse>>> =
    service.fetchPosts()
      .map<Resource<List<PostResponse>>> {
        Resource.Success(it)
      }.onErrorReturn { throwable ->
        Resource.Error(throwable)
      }.observeOn(AndroidSchedulers.mainThread())

  fun getPostDetail(postId: Int): Observable<PostResponse> =
    service.getPostDetail(postId)
      .map {
       it
      }.observeOn(AndroidSchedulers.mainThread())

  fun getAUser(userId: Int): Observable<UserResponse> =
    service.getAUser(userId).map {
      it
    }.observeOn(AndroidSchedulers.mainThread())
}
