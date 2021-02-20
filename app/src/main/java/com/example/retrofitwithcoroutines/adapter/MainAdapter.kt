package com.example.retrofitwithcoroutines.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitwithcoroutines.databinding.RecyclerItemBinding
import com.example.retrofitwithcoroutines.models.MainResponse
import com.example.retrofitwithcoroutines.models.MainResponseItem


/**
 * Ahmed Ali Ebaid
 * ahmedali26002844@gmail.com
 * 20/02/2021
 */
class MainAdapter : RecyclerView.Adapter<MainAdapter.MainViewHolder>() {
    private var listData: MainResponse? = null

    fun setList(listResponse: MainResponse) {
        this.listData = listResponse
        notifyDataSetChanged()
    }

    class MainViewHolder(val binding: RecyclerItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemData: MainResponseItem) {
            with(binding) {
                tvTitle.text = itemData.title
                tvBody.text = itemData.body
                Log.d("BABA", "mainViewHolder: ${itemData.title}")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        return MainViewHolder(
            RecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        if (listData != null) {
            holder.bind(listData!![position])
            Log.d("BABA", "mainViewHolder: ${listData!![0].title}")
        }

    }

    override fun getItemCount(): Int {
        if (listData != null) {
            return listData!!.size
        } else
            return 0
    }
}