package com.openxcell.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.openxcell.data.pojo.CryptocurrencyEntity


@Dao
interface CryptocurrencyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCryptocurrency(vararg cryptocurrency: CryptocurrencyEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCryptocurrency(cryptocurrencys: List<CryptocurrencyEntity>)

    @Delete
    fun deleteCryptocurrency(cryptocurrency: CryptocurrencyEntity)

    @Update
    fun updateCryptocurrency(cryptocurrency: CryptocurrencyEntity)


    @Query("Select * from CryptocurrencyEntity")
    fun getAllList() : LiveData<List<CryptocurrencyEntity>>

}