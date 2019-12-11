package com.example.retrofitdemo.Model

import com.google.gson.annotations.SerializedName


data class Android(

    @SerializedName("name") val name: String = "",
    @SerializedName("version") val version: String = "",
    @SerializedName("avatar_url") val apiLevel: String = "")

