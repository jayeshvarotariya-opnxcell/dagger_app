package com.openxcell.data.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update
import com.openxcell.data.pojo.CryptocurrencyEntity


@Dao
interface CryptocurrencyDao {

    @Insert
    fun insertCryptocurrency(vararg cryptocurrency: CryptocurrencyEntity)

    @Insert
    fun insertCryptocurrency(cryptocurrencys: List<CryptocurrencyEntity>)

    @Delete
    fun deleteCryptocurrency(cryptocurrency: CryptocurrencyEntity)

    @Update
    fun updateCryptocurrency(cryptocurrency: CryptocurrencyEntity)


}