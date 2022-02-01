package com.navin.digishop.api

import android.util.Log
import com.navin.digishop.models.IResponseMessage
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Response

class WebserviceCaller() {

   var iService : IService = ApiConfig.retrofit.create(IService::class.java)


    fun login(user : String , pass : String , listener : IResponseMessage<String>){

        iService.login(user, pass).enqueue(object :
            retrofit2.Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                Log.e("","")
                listener.onSuccess(response.body()!!.string())
            }

            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                Log.e("","")
                listener.onFailure("")
            }

        })


    }

}

