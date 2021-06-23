package com.caglacetin.fakeposts

import android.app.Application
import com.caglacetin.fakeposts.common.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class FakePostsApp: Application(), HasAndroidInjector {

  @Inject
  internal lateinit var androidInjector: DispatchingAndroidInjector<Any>

  override fun androidInjector(): AndroidInjector<Any> = androidInjector

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent
      .builder()
      .application(this)
      .build()
      .inject(this)
  }

}
