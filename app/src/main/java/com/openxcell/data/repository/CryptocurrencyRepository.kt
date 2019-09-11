package com.openxcell.data.repository

import androidx.lifecycle.LiveData
import com.openxcell.data.pojo.CryptocurrencyEntity
import io.reactivex.Observable
import io.reactivex.Single

interface CryptocurrencyRepository {

    fun getCryptocurrenciesFromApi(): Single<List<CryptocurrencyEntity>>

    fun getAll(): LiveData<List<CryptocurrencyEntity>>

}