package  com.caglacetin.fakeposts.common.di.module

import com.caglacetin.fakeposts.data.NetworkModule
import dagger.Module

@Module(
    includes = [NetworkModule::class]
)
class DataModule
