package com.navin.digishop.ui.main.profile

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback
import com.navin.digishop.R
import com.navin.digishop.databinding.FragmentProfileBinding
import com.navin.digishop.ui.login.LoginActivity


class ProfileFragment : Fragment() {

    lateinit var binding : FragmentProfileBinding

    private var mInterstitialAd: InterstitialAd? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.btnLogin.setOnClickListener {


            var intent = Intent(activity , LoginActivity::class.java)

            startActivity(intent)


        }


        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)

        binding.adView.adListener = object: AdListener() {
            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.e("","")
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.e("","")
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.e("","")
            }

            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.e("","")
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.e("","")
            }
        }



        var adRequest1 = AdRequest.Builder().build()

        InterstitialAd.load(activity,"ca-app-pub-3940256099942544/1033173712", adRequest1, object : InterstitialAdLoadCallback() {
            override fun onAdFailedToLoad(adError: LoadAdError) {
                Log.d("", adError?.message)
                mInterstitialAd = null
            }

            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d("", "Ad was  if (mInterstitialAd != null) {\n" +
                        "                    mInterstitialAd?.show(activity)\n" +
                        "                } else {\n" +
                        "                    Log.d(\"TAG\", \"The interstitial ad wasn't ready yet.\")\n" +
                        "                }loaded.")
                mInterstitialAd = interstitialAd

                if (mInterstitialAd != null) {
                    mInterstitialAd?.show(activity)
                } else {
                    Log.d("TAG", "The interstitial ad wasn't ready yet.")
                }

            }
        })


        return binding.root
    }


}