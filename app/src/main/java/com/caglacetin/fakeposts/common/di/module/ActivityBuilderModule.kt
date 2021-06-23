package com.caglacetin.fakeposts.common.di.module

import com.caglacetin.fakeposts.PostListActivity
import com.caglacetin.fakeposts.common.di.scope.ActivityScope
import com.caglacetin.fakeposts.ui.MainActivityModule

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBuilderModule {

    @ActivityScope
    @get:ContributesAndroidInjector(modules = [MainActivityModule::class])
    val mainActivity: PostListActivity
}