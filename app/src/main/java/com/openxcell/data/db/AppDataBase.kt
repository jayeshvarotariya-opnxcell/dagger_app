package com.openxcell.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.openxcell.data.pojo.CryptocurrencyEntity


@Database(entities = [CryptocurrencyEntity::class],version = 1,exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun provideCryptocurrencyDao() : CryptocurrencyDao

}