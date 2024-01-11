package com.myproject.kotlinapp.mysqlData

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.myproject.kotlinapp.R
import com.myproject.kotlinapp.databinding.FragmentDashboardBinding
import com.myproject.kotlinapp.mysqlData.sqlViewmodel.SqlViewModel

class DashboardFragment : Fragment() {

    private lateinit var binding: FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false)
        getData()
        return binding.root
    }

    private fun getData() {
        val sqlViewModel = ViewModelProvider(this)[SqlViewModel::class.java]
        sqlViewModel.getAllUserData().observe(requireActivity()) {
            when (it) {
                is GetDataUi.Loading -> {
                    Toast.makeText(context, "Loading...", Toast.LENGTH_SHORT).show()
                }

                is GetDataUi.Success -> {
                    val arrayAdapter = ArrayAdapter(
                        requireContext(),
                        android.R.layout.simple_list_item_1,
                        it.allDataModel.data
                    )
                    binding.list.adapter = arrayAdapter
                }

                is GetDataUi.Error -> {
                    Toast.makeText(context, "${it.exception}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun logout(){
        
    }

}