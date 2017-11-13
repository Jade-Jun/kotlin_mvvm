package com.sy.personal.kotlin_mvvm.repository

import com.sy.personal.kotlin_mvvm.repository.api.UserApi
import com.sy.personal.kotlin_mvvm.repository.data.User
import com.sy.personal.kotlin_mvvm.repository.db.UserDao
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers

/**
 * Created by SuYa on 2017. 11. 10..
 */
class UserRepository(val userApi: UserApi, val userDao : UserDao) {

    fun getUsers() : Observable<List<User>> {
        return Observable.concatArray(
                getUsersFromDb(),
                getUsersFromApi()
        )
    }

    fun getUsersFromDb(): Observable<List<User>> {
        return userDao.getUsers().filter {it.isNotEmpty()}
                .toObservable()
                .doOnNext {

                }
    }

    fun getUsersFromApi(): Observable<List<User>> {
        return userApi.getUsers()
                .doOnNext {
                    storeUserInDb(it)
                }
    }

    fun storeUserInDb(users: List<User>) {
        Observable.fromCallable {userDao.insertAll(users)}
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.io())
                .subscribe {

                }
    }

}