package com.openxcell.data.datasource


import androidx.lifecycle.LiveData
import com.openxcell.data.db.CryptocurrencyDao
import com.openxcell.data.pojo.CryptocurrencyEntity
import com.openxcell.data.repository.CryptocurrencyRepository
import com.openxcell.data.source.remote.ApiInterface
import com.openxcell.utills.SubscribeWithOutType
import com.openxcell.utills.makeThreadSafe
import io.reactivex.Single
import io.reactivex.SingleEmitter
import io.reactivex.SingleOnSubscribe
import javax.inject.Inject

class CryptocurrencyDataSource   @Inject constructor(val apiInterface: ApiInterface,val cryptocurrencyDao: CryptocurrencyDao) :CryptocurrencyRepository {



    override fun getAll(): LiveData<List<CryptocurrencyEntity>> = cryptocurrencyDao.getAllList()

    override fun getCryptocurrenciesFromApi(): Single<List<CryptocurrencyEntity>> {
        return apiInterface.getCryptocurrencies("0").makeThreadSafe()
            .doOnSuccess {
               insertCryptocurrency(it)
            }
    }

    private fun insertCryptocurrency(list: List<CryptocurrencyEntity>) {
        Single.create(object :SingleOnSubscribe<Boolean>{
            override fun subscribe(e: SingleEmitter<Boolean>) {
                cryptocurrencyDao.insertCryptocurrency(list)
            }
        })
            .subscribe(SubscribeWithOutType())
    }


}