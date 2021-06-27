package com.caglacetin.fakeposts.domain

import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.common.map
import com.caglacetin.fakeposts.data.FakePostsRepository
import com.caglacetin.fakeposts.ui.postdetail.UserItem
import com.caglacetin.fakeposts.ui.postlist.PostItem
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class GetAUser @Inject constructor(
  private val repository: FakePostsRepository,
  private val mapper: UserItemMapper
) {
  fun getAUser(userId: Int): Observable<Resource<UserItem>> =
    repository.getAUser(userId)
      .map { resource ->
        resource.map { response ->
          mapper.mapFrom(response)
        }
      }.startWithItem(
        Resource.Loading
      )
}
