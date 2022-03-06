package com.navin.digishop

import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import com.google.android.gms.ads.MobileAds
import com.navin.digishop.databinding.ActivityMainBinding
import com.navin.digishop.di.sampleJava.DaggerUserComponent
import com.navin.digishop.di.sampleJava.User
import com.navin.digishop.di.sampleJava.UserComponent
import com.navin.digishop.di.sampleJava.UserModule
import com.navin.digishop.ui.main.adapter.TabsAdapter
import com.navin.digishop.ui.main.category.CategoryFragment
import com.navin.digishop.ui.main.home.HomeFragment
import com.navin.digishop.ui.main.profile.ProfileFragment
import com.navin.mylibrary.Utils
//import com.navin.mynewapp.DashboardActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import android.os.LocaleList




class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)




        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        MobileAds.initialize(this) {}


        //throw RuntimeException("Test Crash") // Force a crash

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


        val component : UserComponent = DaggerUserComponent.builder()
            .userModule(UserModule()).build()


        component.provideUser().userContact = "Reza"
        component.provideUser().deleteUserMail()


        Observable.just("one","two","three","four","five")
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : Observer<String>{
                override fun onSubscribe(d: Disposable) {
                    Log.e("Observable" ,"onSubscribe")
                }

                override fun onNext(t: String) {
                    Log.e("Observable" ,"onNext")
                }

                override fun onError(e: Throwable) {
                    Log.e("Observable" ,"onError")
                }

                override fun onComplete() {
                    Log.e("Observable" ,"onComplete")
                }

            })




        var util = Utils.getText("sdasd")


       // var intent = Intent(applicationContext , DashboardActivity::class.java)


    }

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ContextWrapper(newBase.setAppLocale("fa")))
    }

    fun Context.setAppLocale(language: String): Context {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val config = resources.configuration
        config.setLocale(locale)
        config.setLayoutDirection(locale)
        return createConfigurationContext(config)
    }

}