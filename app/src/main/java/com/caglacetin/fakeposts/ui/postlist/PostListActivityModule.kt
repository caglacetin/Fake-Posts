package com.caglacetin.fakeposts.ui.postlist

import com.caglacetin.fakeposts.common.di.scope.ActivityScope
import dagger.Module
import dagger.Provides

@Module
class PostListActivityModule {

  @ActivityScope
  @get:Provides
  val postListAdapter = PostListAdapter()

}
