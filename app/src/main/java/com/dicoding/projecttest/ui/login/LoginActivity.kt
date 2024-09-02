package com.dicoding.projecttest.ui.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.dicoding.projecttest.databinding.ActivityLoginBinding
import com.dicoding.projecttest.session.DataModel
import com.dicoding.projecttest.ui.ViewModelFactory
import com.dicoding.projecttest.ui.main.MainActivity
import com.dicoding.projecttest.ui.profile.ProfileActivity
import kotlinx.coroutines.launch

class LoginActivity : AppCompatActivity() {
    private val viewModel by viewModels<LoginViewModel> {
        ViewModelFactory.getInstance(application)
    }

    private lateinit var binding : ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.LoginBtn.setOnClickListener {
            var username = binding.usernameEt.text.toString()
            var password = binding.passwordEt.text.toString()
            viewModel.login(username, password)
                viewModel.loginResponse?.observe(this){
                    when{
                        (it?.meta?.code == 200) -> {
                            save(
                                DataModel(
                                    it.data?.accessToken.toString(),
                                    it.data?.dataUser?.id.toString()
                                )
                            )
                            Toast.makeText(this,it?.meta?.message, Toast.LENGTH_SHORT).show()
                        }
                        (it?.meta?.code != 200) ->{
                            Toast.makeText(this, it?.meta?.message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
        }
    }
    private fun save(session: DataModel) {
        lifecycleScope.launch {
            viewModel.saveSession(session)
            startActivity(Intent(this@LoginActivity, ProfileActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            })
            ViewModelFactory.clearInstance()
        }
    }
}