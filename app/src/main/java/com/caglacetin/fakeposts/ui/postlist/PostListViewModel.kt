package com.caglacetin.fakeposts.ui.postlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.caglacetin.fakeposts.common.ReactiveViewModel
import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.common.Status.Content
import com.caglacetin.fakeposts.common.Status.Error
import com.caglacetin.fakeposts.common.Status.Loading
import com.caglacetin.fakeposts.common.doOnSuccess
import com.caglacetin.fakeposts.common.plusAssign
import com.caglacetin.fakeposts.domain.FetchPosts
import com.caglacetin.fakeposts.ui.StatusViewState
import javax.inject.Inject

class PostListViewModel @Inject constructor(
  private val useCase: FetchPosts
) : ReactiveViewModel() {

  private val _contents = MutableLiveData<List<PostItem>>()
  val contents: LiveData<List<PostItem>> = _contents
  private val _status = MutableLiveData<StatusViewState>()
  val status: LiveData<StatusViewState> = _status

  fun fetchPosts() {
    useCase
      .fetchPosts()
      .doOnSuccess { list ->
        _contents.value = list
      }
      .subscribe { resource ->
        setPostListStatus(resource)
      }
      .also { disposable += it }
  }

  private fun setPostListStatus(resource: Resource<List<PostItem>>) {
    val viewState = when (resource) {
      is Resource.Success -> StatusViewState(Content)
      is Resource.Error -> StatusViewState(Error(resource.exception))
      Resource.Loading -> StatusViewState(Loading)
    }
    _status.value = viewState
  }
}
