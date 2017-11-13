package com.sy.personal.kotlin_mvvm.view

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import com.sy.personal.kotlin_mvvm.App
import com.sy.personal.kotlin_mvvm.R
import com.sy.personal.kotlin_mvvm.view.adapter.UserRecyclerAdapter
import com.sy.personal.kotlin_mvvm.view_model.data.UiData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_user.*
import java.net.ConnectException

/**
 * Created by SuYa on 2017. 11. 10..
 */
class UserFragment : BaseFragment() {

    val userRecyclerViewModel = App.injectUserRecyclerViewModel()

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.let {
            recycler_view.layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onStart() {
        super.onStart()
        subscribe(userRecyclerViewModel.getUsers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    showUsers(it)
                }, {
                    showError()
                })
        )
    }

    fun showUsers(data : UiData.UserList) {
        if (null == data.error) {
            recycler_view.adapter = UserRecyclerAdapter(context, data.users)
        } else if (data.error is ConnectException) {
            Log.d("connection error : ", "maybe inform user that data loaded from DB")
        } else {
            showError()
        }
    }

    fun showError() {
        Toast.makeText(context, "error occured : (", Toast.LENGTH_LONG).show()
    }
}