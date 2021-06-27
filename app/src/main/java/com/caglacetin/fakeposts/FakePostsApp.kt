package com.caglacetin.fakeposts

import com.caglacetin.fakeposts.common.di.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class FakePostsApp: DaggerApplication() {

  override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    return DaggerAppComponent.factory().create(this)
  }

}
