package com.openxcell.di.builder

import com.openxcell.ui.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module(includes = [ViewModelModule::class])
abstract class FragmentBuildersModule {


    @ContributesAndroidInjector
    abstract fun contributeTestFragment(): UserFragment


}
