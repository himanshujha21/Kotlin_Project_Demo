package com.example.adsexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.adsexample.databinding.ActivityMainBinding
import com.google.android.gms.ads.*
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    var interstitialAd: InterstitialAd? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)


        MobileAds.initialize(
            this
        ) {

            Log.d("MobileAdsInitialization", "Completed")
        }

        //InterstitialAd
        val interAdRequest = AdRequest.Builder().build()
        InterstitialAd.load(
            this,
            getString(R.string.interstitialAdUnitId),
            interAdRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdLoaded(interAd: InterstitialAd) {
                    super.onAdLoaded(interAd)
                    interstitialAd = interAd

                    interstitialAd!!.show(this@MainActivity)

                    interstitialAd!!.fullScreenContentCallback =
                        object : FullScreenContentCallback() {
                            override fun onAdShowedFullScreenContent() {
                                super.onAdShowedFullScreenContent()
                                interstitialAd = null
                            }

                        }
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    super.onAdFailedToLoad(p0)
                    Log.d("AdInfo", "Ad Failed to Load...${p0}")
                }
            })


        val adRequest = AdRequest.Builder().build()

        binding.bannerAds.loadAd(adRequest)

        binding.bannerAds.adListener = object : AdListener() {

            override fun onAdLoaded() {
                super.onAdLoaded()
                Log.d("AdInfo", "Ad Loaded!")
            }

            override fun onAdOpened() {
                super.onAdOpened()
                Log.d("AdInfo", "Ad Loaded!")
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Log.d("AdInfo", "Ad Clicked!")
            }

            override fun onAdClosed() {
                super.onAdClosed()
                Log.d("AdInfo", "Ad Closed!")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d("AdInfo", "Ad Failed to Load.....${p0}")
            }

            override fun onAdImpression() {
                super.onAdImpression()
                Log.d("AdInfo", "Ad Impression Added!")
            }
        }


    }


}