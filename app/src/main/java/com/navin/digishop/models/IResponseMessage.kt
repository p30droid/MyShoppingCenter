package com.navin.digishop.models

interface IResponseMessage<T> {


    fun onSuccess(responseMessage: String);

    fun onError(errorResponseMessage: String);//error data

    fun onFailure(errorResponseMessage: String); // error internet

}