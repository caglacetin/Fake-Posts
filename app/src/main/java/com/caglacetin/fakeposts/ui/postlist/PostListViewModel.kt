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
      is Resource.Success -> PostListViewState(Content)
      is Resource.Error -> PostListViewState(Error(resource.exception))
      Resource.Loading -> PostListViewState(Loading)
    }
    _status.value = viewState
  }

  private fun onRecipeListContentResultReady(results: List<PostItem>) {
    _contents.value = results
  }

}