package com.zireddinismayilov.retrofit_test_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.zireddinismayilov.retrofit_test_2.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        btnOnClick(binding.loginBtn)
    }


    fun btnOnClick(btn: Button) {
        btn.setOnClickListener {
            val call: Call<List<StudentDTO?>?>? = RetrofitClient.retrofit.getlogin(binding.username.text.toString(), binding.password.text.toString())

            call?.enqueue(object : Callback<List<StudentDTO?>?> {
                override fun onResponse(call: Call<List<StudentDTO?>?>, response: Response<List<StudentDTO?>?>) {
                    startActivity(Intent(this@LoginActivity, InfoTables::class.java))
                }

                override fun onFailure(call: Call<List<StudentDTO?>?>, t: Throwable) {
                    Toast.makeText(applicationContext, "wrong password or username!", Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

}

