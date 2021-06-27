package com.caglacetin.fakeposts

import com.caglacetin.fakeposts.ui.postlist.PostItem
import com.caglacetin.fakeposts.ui.postlist.PostItemViewState
import com.google.common.truth.Truth
import org.junit.Test

class PostItemViewStateTest {

  @Test
  fun `should match post item title for given post item`() {

    // Given
    val postItem = createDummyPostItem()
    val givenViewState = PostItemViewState(postItem)

    // When
    val actualResult = givenViewState.getPostTitle()

    // Then
    Truth.assertThat(actualResult).isEqualTo("non est facere")
  }

  @Test
  fun `should match post item body for given post item`() {

    // Given
    val postItem = createDummyPostItem()
    val givenViewState = PostItemViewState(postItem)

    // When
    val actualResult = givenViewState.getPostBody()

    // Then
    Truth.assertThat(actualResult).isEqualTo("molestias id nostru nconsectetur iste quaerat tenetur asperiores accusamus ex")
  }

  private fun createDummyPostItem(): PostItem {
    return PostItem(
      id = 1,
      title = "non est facere",
      body = "molestias id nostru nconsectetur iste quaerat tenetur asperiores accusamus ex",
    )
  }

}