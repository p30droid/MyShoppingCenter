package com.navin.digishop.ui.main.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.navin.digishop.api.ApiConfig
import com.navin.digishop.api.ApiConfig.retrofit
import com.navin.digishop.api.IService
import com.navin.digishop.models.BaseModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel(application : Application) : AndroidViewModel(application) {


    lateinit  var baseModelData: MutableLiveData<BaseModel>


    fun getHome(): MutableLiveData<BaseModel> {
       // if (baseModelData == null) {
            baseModelData = MutableLiveData()
            getBaseModel()
            //boro webservice ro ejra kon
     //   }
        return baseModelData
    }


    fun getBaseModel() {
        val iService = retrofit.create(IService::class.java)
        iService.getHome().enqueue(object : Callback<BaseModel?> {
            override fun onResponse(call: Call<BaseModel?>, response: Response<BaseModel?>) {
                baseModelData.value = response.body()
            }

            override fun onFailure(call: Call<BaseModel?>, t: Throwable) {
                baseModelData.value = null
            }
        })
    }


}