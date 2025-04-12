package com.example.clasetrabajo.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.clasetrabajo.data.dao.AccountDao
import com.example.clasetrabajo.data.model.AccountEntity

@Database(entities = [AccountEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun accountDao(): AccountDao
}