package com.sy.personal.kotlin_mvvm.repository.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.sy.personal.kotlin_mvvm.repository.data.User

/**
 * Created by SuYa on 2017. 11. 10..
 */
@Database(entities = arrayOf(User::class), version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao() : UserDao
}