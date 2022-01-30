package com.navin.digishop.ui.main.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabsAdapter(activity: FragmentActivity?, list: List<Fragment>) :
    FragmentStateAdapter(activity!!) {

    var itemsList = list

    override fun getItemCount(): Int {
        return itemsList.size
    }

    override fun createFragment(position: Int): Fragment {
       // return itemsList[position]
        return itemsList.get(position)
    }
}