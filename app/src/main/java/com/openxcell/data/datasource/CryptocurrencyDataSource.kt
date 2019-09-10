package com.openxcell.data.datasource


import com.openxcell.data.db.CryptocurrencyDao
import com.openxcell.data.pojo.CryptocurrencyEntity
import com.openxcell.data.repository.CryptocurrencyRepository
import com.openxcell.data.source.remote.ApiInterface
import io.reactivex.Single
import javax.inject.Inject

class CryptocurrencyDataSource   @Inject constructor(val apiInterface: ApiInterface,val cryptocurrencyDao: CryptocurrencyDao) :CryptocurrencyRepository {

    override fun getCryptocurrenciesFromApi(): Single<List<CryptocurrencyEntity>> {
        return apiInterface.getCryptocurrencies("0")
            .doOnSuccess {

                cryptocurrencyDao.insertCryptocurrency(it)

            }
    }


}