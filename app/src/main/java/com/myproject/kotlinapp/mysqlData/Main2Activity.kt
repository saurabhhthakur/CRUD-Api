package com.myproject.kotlinapp.mysqlData

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.myproject.kotlinapp.R
import com.myproject.kotlinapp.mysqlData.sqlViewmodel.SqlViewModel

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val sqlViewModel = ViewModelProvider(this)[SqlViewModel::class.java]
        sqlViewModel.getLogin().observe(this){
            when(it){
                is ControlState.Loading -> {

                }
                is ControlState.Success -> {
                    if(it.detail.message == "login")
                        supportFragmentManager.beginTransaction().add(R.id.container,DashboardFragment()).commit()
                    else
                        supportFragmentManager.beginTransaction().add(R.id.container,LoginFragment()).commit()
                }
                is ControlState.Error -> {
                    supportFragmentManager.beginTransaction().add(R.id.container,LoginFragment()).commit()
                }
            }
        }


    }
}