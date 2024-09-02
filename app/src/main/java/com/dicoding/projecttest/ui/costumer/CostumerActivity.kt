package com.dicoding.projecttest.ui.costumer

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
import com.dicoding.projecttest.data.DataItem
import com.dicoding.projecttest.databinding.ActivityCostumerBinding
import com.dicoding.projecttest.ui.ViewModelFactory
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class CostumerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCostumerBinding
    private val viewModel by viewModels<CustomerViewModel> {
        ViewModelFactory.getInstance(this)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCostumerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var username = intent.getStringExtra("username")
        viewModel.getAllCostumer(username.toString())
        viewModel.customerResponse?.observe(this){
            Log.e("cek3",it?.meta?.message.toString())
            setCostumer(it?.data?.customers?.data)
        }

    }
    private fun setCostumer(sublist: List<DataItem?>?) {
        val layoutmanager = LinearLayoutManager(this)
        binding.rvCustomer.setLayoutManager(layoutmanager)
        binding.rvCustomer.setHasFixedSize(true)
        val adapter = (this)?.let { CostumerAdapter(it) }
        binding.rvCustomer.adapter = adapter
        adapter?.submitList(sublist)
    }

}