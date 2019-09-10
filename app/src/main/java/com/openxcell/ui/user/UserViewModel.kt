package com.openxcell.ui.user

import androidx.lifecycle.ViewModel
import com.openxcell.data.SubscribeWithOutType
import com.openxcell.data.pojo.CryptocurrencyEntity
import com.openxcell.data.repository.CryptocurrencyRepository
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class UserViewModel @Inject constructor(private val userRepository: CryptocurrencyRepository) : ViewModel() {



    fun callApi() {

        userRepository.getCryptocurrenciesFromApi()
            .subscribeOn(Schedulers.io())
            .subscribe(SubscribeWithOutType())

    }



}