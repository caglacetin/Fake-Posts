package com.caglacetin.fakeposts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.caglacetin.fakeposts.common.observeNonNull
import com.caglacetin.fakeposts.common.runIfNull
import com.caglacetin.fakeposts.databinding.ActivityPostListBinding
import com.caglacetin.fakeposts.ui.PostItem
import com.caglacetin.fakeposts.ui.PostListAdapter
import com.caglacetin.fakeposts.ui.PostListViewModel
import com.caglacetin.fakeposts.ui.PostListViewState
import dagger.android.AndroidInjection
import javax.inject.Inject

class PostListActivity : AppCompatActivity() {

  @Inject
  internal lateinit var viewModelProviderFactory: ViewModelProvider.Factory

  @Inject
  internal lateinit var postListAdapter: PostListAdapter

  private lateinit var postListViewModel: PostListViewModel
  private lateinit var binding: ActivityPostListBinding

  override fun onCreate(savedInstanceState: Bundle?) {
    AndroidInjection.inject(this)
    super.onCreate(savedInstanceState)
    binding = DataBindingUtil.setContentView(this, R.layout.activity_post_list)

    postListViewModel = ViewModelProvider(this, viewModelProviderFactory)
      .get(PostListViewModel::class.java)

    postListViewModel.contents.observeNonNull(this) { contents ->
      renderPostList(contents)
    }

    postListViewModel.status.observeNonNull(this) { contents ->
      renderStatusResult(contents)
    }

    savedInstanceState.runIfNull {
      fetchRecipes()
    }

    initPostListRecyclerView()
  }

  private fun initPostListRecyclerView() {
    val linearLayoutManager = LinearLayoutManager(this)
    binding.recyclerViewRecipe.apply {
      adapter = postListAdapter
      layoutManager = linearLayoutManager
    }
  }

  private fun renderStatusResult(statusViewState: PostListViewState) {
    binding.viewState = statusViewState
    binding.executePendingBindings()
  }

  private fun renderPostList(contents: List<PostItem>) {
    postListAdapter.setPosts(contents)
  }

  private fun fetchRecipes() {
    postListViewModel.fetchPosts()
  }

}
