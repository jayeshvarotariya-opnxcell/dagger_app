package com.openxcell.data

import io.reactivex.SingleObserver
import io.reactivex.disposables.Disposable

class SubscribeWithOutType<T> : SingleObserver<T> {


    override fun onSuccess(t: T) {

    }

    override fun onSubscribe(d: Disposable) {

    }

    override fun onError(e: Throwable) {

    }

}