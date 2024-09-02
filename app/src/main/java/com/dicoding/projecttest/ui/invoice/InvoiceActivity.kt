package com.dicoding.projecttest.ui.invoice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.projecttest.R
import com.dicoding.projecttest.adapter.CostumerAdapter
import com.dicoding.projecttest.adapter.InvoiceAdapter
import com.dicoding.projecttest.data.DataItem
import com.dicoding.projecttest.data.InvoicesItem
import com.dicoding.projecttest.databinding.ActivityInvoiceBinding
import com.dicoding.projecttest.ui.ViewModelFactory

class InvoiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityInvoiceBinding
    private val viewModel by viewModels<InvoiceViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username = intent.getStringExtra("username")
        viewModel.getAllInvoice(username.toString())
        viewModel.invoiceResponse?.observe(this){
            if (it != null) {
                Log.e("cek2",it?.meta?.message.toString())
            }
            else{
                Log.e("cek2",it?.meta?.message.toString())
            }
//            setCostumer(it?.data?.customers?.data)
        }
    }
    private fun setInvoice(sublist: List<InvoicesItem?>?) {
        val layoutmanager = LinearLayoutManager(this)
        binding.rvInvoice.setLayoutManager(layoutmanager)
        binding.rvInvoice.setHasFixedSize(true)
        val adapter = (this)?.let { InvoiceAdapter(it) }
        binding.rvInvoice.adapter = adapter
        adapter?.submitList(sublist)
    }
}