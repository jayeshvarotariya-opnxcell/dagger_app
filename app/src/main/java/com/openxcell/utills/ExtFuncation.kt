package com.openxcell.utills

import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


fun <T> Single<T>.makeThreadSafe() = this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())