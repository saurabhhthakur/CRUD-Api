package com.myproject.kotlinapp.mysqlData

import android.app.ProgressDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myproject.kotlinapp.R
import com.myproject.kotlinapp.databinding.FragmentLoginBinding
import com.myproject.kotlinapp.mysqlData.sqlViewmodel.SqlViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)

        binding.register.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, RegisterFragment())?.addToBackStack(null)?.commit()
        }
        binding.login.setOnClickListener { login() }

        return binding.root
    }

    private fun login() {
        if (binding.username.text.isNotEmpty() && binding.password.text.isNotEmpty()) {
            login(binding.username.text.toString(), binding.password.text.toString())
            binding.username.setText("")
            binding.password.setText("")
        }
    }

    private fun login(username: String, password: String) {
        val sqlViewModel = ViewModelProvider(this)[SqlViewModel::class.java]
        val dialog = ProgressDialog(context)
        dialog.setMessage("Please Wait...")
        sqlViewModel.login(username, password).observe(requireActivity()) {
            when (it) {
                is ControlState.Loading -> {
                    dialog.show()
                }

                is ControlState.Success -> {
                    dialog.dismiss()
                    if (it.detail.message == "Login successful") {
                        Toast.makeText(context, it.detail.message, Toast.LENGTH_SHORT).show()
                        activity?.supportFragmentManager?.beginTransaction()
                            ?.replace(R.id.container, DashboardFragment())?.commit()
                    }
                    else
                        Toast.makeText(context, it.detail.message, Toast.LENGTH_SHORT).show()
                }

                is ControlState.Error -> {
                    dialog.dismiss()
                    Toast.makeText(context, "${it.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


}