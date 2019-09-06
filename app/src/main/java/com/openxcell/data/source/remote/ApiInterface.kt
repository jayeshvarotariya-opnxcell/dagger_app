package com.openxcell.data.source.remote

import com.openxcell.data.pojo.CryptocurrencyEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("ticker/")
    fun getCryptocurrencies(@Query("start") start: String): Observable<List<CryptocurrencyEntity>>
}