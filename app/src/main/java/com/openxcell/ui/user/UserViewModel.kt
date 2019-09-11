package com.openxcell.ui.user

import androidx.lifecycle.LiveData
import com.openxcell.data.pojo.CryptocurrencyEntity
import com.openxcell.data.repository.CryptocurrencyRepository
import com.openxcell.ui.base.BaseViewModel
import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable
import javax.inject.Inject

class UserViewModel @Inject constructor(private val cryptocurrencyRepository: CryptocurrencyRepository) : BaseViewModel() {


    fun callApi() {
        cryptocurrencyRepository.getCryptocurrenciesFromApi()
            .subscribe( object : SingleObserver<List<CryptocurrencyEntity>>{

                override fun onSuccess(t: List<CryptocurrencyEntity>) {
                    //Do something with result
                }

                override fun onSubscribe(d: Disposable) {
                   compositeDisposable.add(d)
                }

                override fun onError(e: Throwable) {
                 this@UserViewModel.onError(e)
                }

            })
    }

    fun getAllList() : LiveData<List<CryptocurrencyEntity>> = cryptocurrencyRepository.getAll()

}