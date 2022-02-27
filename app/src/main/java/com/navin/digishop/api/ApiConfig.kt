package com.navin.digishop.api

import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object ApiConfig {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://androidsupport.ir/pack/digiAndroid/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .build()
}