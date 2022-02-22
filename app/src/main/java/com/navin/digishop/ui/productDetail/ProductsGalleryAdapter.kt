package com.navin.digishop.ui.productDetail

import android.content.Context
import com.navin.digishop.models.New
import androidx.viewpager.widget.PagerAdapter
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.navin.digishop.R
import androidx.appcompat.widget.AppCompatImageView
import com.bumptech.glide.Glide
import com.navin.digishop.models.Gallery

class ProductsGalleryAdapter(var context: Context, var galleryList: List<Gallery>) : PagerAdapter() {
    override fun getCount(): Int {
        return galleryList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.image_layout, null)
        val image: AppCompatImageView = view.findViewById(R.id.image)
        container.addView(view, 0)
        val gallery = galleryList[position]
        Glide.with(context).load(gallery.img).into(image)
        return view
    }
}