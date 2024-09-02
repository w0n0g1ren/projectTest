package com.dicoding.projecttest.ui.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.dicoding.projecttest.R
import com.dicoding.projecttest.databinding.ActivityProfileBinding
import com.dicoding.projecttest.session.SessionPreference
import com.dicoding.projecttest.session.datastore
import com.dicoding.projecttest.ui.ViewModelFactory
import com.dicoding.projecttest.ui.costumer.CostumerActivity
import com.dicoding.projecttest.ui.invoice.InvoiceActivity
import com.dicoding.projecttest.ui.invoice.ListInvoiceActivity
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    private val viewModel by viewModels<ProfileViewModel> {
        ViewModelFactory.getInstance(this)
    }
    private var id: Int? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pref = SessionPreference.getInstance(this.datastore)
        val getId = runBlocking { pref.getToken().first() }
        id = getId.id.toInt()
        viewModel.detailUser(id.toString().toInt())
        viewModel.dataUser?.observe(this){

            binding.namaTv.text = it?.data?.dataUser?.name
            binding.emailTv.text = it?.data?.dataUser?.email.toString()
            binding.usernameTv.text = it?.data?.dataUser?.username.toString()
            Glide.with(this)
                .load(it?.data?.dataUser?.avatar)
                .into(binding.profileIv)

            binding.fabCostumer.setOnClickListener {
                val intent = Intent(this, CostumerActivity::class.java)
                intent.putExtra("username", binding.usernameTv.text.toString())
                startActivity(intent)
            }
            binding.fabInvoice.setOnClickListener {
                val intent = Intent(this, ListInvoiceActivity::class.java)
                intent.putExtra("username", binding.usernameTv.text.toString())
                startActivity(intent)
            }
        }

    }
}