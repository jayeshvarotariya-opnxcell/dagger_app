package com.openxcell.data.source.remote

import com.openxcell.data.URLFactory
import com.openxcell.data.pojo.CryptocurrencyEntity
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET(URLFactory.GET_CURRENCIES)
    fun getCryptocurrencies(@Query("start") start: String): Single<List<CryptocurrencyEntity>>

}