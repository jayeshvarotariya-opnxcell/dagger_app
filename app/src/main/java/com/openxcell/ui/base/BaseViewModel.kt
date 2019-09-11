package com.openxcell.ui.base

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import java.io.IOException
import java.lang.Exception

open class BaseViewModel : ViewModel() {


    val compositeDisposable = CompositeDisposable()

    val errorLiveData = ObservableField<String>()



    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed)
            compositeDisposable.dispose()
    }


    fun onError(e: Throwable){

        errorLiveData.set("Hello")


    }


}