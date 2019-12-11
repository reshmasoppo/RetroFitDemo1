package com.example.retrofitdemo

import com.example.retrofitdemo.Model.Android
import com.example.retrofitdemo.Model.Destination
import io.reactivex.Observable
import retrofit2.http.GET

interface RequestInterface {

    @GET("list_contact")
    fun getData() : Observable<List<Destination>>
}