package com.navin.digishop.ui.productDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.navin.digishop.R
import com.navin.digishop.models.Product

class ProductDetailActivity : AppCompatActivity() {


     var bundle : Bundle? = null

    lateinit var product : Product

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)


        bundle = intent.extras

        if(bundle!=null) {

            product = bundle!!.getParcelable<Product>("data")!!
            Log.e("","");
           // bundle.getParcelable<ParcelObjectName>("key")
        }


    }
}