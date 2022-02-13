package com.navin.digishop.ui.main.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.navin.digishop.R
import com.navin.digishop.databinding.CategoryRowBinding
import com.navin.digishop.models.Category

class CategoryAdapter(category : List<Category>) : RecyclerView.Adapter<CategoryVH>() {

    val categoryList = category

    lateinit var binding : CategoryRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryVH {

        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.category_row , parent , false )

        return  CategoryVH(binding)

    }

    override fun onBindViewHolder(holder: CategoryVH, position: Int) {

        var category = categoryList.get(position)

        binding.category=  category

    }

    override fun getItemCount(): Int {
        return  categoryList.size
    }



    companion object {



        @JvmStatic
        @BindingAdapter("profileImage")
        fun showImage(image : AppCompatImageView , url : String) {

            Glide.with(image.context).load(url).into(image)

        }



    }
}