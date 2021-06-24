package com.caglacetin.fakeposts.ui.postdetail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.caglacetin.fakeposts.R.layout
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

  }

}
