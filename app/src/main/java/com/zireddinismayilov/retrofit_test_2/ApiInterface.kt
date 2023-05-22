package com.zireddinismayilov.retrofit_test_2


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiInterface {

    @GET("configStudents.php")
    fun getdata(): Call<List<StudentDTO?>?>?

    @GET("configTeachers.php")
    fun getTeachersData(): Call<List<StudentDTO?>?>?

    @POST("login.php")
    fun getlogin(@Query("username") username: String, @Query("password") password: String): Call<List<StudentDTO?>?>?
}