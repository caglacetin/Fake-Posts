package com.caglacetin.fakeposts.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.caglacetin.fakeposts.common.ReactiveViewModel
import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.common.Status
import com.caglacetin.fakeposts.common.doOnSuccess
import com.caglacetin.fakeposts.common.plusAssign
import com.caglacetin.fakeposts.domain.FetchPosts
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import javax.inject.Inject

class PostListViewModel @Inject constructor(
  private val useCase: FetchPosts
) : ReactiveViewModel() {

  private val _contents = MutableLiveData<List<PostItem>>()
  val contents: LiveData<List<PostItem>> = _contents
  private val _status = MutableLiveData<PostListViewState>()
  val status: LiveData<PostListViewState> = _status

  fun fetchPosts() {
    useCase
      .fetchPosts()
      .observeOn(AndroidSchedulers.mainThread())
      .doOnSuccess { list ->
        onRecipeListContentResultReady(list)
      }
      .subscribe { resource ->
        onRecipeListStatusResultReady(resource)
      }
      .also { disposable += it }
  }

  private fun onRecipeListStatusResultReady(resource: Resource<List<PostItem>>) {

    val viewState = when (resource) {
      is Resource.Success -> PostListViewState(Status.Content)
      is Resource.Error -> PostListViewState(Status.Error(resource.exception))
      Resource.Loading -> PostListViewState(Status.Loading)
    }
    _status.value = viewState
  }

  private fun onRecipeListContentResultReady(results: List<PostItem>) {
    _contents.value = results
  }

}