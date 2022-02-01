package com.navin.digishop.models

interface ILoginView<String> {

    fun showProgressBar();

    fun hideProgressBar();

    fun onSuccess(responseMessage: String);

    fun onError(errorResponseMessage: String);//error data

    fun onFailure(errorResponseMessage: String); // error internet

}