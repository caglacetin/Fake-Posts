package com.caglacetin.fakeposts

import com.caglacetin.fakeposts.ui.postdetail.PostDetailItem
import com.caglacetin.fakeposts.ui.postdetail.PostDetailViewState
import com.google.common.truth.Truth
import org.junit.Test

class PostDetailViewStateTest {

  @Test
  fun `should match post detail item title for given post item`() {

    // Given
    val postDetailItem = createDummyPostDetailItem()
    val givenViewState = PostDetailViewState(postDetailItem)

    // When
    val actualResult = givenViewState.getPostTitle()

    // Then
    Truth.assertThat(actualResult).isEqualTo("non est facere")
  }

  @Test
  fun `should match post detail item body for given post item`() {

    // Given
    val postDetailItem = createDummyPostDetailItem()
    val givenViewState = PostDetailViewState(postDetailItem)

    // When
    val actualResult = givenViewState.getPostBody()

    // Then
    Truth.assertThat(actualResult).isEqualTo("molestias id nostru nconsectetur iste quaerat tenetur asperiores accusamus ex")
  }

  private fun createDummyPostDetailItem(): PostDetailItem {
    return PostDetailItem(
      userId = 3,
      title = "non est facere",
      body = "molestias id nostru nconsectetur iste quaerat tenetur asperiores accusamus ex",
    )
  }

}