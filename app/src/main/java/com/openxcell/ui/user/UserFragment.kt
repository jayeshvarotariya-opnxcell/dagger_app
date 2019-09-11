package com.openxcell.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.openxcell.daggerapplication.R
import com.openxcell.daggerapplication.databinding.LayoutFragmentBinding
import com.openxcell.di.Injectable
import com.openxcell.ui.base.BaseFragment
import com.openxcell.utills.Logger
import com.openxcell.utills.SharedPrefsManager
import timber.log.Timber
import javax.inject.Inject

class UserFragment : BaseFragment(), Injectable {


    @Inject lateinit var  viewModelFactory: ViewModelProvider.Factory

    @Inject lateinit var sharedPrefsManager: SharedPrefsManager


    private val userViewModel: UserViewModel by viewModels {
        viewModelFactory
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return LayoutFragmentBinding.inflate(inflater,container,false).root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        addLiveDataObserver()
        sharedPrefsManager.setString("Hello","hello")

    }

    override fun onResume() {
        super.onResume()
        userViewModel.callApi()
    }

    private fun addLiveDataObserver() {
        userViewModel.getAllList()
            .observe(this, Observer {
                println("This is list count $it" )
                Logger.log("This is list count $it" )

            })
    }


}