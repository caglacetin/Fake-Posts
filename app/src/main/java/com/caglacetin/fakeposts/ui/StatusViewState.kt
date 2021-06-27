package com.caglacetin.fakeposts.ui

import com.caglacetin.fakeposts.common.Status

data class StatusViewState(
  val status: Status
) {
  fun isLoading() = status is Status.Loading
  fun getErrorMessage() = if (status is Status.Error) status.exception.message else ""
  fun shouldShowErrorMessage() = status is Status.Error
}