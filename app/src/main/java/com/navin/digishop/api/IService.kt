package com.navin.digishop.api

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface IService {

    @FormUrlEncoded
    @POST("login.php")
    fun login(
        @Field("username") user: String,
        @Field("password") pass: String
    ):Call<ResponseBody>

}