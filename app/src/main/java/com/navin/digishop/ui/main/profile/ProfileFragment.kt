package com.navin.digishop.ui.main.profile

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.navin.digishop.R
import com.navin.digishop.databinding.FragmentProfileBinding
import com.navin.digishop.ui.login.LoginActivity


class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener {


            var intent = Intent(activity , LoginActivity::class.java)

            startActivity(intent)


        }


        return binding.root
    }


}