package com.caglacetin.fakeposts.ui

import com.caglacetin.fakeposts.common.di.scope.ActivityScope
import com.caglacetin.fakeposts.ui.postlist.PostListAdapter
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

  @ActivityScope
  @get:Provides
  val postListAdapter = PostListAdapter()

}
