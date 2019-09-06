package com.openxcell.data.datasource

import android.util.Log
import com.openxcell.data.pojo.CryptocurrencyEntity
import com.openxcell.data.repository.CryptocurrencyRepository
import com.openxcell.data.source.remote.ApiInterface
import io.reactivex.Observable
import javax.inject.Inject

class CryptocurrencyDataSource   @Inject constructor(val apiInterface: ApiInterface) :CryptocurrencyRepository {

    override fun getCryptocurrenciesFromApi(): Observable<List<CryptocurrencyEntity>> {
        return apiInterface.getCryptocurrencies("0")
            .doOnNext {
                Log.e("REPOSITORY API * ", it.size.toString())
            }
    }

}