package com.example.retrofitdemo

import com.example.retrofitdemo.Model.Android
import com.example.retrofitdemo.Model.Destination
import com.example.retrofitdemo.Model.Ordercontent
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by him on 2/11/2018.
 */
class ApiClient {

    //base url ends with '/'
    val BASE_URL="http://dummy.restapiexample.com/api/v1/"
//    val BASE_URL="http://10.212.36.73:9091/"

    val client:RequestInterface

    init {

        val retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        client=retrofit.create<RequestInterface>(RequestInterface::class.java)

    }

    fun loadUserData():Observable<List<Ordercontent>>{

        return client.getData()

    }

    fun registerUser(userName:String,password:String,confirmPassword:String):Observable<List<Destination>>{

        return client.registerUser(userName,password,confirmPassword)

    }
}