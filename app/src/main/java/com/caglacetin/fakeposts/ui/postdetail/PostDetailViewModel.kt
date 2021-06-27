package com.caglacetin.fakeposts.ui.postdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.caglacetin.fakeposts.common.ReactiveViewModel
import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.common.Status.Content
import com.caglacetin.fakeposts.common.Status.Error
import com.caglacetin.fakeposts.common.Status.Loading
import com.caglacetin.fakeposts.common.doOnSuccess
import com.caglacetin.fakeposts.common.plusAssign
import com.caglacetin.fakeposts.domain.GetAPost
import com.caglacetin.fakeposts.domain.GetAUser
import com.caglacetin.fakeposts.ui.StatusViewState
import javax.inject.Inject

class PostDetailViewModel @Inject constructor(
  private val postUseCase: GetAPost,
  private val userUseCase: GetAUser
) : ReactiveViewModel() {

  private val _postDetailContent = MutableLiveData<PostDetailItem>()
  val postDetailContent: LiveData<PostDetailItem> = _postDetailContent
  private val _postDetailStatus = MutableLiveData<StatusViewState>()
  val postDetailStatus: LiveData<StatusViewState> = _postDetailStatus

  private val _userContent = MutableLiveData<UserItem>()
  val userContent: LiveData<UserItem> = _userContent

  fun getAPost(postId: Int) {
    postUseCase
      .getAPost(postId)
      .doOnSuccess { post ->
        setPostDetail(post)
        getAUser(post.userId)
      }
      .subscribe { resource ->
        postDetailStatus(resource)
      }
      .also { disposable += it }
  }

  private fun getAUser(userId: Int){
    userUseCase.getAUser(userId)
      .doOnSuccess { user ->
        setUserInfo(user)
      }
      .subscribe { resource ->
        postDetailStatus(resource)
      }
      .also { disposable += it }
  }

  private fun postDetailStatus(resource: Resource<Any>) {
    val viewState = when (resource) {
      is Resource.Success -> StatusViewState(Content)
      is Resource.Error -> StatusViewState(Error(resource.exception))
      Resource.Loading -> StatusViewState(Loading)
    }
    _postDetailStatus.value = viewState
  }

  private fun setUserInfo(user: UserItem) {
    _userContent.value = user
  }

  private fun setPostDetail(post: PostDetailItem) {
    _postDetailContent.value = post
  }
}