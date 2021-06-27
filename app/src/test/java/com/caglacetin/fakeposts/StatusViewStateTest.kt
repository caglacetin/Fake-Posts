package com.caglacetin.fakeposts

import com.caglacetin.fakeposts.common.Status
import com.caglacetin.fakeposts.ui.StatusViewState
import com.google.common.truth.Truth
import org.junit.Test

class StatusViewStateTest {

  @Test
  fun `should return loading true when status is loading`() {

    // Given
    val givenViewState =
      StatusViewState(status = Status.Loading)

    // When
    val actualResult = givenViewState.isLoading()

    // Then
    Truth.assertThat(actualResult).isTrue()
  }

  @Test
  fun `should not return loading false when status is error`() {

    // Given
    val givenViewState =
      StatusViewState(status = Status.Error(Exception()))

    // When
    val actualResult = givenViewState.isLoading()

    // Then
    Truth.assertThat(actualResult).isFalse()
  }

  @Test
  fun `should not return loading false when status is success`() {

    // Given
    val givenViewState = StatusViewState(status = Status.Content)

    // When
    val actualResult = givenViewState.isLoading()

    // Then
    Truth.assertThat(actualResult).isFalse()
  }

  @Test
  fun `should return correct error message when status is error`() {

    // Given
    val givenViewState = StatusViewState(
        status = Status.Error(Exception("500 Internal Server Error")))

    // When
    val actualResult = givenViewState.getErrorMessage()

    // Then
    Truth.assertThat(actualResult).isEqualTo("500 Internal Server Error")
  }

  @Test
  fun `should return true for error message visibility when status is error`() {

    // Given
    val givenViewState =
      StatusViewState(
        status = Status.Error(Exception("500 Internal Server Error"))
      )

    // When
    val actualResult = givenViewState.shouldShowErrorMessage()

    // Then
    Truth.assertThat(actualResult).isTrue()
  }

}