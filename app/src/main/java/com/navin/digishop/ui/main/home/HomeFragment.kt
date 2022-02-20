package com.navin.digishop.ui.main.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.navin.digishop.R
import com.navin.digishop.databinding.FragmentHomeBinding
import com.navin.digishop.models.BaseModel
import com.navin.digishop.ui.main.adapter.NewsAdapter
import com.navin.digishop.ui.main.category.CategoryViewModel
import retrofit2.Call


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    lateinit var owner: LifecycleOwner


    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentHomeBinding.inflate(layoutInflater)
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        viewModel.getHome().observe(owner , object : Observer<BaseModel> {
            override fun onChanged(t: BaseModel?) {

                Log.e("","");

                if (t != null) {
                    binding.newsPager.adapter = NewsAdapter(activity!!.applicationContext , t.news)

                    binding.recyclerMobiles.adapter = ProductAdapter(t.mobile)
                    binding.recyclerMobiles.layoutManager = LinearLayoutManager(activity ,
                    LinearLayoutManager.HORIZONTAL , false)

                    binding.recyclerBeauty.adapter = ProductAdapter(t.makeup)
                    binding.recyclerBeauty.layoutManager = LinearLayoutManager(activity ,
                        LinearLayoutManager.HORIZONTAL , false)

                    binding.recyclerAmazingOffer.adapter = ProductAdapter(t.AmazingOffer)
                    binding.recyclerAmazingOffer.layoutManager = LinearLayoutManager(activity ,
                        LinearLayoutManager.HORIZONTAL , false)



                }

            }

        })


        return binding.root
    }


}