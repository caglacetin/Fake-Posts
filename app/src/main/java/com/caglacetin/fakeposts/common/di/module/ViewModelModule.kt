package com.caglacetin.fakeposts.common.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.caglacetin.fakeposts.common.di.ViewModelFactory
import com.caglacetin.fakeposts.common.di.key.ViewModelKey
import com.caglacetin.fakeposts.ui.postdetail.PostDetailViewModel
import com.caglacetin.fakeposts.ui.postlist.PostListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(PostListViewModel::class)
    internal abstract fun bindPostListViewModel(viewModel: PostListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PostDetailViewModel::class)
    internal abstract fun bindPostDetailViewModel(viewModel: PostDetailViewModel): ViewModel
}