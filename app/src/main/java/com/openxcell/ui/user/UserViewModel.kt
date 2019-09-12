package com.openxcell.ui.user

import android.text.TextUtils
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import com.openxcell.daggerapplication.R
import com.openxcell.data.pojo.ResponseData
import com.openxcell.data.pojo.UserModel
import com.openxcell.data.repository.AuthRepository
import com.openxcell.ui.base.BaseViewModel
import com.openxcell.utills.Logger
import com.openxcell.utills.SubscribeWithModel
import javax.inject.Inject

class UserViewModel @Inject constructor(private val authRepository: AuthRepository) :
    BaseViewModel() {


    val email = ObservableField<String>("")
    val password = ObservableField<String>("")
    val emailError = ObservableField<String>("")
    val passwordError = ObservableField<String>("")


    fun submit(view:View) {
        if (validated())
            authRepository.userLogin(email.get()!!, password.get()!!)
                .subscribe(object :
                    SubscribeWithModel<ResponseData<UserModel>, UserViewModel>(this) {
                    override fun onSuccess(t: ResponseData<UserModel>) {
                        Logger.log(">>>>"+t.data)
                    }
                }
                )
    }

    private fun validated(): Boolean {
        emailError.set("")
        passwordError.set("")
        if (TextUtils.isEmpty(email.get())) {
            emailError.set(application.getString(R.string.blank_email))
            return false
        }
        if (TextUtils.isEmpty(password.get())) {
            emailError.set(application.getString(R.string.blank_password))
            return false
        }
        return true
    }

    fun getAllList(): LiveData<List<UserModel>> = authRepository.getAll()

}