package com.zireddinismayilov.retrofit_test_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.zireddinismayilov.retrofit_test_2.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InfoTables : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.recyclerview1.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        getStudentsData()
        var flag = false
        binding.switchDatas.setOnClickListener {
            if (flag) {
                getTeachersData()
                flag = false
                binding.switchDatas.setText("Go to students table")
            } else {
                getStudentsData()
                flag = true
                binding.switchDatas.setText("Go to teachers table")
            }
        }
    }

    fun getStudentsData() {
        val call: Call<List<StudentDTO?>?>? = RetrofitClient.retrofit.getdata()

        call?.enqueue(object : Callback<List<StudentDTO?>?> {
            override fun onResponse(call: Call<List<StudentDTO?>?>, response: Response<List<StudentDTO?>?>) {
                val list: List<StudentDTO> = response.body() as List<StudentDTO>
                binding.recyclerview1.adapter = Adapter(list)
            }

            override fun onFailure(call: Call<List<StudentDTO?>?>, t: Throwable) {
                Toast.makeText(applicationContext, "Error has occured", Toast.LENGTH_SHORT).show()
            }

        })
    }


    fun getTeachersData() {
        val call: Call<List<StudentDTO?>?>? = RetrofitClient.retrofit.getTeachersData()

        call?.enqueue(object : Callback<List<StudentDTO?>?> {
            override fun onResponse(call: Call<List<StudentDTO?>?>, response: Response<List<StudentDTO?>?>) {
                val list: List<StudentDTO> = response.body() as List<StudentDTO>
                binding.recyclerview1.adapter = Adapter(list)
            }

            override fun onFailure(call: Call<List<StudentDTO?>?>, t: Throwable) {
                Toast.makeText(applicationContext, "Error has occured", Toast.LENGTH_SHORT).show()
            }

        })
    }

}