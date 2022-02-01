package com.navin.digishop.ui.login

import com.navin.digishop.models.ILoginView
import com.navin.digishop.models.IResponseMessage

class LoginPresenter : IResponseMessage<String> {

    var interactor  : LoginIntractor = LoginIntractor()
   var loginView : ILoginView<String>

    constructor(view : ILoginView<String>) {
        this.loginView = view
    }


    fun login(user : String , pass : String) {

        loginView.showProgressBar()
        interactor.login(user , pass,this )

    }

    override fun onSuccess(responseMessage: String) {
        loginView.hideProgressBar()
        loginView.onSuccess("")
    }

    override fun onError(errorResponseMessage: String) {
        loginView.hideProgressBar()
        loginView.onError("")
    }

    override fun onFailure(errorResponseMessage: String) {
        loginView.hideProgressBar()
        loginView.onFailure("")
    }


}