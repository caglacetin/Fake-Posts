package com.caglacetin.fakeposts.common.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.caglacetin.fakeposts.common.di.ViewModelFactory
import com.caglacetin.fakeposts.common.di.key.ViewModelKey
import com.caglacetin.fakeposts.ui.PostListViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {

    @get:IntoMap
    @get:Binds
    @get:ViewModelKey(PostListViewModel::class)
    val PostListViewModel.allPostsViewModel: ViewModel

    @get:Binds
    val ViewModelFactory.viewModelFactory: ViewModelProvider.Factory
}