package com.sy.personal.kotlin_mvvm.view

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by SuYa on 2017. 11. 10..
 */
open class BaseFragment : Fragment() {

    val mSubscriptions = CompositeDisposable()

    fun subscribe(disposable: Disposable) : Disposable {
        mSubscriptions.add(disposable)
        return disposable
    }

    override fun onStop() {
        super.onStop()
        mSubscriptions.clear()
    }
}