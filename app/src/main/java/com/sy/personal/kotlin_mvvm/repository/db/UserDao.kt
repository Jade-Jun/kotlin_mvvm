package com.sy.personal.kotlin_mvvm.repository.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sy.personal.kotlin_mvvm.repository.data.User
import io.reactivex.Single

/**
 * Created by SuYa on 2017. 11. 10..
 */
@Dao
interface UserDao {

    @Query("select * from users")
    fun getUsers(): Single<List<User>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user : User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(users: List<User>)
}