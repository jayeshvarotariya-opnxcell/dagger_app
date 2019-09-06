package com.openxcell.data.repository

import com.openxcell.data.pojo.CryptocurrencyEntity
import io.reactivex.Observable

interface CryptocurrencyRepository {

    fun getCryptocurrenciesFromApi(): Observable<List<CryptocurrencyEntity>>

}