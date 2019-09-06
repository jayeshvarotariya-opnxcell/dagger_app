package com.openxcell.di.builder

import com.openxcell.ui.TestFragment
import com.openxcell.ui.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class BuildersModule {

    @ContributesAndroidInjector
    abstract fun contributesMainActivity():MainActivity

    @ContributesAndroidInjector
    abstract fun contributesTestFragment(): TestFragment

}