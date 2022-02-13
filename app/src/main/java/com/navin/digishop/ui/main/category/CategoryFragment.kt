package com.navin.digishop.ui.main.category

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.navin.digishop.R
import com.navin.digishop.databinding.FragmentCategoryBinding
import com.navin.digishop.models.BaseModel


class CategoryFragment : Fragment() {


    lateinit var binding  : FragmentCategoryBinding

    lateinit var viewModel : CategoryViewModel
    lateinit var owner : LifecycleOwner


    override fun onAttach(context: Context) {
        super.onAttach(context)
        owner = this
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = FragmentCategoryBinding.inflate(layoutInflater)


        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        viewModel.categories.observe(owner , object : Observer<BaseModel> {
            override fun onChanged(t: BaseModel?) {
                Log.e("","")


              binding.recyclerCategory.adapter = CategoryAdapter(t!!.categories)
              binding.recyclerCategory.layoutManager = LinearLayoutManager(activity ,
                  LinearLayoutManager.VERTICAL , false )


            }

        })



        return binding.root
    }


}