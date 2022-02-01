package com.navin.digishop.ui.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.navin.digishop.R
import com.navin.digishop.databinding.ActivityLoginBinding
import com.navin.digishop.models.ILoginView
import okhttp3.ResponseBody

class LoginActivity : AppCompatActivity() , ILoginView<String> {

    lateinit var binding : ActivityLoginBinding


    lateinit  var presenter : LoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)

        presenter = LoginPresenter(this)

        binding.btnLogin.setOnClickListener {
            var user = binding.edtUsername.text.toString()
            var pass = binding.edtPassword.text.toString()
            presenter.login(user , pass)
        }

        setContentView(binding.root)
    }

    override fun showProgressBar() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onSuccess(responseMessage: String) {
        Toast.makeText(applicationContext , "Success", Toast.LENGTH_LONG).show()
    }

    override fun onError(errorResponseMessage: String) {
        Toast.makeText(applicationContext , "onError", Toast.LENGTH_LONG).show()

    }

    override fun onFailure(errorResponseMessage: String) {
        Toast.makeText(applicationContext , "onFailure", Toast.LENGTH_LONG).show()
    }
}