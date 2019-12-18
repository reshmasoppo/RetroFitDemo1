package com.example.retrofitdemo

import com.example.retrofitdemo.Model.Android
import com.example.retrofitdemo.Model.Destination
import com.example.retrofitdemo.Model.Ordercontent
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface RequestInterface {

    @GET("employees")
    fun getData() : Observable<List<Ordercontent>>

    @GET("list_contact")
    fun registerUser(@Query("userid")userId:String, @Query("password")password:String,@Query("confirmPassword")confirmPassword:String) : Observable<List<Destination>>
}