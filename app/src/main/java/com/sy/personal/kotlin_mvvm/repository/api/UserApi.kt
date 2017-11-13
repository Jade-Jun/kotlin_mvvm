package com.sy.personal.kotlin_mvvm.repository.api

import com.sy.personal.kotlin_mvvm.repository.data.User
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * Created by SuYa on 2017. 11. 10..
 */
interface UserApi {

    @GET("6de6abfedb24f889e0b5f675edc50deb?fmt=raw&sole")
    fun getUsers() : Observable<List<User>>

}