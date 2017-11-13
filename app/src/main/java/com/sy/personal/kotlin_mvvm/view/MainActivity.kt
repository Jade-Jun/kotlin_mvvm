package com.sy.personal.kotlin_mvvm.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sy.personal.kotlin_mvvm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (null == savedInstanceState) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.frame_layout, UserFragment()).commit()
        }

    }
}