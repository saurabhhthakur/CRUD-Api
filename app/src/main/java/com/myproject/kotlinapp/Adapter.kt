package com.myproject.kotlinapp

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.myproject.kotlinapp.databinding.RowBinding
import com.myproject.kotlinapp.model.Entry

class Adapter(private val data: MutableList<Entry>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(val binding: RowBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row,
                parent,
                false
            )
        )


    override fun getItemCount() = data.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            dataTxt.text = "API: ${data[position].API}\n" +
                    "AUTH: ${data[position].Auth}\n" +
                    "Category: ${data[position].Category}\n" +
                    "Cors: ${data[position].Cors}\n" +
                    "Description: ${data[position].Description}\n" +
                    "Http: ${data[position].HTTPS}\n" +
                    "Link: ${data[position].Link}"
        }
    }


}