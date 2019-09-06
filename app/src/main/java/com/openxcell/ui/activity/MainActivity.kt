package com.openxcell.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.openxcell.daggerapplication.R
import com.openxcell.ui.user.UserFragment
import com.openxcell.ui.base.ToolBarActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector

import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


class MainActivity : ToolBarActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun supportFragmentInjector(): AndroidInjector<Fragment> = dispatchingAndroidInjector


    override fun getMainLayout(): Int = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction().replace(R.id.mainContainer,
            UserFragment()
        ).commit()

    }


}