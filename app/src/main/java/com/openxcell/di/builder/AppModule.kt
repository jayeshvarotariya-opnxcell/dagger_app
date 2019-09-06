package com.openxcell.di.builder

import com.openxcell.data.URLFactory
import com.openxcell.data.datasource.CryptocurrencyDataSource
import com.openxcell.data.repository.CryptocurrencyRepository
import com.openxcell.data.source.remote.ApiInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(provideHttpLoggingInterceptor())
        .build()

    private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val ceptor = HttpLoggingInterceptor()
        ceptor.level = HttpLoggingInterceptor.Level.BODY
        return ceptor
    }

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit =
        Retrofit.Builder().baseUrl(URLFactory.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).build()


    @Provides
    @Singleton
    fun providesApiInterface(retrofit: Retrofit): ApiInterface =
        retrofit.create(ApiInterface::class.java)

    @Provides
    @Singleton
    fun providesCryptocurrencyRepository(cryptocurrencyDataSource: CryptocurrencyDataSource): CryptocurrencyRepository =
        cryptocurrencyDataSource

}