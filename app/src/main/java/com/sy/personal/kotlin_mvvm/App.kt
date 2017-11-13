package com.sy.personal.kotlin_mvvm

import android.app.Application
import android.arch.persistence.room.Room
import com.sy.personal.kotlin_mvvm.repository.UserRepository
import com.sy.personal.kotlin_mvvm.repository.api.UserApi
import com.sy.personal.kotlin_mvvm.repository.db.AppDatabase
import com.sy.personal.kotlin_mvvm.view_model.UserRecyclerViewModel
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by SuYa on 2017. 11. 10..
 */
class App : Application() {

    companion object {
        private lateinit var retrofit : Retrofit
        private lateinit var userApi : UserApi
        private lateinit var userRepository : UserRepository
        private lateinit var userRecyclerViewModel : UserRecyclerViewModel
        private lateinit var appDataBase : AppDatabase

        fun injectUserApi() = userApi
        fun injectUserRecyclerViewModel() = userRecyclerViewModel
        fun injectUserDao() = appDataBase.userDao()

    }

    override fun onCreate() {
        super.onCreate()

        retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://randomapi.com/api/")
                .build()

        userApi = retrofit.create(UserApi::class.java)
        appDataBase = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "mvvm-database").build()

        userRepository = UserRepository(userApi, appDataBase.userDao())
        userRecyclerViewModel = UserRecyclerViewModel(userRepository)

    }
}