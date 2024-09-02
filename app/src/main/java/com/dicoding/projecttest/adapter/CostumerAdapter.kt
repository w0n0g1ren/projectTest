package com.dicoding.projecttest.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.projecttest.data.DataItem
import com.dicoding.projecttest.databinding.CustomerItemBinding

class CostumerAdapter (private val context: Context): ListAdapter<DataItem,
        CostumerAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(private val binding: CustomerItemBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: DataItem){
            binding.cusName.text = item.custName
            binding.cusPhone.text = item.custPhoneNumber
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<DataItem>() {
            override fun areItemsTheSame(oldItem: DataItem,
                                         newItem: DataItem): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: DataItem, newItem:
            DataItem): Boolean {
                return oldItem == newItem
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CustomerItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val context = context
        return ViewHolder(binding,context)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val bind = getItem(position)
        holder.bind(bind)
    }
}