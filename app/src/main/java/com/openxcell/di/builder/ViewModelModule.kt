package com.openxcell.di.builder

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.openxcell.data.datasource.CryptocurrencyDataSource
import com.openxcell.data.repository.CryptocurrencyRepository
import com.openxcell.mainviewmodel.ViewModelFactory
import com.openxcell.ui.user.UserViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(UserViewModel::class)
    abstract fun bindUserViewModel(userViewModel: UserViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    abstract fun provideCryptocurrencyRepository (cryptocurrencyDataSource: CryptocurrencyDataSource): CryptocurrencyRepository

}
