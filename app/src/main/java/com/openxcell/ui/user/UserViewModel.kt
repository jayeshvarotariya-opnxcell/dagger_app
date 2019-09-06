package com.openxcell.ui.user

import androidx.lifecycle.ViewModel
import com.openxcell.data.pojo.CryptocurrencyEntity
import com.openxcell.data.repository.CryptocurrencyRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: CryptocurrencyRepository) : ViewModel() {



    fun callApi() {
        userRepository.getCryptocurrenciesFromApi()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .debounce(400, TimeUnit.MILLISECONDS)
            .subscribe(object : DisposableObserver<List<CryptocurrencyEntity>>() {
                override fun onComplete() {

                }

                override fun onNext(t: List<CryptocurrencyEntity>) {

                }

                override fun onError(e: Throwable) {
                }

            })
    }

}