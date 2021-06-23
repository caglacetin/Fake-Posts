package com.caglacetin.fakeposts.common.di.component

import android.app.Application
import com.caglacetin.fakeposts.FakePostsApp
import com.caglacetin.fakeposts.common.di.module.ActivityBuilderModule
import com.caglacetin.fakeposts.common.di.module.DataModule
import com.caglacetin.fakeposts.common.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
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
interface AppComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder
    fun build(): AppComponent
  }

  fun inject(app: FakePostsApp)
}
