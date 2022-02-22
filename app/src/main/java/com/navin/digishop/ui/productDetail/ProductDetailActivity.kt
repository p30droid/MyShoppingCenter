package com.navin.digishop.ui.productDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.viewpager.widget.ViewPager
import com.navin.digishop.R
import com.navin.digishop.databinding.ActivityProductDetailBinding
import com.navin.digishop.models.Gallery
import com.navin.digishop.models.Product

class ProductDetailActivity : AppCompatActivity() {


     var bundle : Bundle? = null

    lateinit var product : Product


    lateinit var binding : ActivityProductDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this ,R.layout.activity_product_detail )

        bundle = intent.extras

        if(bundle!=null) {

            product = bundle!!.getParcelable<Product>("data")!!
            Log.e("","");
           // bundle.getParcelable<ParcelObjectName>("key")
        }

        binding.product = product

        binding.executePendingBindings()



    }


    companion object {


        @JvmStatic
        @BindingAdapter("loadGallery")
        fun showGallery(pager : ViewPager , galleryList : List<Gallery>) {

            pager.adapter =  ProductsGalleryAdapter(pager.context , galleryList)

        }


    }

}