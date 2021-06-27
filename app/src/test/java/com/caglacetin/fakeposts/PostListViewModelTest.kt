package com.caglacetin.fakeposts

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.caglacetin.fakeposts.common.Resource
import com.caglacetin.fakeposts.domain.FetchPosts
import com.caglacetin.fakeposts.ui.StatusViewState
import com.caglacetin.fakeposts.ui.postlist.PostItem
import com.caglacetin.fakeposts.ui.postlist.PostListViewModel
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.slot
import io.mockk.spyk
import io.mockk.verify
import io.reactivex.rxjava3.core.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class PostListViewModelTest {

  @MockK
  lateinit var fetchPostsUseCase: FetchPosts

  @Rule
  @JvmField
  val instantExecutorRule = InstantTaskExecutorRule()

  @Rule
  @JvmField
  var testSchedulerRule = RxImmediateSchedulerRule()

  private lateinit var postListViewModel: PostListViewModel

  @Before
  fun setUp() {
    MockKAnnotations.init(this)
    postListViewModel = PostListViewModel(fetchPostsUseCase)
  }

  @Test
  fun `given loading state, when fetchPosts called, then isLoading return true`() {

    // Given
    val mockedObserver = createPostListObserver()
    postListViewModel.status.observeForever(mockedObserver)

    every { fetchPostsUseCase.fetchPosts() } returns
      Observable.just(Resource.Loading)

    // When
    postListViewModel.fetchPosts()

    // Then
    val slot = slot<StatusViewState>()
    verify { mockedObserver.onChanged(capture(slot)) }

    assertThat(slot.captured.isLoading()).isTrue()

    verify { fetchPostsUseCase.fetchPosts() }
  }

  @Test
  fun `given error state, when fetchPosts called, then update live data for error status`() {
    // Given
    val mockedObserver = createPostListObserver()
    postListViewModel.status.observeForever(mockedObserver)
    val message = "This is an error!"
    val resource = Resource.Error(Throwable(message))

    every { fetchPostsUseCase.fetchPosts() } returns Observable.just(resource)

    // When
    postListViewModel.fetchPosts()

    // Then
    val slot = slot<StatusViewState>()
    verify { mockedObserver.onChanged(capture(slot)) }

    assertThat(slot.captured.getErrorMessage()).isEqualTo(message)
    assertThat(slot.captured.isLoading()).isFalse()

    verify { fetchPostsUseCase.fetchPosts() }
  }

  @Test
  fun `given success state, when fetchPosts called, then isLoading return false`() {
    // Given
    val mockedObserver = createPostListObserver()
    postListViewModel.status.observeForever(mockedObserver)
    val resource = Resource.Success(mutableListOf<PostItem>())

    every { fetchPostsUseCase.fetchPosts() } returns Observable.just(resource)

    // When
    postListViewModel.fetchPosts()

    // Then
    val postsViewStateSlots = mutableListOf<StatusViewState>()
    verify { mockedObserver.onChanged(capture(postsViewStateSlots)) }

    // Then
    val slot = slot<StatusViewState>()
    verify { mockedObserver.onChanged(capture(slot)) }

    assertThat(slot.captured.isLoading()).isFalse()

    verify { fetchPostsUseCase.fetchPosts() }
  }

  private fun createPostListObserver(): Observer<StatusViewState> =
    spyk(Observer { })
}