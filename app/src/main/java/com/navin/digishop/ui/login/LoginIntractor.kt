package com.navin.digishop.ui.login

import com.navin.digishop.api.WebserviceCaller
import com.navin.digishop.models.IResponseMessage
import okhttp3.ResponseBody

class LoginIntractor {


    fun login(user : String , pass : String , listener : IResponseMessage<String>) {

        var webservice = WebserviceCaller()

        webservice.login(user , pass, object  : IResponseMessage<String> {
            override fun onSuccess(responseMessage: String) {
                listener.onSuccess(responseMessage)
            }

            override fun onError(errorResponseMessage: String) {
                listener.onError(errorResponseMessage)
            }

            override fun onFailure(errorResponseMessage: String) {
                listener.onFailure(errorResponseMessage)
            }

        })


    }


}