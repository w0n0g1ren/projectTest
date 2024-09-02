package com.dicoding.projecttest.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.projecttest.data.InvoicesItem
import com.dicoding.projecttest.databinding.CustomerItemBinding

class InvoiceAdapter (private val context: Context): ListAdapter<InvoicesItem,
        InvoiceAdapter.ViewHolder>(DIFF_CALLBACK) {
    class ViewHolder(private val binding: CustomerItemBinding, private val context: Context) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: InvoicesItem){
            binding.cusName.text = item.siCode
            binding.cusPhone.text = item.siGrandTotal
        }
    }

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<InvoicesItem>() {
            override fun areItemsTheSame(oldItem: InvoicesItem,
                                         newItem: InvoicesItem
            ): Boolean {
                return oldItem == newItem
            }
            override fun areContentsTheSame(oldItem: InvoicesItem, newItem:
            InvoicesItem
            ): Boolean {
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