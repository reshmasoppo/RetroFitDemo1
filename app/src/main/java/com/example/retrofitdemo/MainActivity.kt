package com.example.retrofitdemo

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.retrofitdemo.Model.Android
import com.example.retrofitdemo.Model.DataAdapter
import com.example.retrofitdemo.Model.Destination
import com.example.retrofitdemo.Model.Ordercontent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedInputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    var dataList:ArrayList<Android>?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadJSON() }

    private fun loadJSON() {
        Log.e("retro","loadJSON")
        var client=ApiClient()
        client.loadUserData().
            observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse)

//        client.registerUser("reshma","123","123")
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe(this::handleRegister)
    }
    private fun handleResponse(androidList: List<Ordercontent>) {

        androidList.forEach()
        {
            Log.e("retro",it.employeeName)
        }
//        initRecyclerView(androidList)
    }
    private fun handleRegister(androidList: List<Destination>) {

        androidList.forEach()
        {
            Log.e("retro",it.email)
        }
//        initRecyclerView(androidList)
    }

     fun initRecyclerView(list:List<Android>)
        {
        rv_data!!.adapter=DataAdapter(list)
        rv_data!!.layoutManager= LinearLayoutManager(this)
       }


    private fun handleError(error: Throwable)
    {
        Log.e("retro", error.localizedMessage)

        Toast.makeText(this, "Error ${error.localizedMessage}", Toast.LENGTH_SHORT).show()
    }

    inner class dwdtask(): AsyncTask<String, String, String>() {
        override fun doInBackground(vararg params: String?): String {
            Log.e("Retro","doInBackground ")
            val url = URL("http://10.212.36.73:9091/")
            val urlConnection = url.openConnection() as HttpURLConnection
            try {
                val input = BufferedInputStream(urlConnection.getInputStream())
                Log.e("Retro","Response "+convertStreamToString(input) )
                return convertStreamToString(input)
            } finally {
                urlConnection.disconnect()
            }
            return ""
        }
        fun convertStreamToString(ins: java.io.InputStream): String {
            val s = java.util.Scanner(ins).useDelimiter("\\A")
            return if (s.hasNext()) s.next() else ""
        }
    }
}
