package com.openxcell.di.builder.app


import com.openxcell.di.builder.ViewModelModule
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module(includes = [NetModule::class,ViewModelModule::class,DataBaseModule::class])
class AppModule {


    @Provides
    @Named("db_name")
    fun provideDataBaseName() : String ="my_app_db"


}