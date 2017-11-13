package com.sy.personal.kotlin_mvvm.view_model

import com.sy.personal.kotlin_mvvm.repository.UserRepository
import com.sy.personal.kotlin_mvvm.view_model.data.UiData.*
import io.reactivex.Observable
import java.util.concurrent.TimeUnit

/**
 * Created by SuYa on 2017. 11. 10..
 */
class UserRecyclerViewModel(val userRepository: UserRepository) {
    fun getUsers() : Observable<UserList> {
        return userRepository.getUsers()
                .debounce(400, TimeUnit.MILLISECONDS)
                .map {
                    UserList(it.take(10), "Top 10 Users")
                }
                .onErrorReturn {
                    UserList(emptyList(), "An error occurred", it)
                }
    }
}