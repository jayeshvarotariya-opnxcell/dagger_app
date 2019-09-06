package com.openxcell.di

import android.app.Application
import com.openxcell.DemoApp
import com.openxcell.di.builder.AppModule
import com.openxcell.di.builder.BuildersModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, BuildersModule::class, AppModule::class]
)
interface AppComponets {


    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application) : Builder
        
        fun build():AppComponets

    }

    fun inject(app:DemoApp)

}