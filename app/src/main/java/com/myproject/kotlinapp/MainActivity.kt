package com.myproject.kotlinapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myproject.kotlinapp.databinding.ActivityMainBinding
import com.myproject.kotlinapp.states.UserDataState
import com.myproject.kotlinapp.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: UserViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel = ViewModelProvider(this)[UserViewModel::class.java]

        viewModel.userDataState.observe(this) {
            when (it) {
                is UserDataState.Success -> {
                    binding.progressBar.visibility = View.GONE
                    binding.recycler.visibility = View.VISIBLE
                    val myAdapter = Adapter(it.userData.entries.toMutableList())
                    binding.recycler.adapter = myAdapter
                    Toast.makeText(this,""+it.userData.count,Toast.LENGTH_SHORT).show()
                }

                is UserDataState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this,""+it.exception,Toast.LENGTH_SHORT).show()
                }

                is UserDataState.Loading -> {

                }
            }
        }


        viewModel.getPosts()

    }


}