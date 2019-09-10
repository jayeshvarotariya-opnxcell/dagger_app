package com.openxcell.ui.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.openxcell.daggerapplication.R
import com.openxcell.di.Injectable
import javax.inject.Inject

class UserFragment : Fragment(), Injectable {





    @Inject lateinit var  viewModelFactory: ViewModelProvider.Factory


    private val userViewModel: UserViewModel by viewModels {
        viewModelFactory
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        userViewModel.callApi()



    }


}