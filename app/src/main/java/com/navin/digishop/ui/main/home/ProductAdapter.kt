package com.navin.digishop.ui.main.home

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.navin.digishop.R
import com.navin.digishop.databinding.CategoryRowBinding
import com.navin.digishop.databinding.ProductRowBinding
import com.navin.digishop.models.Category
import com.navin.digishop.models.Product
import com.navin.digishop.ui.productDetail.ProductDetailActivity

class ProductAdapter(product : List<Product>) : RecyclerView.Adapter<ProductVH>() {

    val productList = product

    lateinit var binding : ProductRowBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductVH {

        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),R.layout.product_row , parent , false )

        return  ProductVH(binding)

    }

    override fun onBindViewHolder(holder: ProductVH, position: Int) {

        var product = productList.get(position)

        binding.product=  product

    }

    override fun getItemCount(): Int {
        return  productList.size
    }



    companion object {



        @JvmStatic
        @BindingAdapter("profileImage")
        fun showImage(image : AppCompatImageView , url : String) {

            Glide.with(image.context).load(url).into(image)

        }

        @JvmStatic
        @BindingAdapter("percent")
        fun showPercent(text : RelativeLayout , message : String) {

            if(message.equals("0")) {
                text.visibility = ViewGroup.INVISIBLE
            }

        }

        @JvmStatic
        @BindingAdapter("percentMessage")
        fun showPercentMessage(textView : AppCompatTextView , message : String) {

            textView.text =  "%"+message

        }

        @JvmStatic
        @BindingAdapter("clickItem")
        fun click(card : CardView , product : Product){

            card.setOnClickListener {

                var intent = Intent(card.context , ProductDetailActivity::class.java)
                intent.putExtra("data" , product)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                card.context.startActivity(intent)

            }

        }



    }
}