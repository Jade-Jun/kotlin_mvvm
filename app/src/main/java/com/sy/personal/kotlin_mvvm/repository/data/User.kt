package com.sy.personal.kotlin_mvvm.repository.data

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by SuYa on 2017. 11. 10..
 */
@Entity(tableName = "users")
data class User (
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "idx")
        var idx : Int = 0,
        @ColumnInfo(name = "email")
        var email : String = "",
        @ColumnInfo(name = "first")
        var first : String = "",
        @ColumnInfo(name = "last")
        var last : String = ""
)