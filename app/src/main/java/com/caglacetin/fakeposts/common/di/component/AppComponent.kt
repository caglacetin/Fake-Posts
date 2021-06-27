package com.caglacetin.fakeposts.common.di.component

import com.caglacetin.fakeposts.FakePostsApp
import com.caglacetin.fakeposts.common.di.module.ActivityBuilderModule
import com.caglacetin.fakeposts.common.di.module.DataModule
import com.caglacetin.fakeposts.common.di.module.ViewModelModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
  modules = [
    AndroidSupportInjectionModule::class,
    DataModule::class,
    ActivityBuilderModule::class,
    ViewModelModule::class
  ]
)
interface AppComponent : AndroidInjector<FakePostsApp> {
  @Component.Factory
  abstract class Factory : AndroidInjector.Factory<FakePostsApp>
}
