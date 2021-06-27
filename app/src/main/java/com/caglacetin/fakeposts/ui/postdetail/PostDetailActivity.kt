package com.caglacetin.fakeposts.ui.postdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.caglacetin.fakeposts.R.layout
import com.caglacetin.fakeposts.common.observeNonNull
import com.caglacetin.fakeposts.common.runIfNull
import com.caglacetin.fakeposts.databinding.ActivityPostDetailBinding
import dagger.android.AndroidInjection
import javax.inject.Inject

class PostDetailActivity: AppCompatActivity() {

  @Inject
  internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

  private lateinit var postDetailViewModel: PostDetailViewModel
  private lateinit var binding: ActivityPostDetailBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, layout.activity_post_detail)

    postDetailViewModel = ViewModelProvider(this, viewModelProviderFactory)
      .get(PostDetailViewModel::class.java)

    observeViewModel()

    savedInstanceState.runIfNull {
      val postID = intent.getIntExtra("POST_ID", DEFAULT_VALUE)
      postDetailViewModel.getAPost(postID)
    }
  }

  private fun observeViewModel() {
    postDetailViewModel.postDetailContent.observeNonNull(this) {
      binding.postViewState = PostDetailViewState(it)
    }

    postDetailViewModel.userContent.observeNonNull(this) {
      binding.userViewState = UserItemViewState(it)
    }

    postDetailViewModel.postDetailStatus.observeNonNull(this) {
      binding.viewState = it
      binding.executePendingBindings()
    }
  }

  companion object {
    const val DEFAULT_VALUE = 1
  }
}
