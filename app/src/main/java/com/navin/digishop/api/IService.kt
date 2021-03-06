package com.navin.digishop.api

import com.navin.digishop.models.BaseModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.SingleObserver
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface IService {

    @FormUrlEncoded
    @POST("login.php")
    fun login(@Field("username") user: String,
              @Field("password") pass: String
    ):Call<ResponseBody>


    @GET("getCategories.php")
    fun getCategories() : Call<BaseModel>

    @GET("home.php")
    fun getHome() : Call<BaseModel>

    @GET("home.php")
    fun getHomeData() : Observable<BaseModel>

}