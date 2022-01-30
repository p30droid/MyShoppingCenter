package com.navin.digishop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.navin.digishop.databinding.ActivityMainBinding
import com.navin.digishop.ui.main.adapter.TabsAdapter
import com.navin.digishop.ui.main.category.CategoryFragment
import com.navin.digishop.ui.main.home.HomeFragment
import com.navin.digishop.ui.main.profile.ProfileFragment

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bottomBar.setOnItemSelectedListener {

            when(it) {
                0 -> binding.pager.currentItem = 0
                1 -> binding.pager.currentItem = 1
                2 ->  binding.pager.currentItem = 2
            }
        }

        val fragmentList  = mutableListOf<Fragment>()
        fragmentList.add(HomeFragment())
        fragmentList.add(CategoryFragment())
        fragmentList.add(ProfileFragment())

        val adapter = TabsAdapter(this , fragmentList)

        binding.pager.adapter = adapter

    }
}