package com.sy.personal.kotlin_mvvm.view_model.data

import com.sy.personal.kotlin_mvvm.repository.data.User

/**
 * Created by SuYa on 2017. 11. 10..
 */
class UiData {

    data class UserList(val users: List<User>,
                        val msg : String,
                        val error : Throwable? = null)

}