package com.dicoding.projecttest.ui.invoice

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.dicoding.projecttest.R
import com.dicoding.projecttest.databinding.ActivityListInvoiceBinding
import com.dicoding.projecttest.ui.ViewModelFactory

class ListInvoiceActivity : AppCompatActivity() {
    private lateinit var binding: ActivityListInvoiceBinding
    private val viewModel by viewModels<InvoiceViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListInvoiceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username = intent.getStringExtra("username")
        viewModel.getAllInvoice(username.toString())
        viewModel.invoiceResponse?.observe(this){
            Log.e("cek4", it?.meta?.message.toString())
        }
        viewModel.customerResponse?.observe(this){
            Log.e("cek5","cek")
        }
    }
}