package com.caglacetin.fakeposts

import com.caglacetin.fakeposts.ui.postdetail.UserItem
import com.caglacetin.fakeposts.ui.postdetail.UserItemViewState
import com.google.common.truth.Truth
import org.junit.Test

class UserItemViewStateTest {

  @Test
  fun `should match user item name for given post item`() {

    // Given
    val userItem = createDummyUserItem()
    val givenViewState = UserItemViewState(userItem)

    // When
    val actualResult = givenViewState.getName()

    // Then
    Truth.assertThat(actualResult).isEqualTo("Leanne Graham")
  }

  @Test
  fun `should match user item username for given post item`() {

    // Given
    val userItem = createDummyUserItem()
    val givenViewState = UserItemViewState(userItem)

    // When
    val actualResult = givenViewState.getUsername()

    // Then
    Truth.assertThat(actualResult).isEqualTo("Bret")
  }

  private fun createDummyUserItem(): UserItem {
    return UserItem(
      name = "Leanne Graham",
      username = "Bret",
    )
  }

}