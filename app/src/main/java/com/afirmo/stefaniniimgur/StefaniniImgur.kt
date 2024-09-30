package com.afirmo.stefaniniimgur

import android.app.Application
import coil.Coil
import coil.ImageLoader
import coil.util.CoilUtils
import okhttp3.OkHttpClient

class StefaniniImgur : Application() {
    override fun onCreate() {
        super.onCreate()
        setupCoil()

    }

    private fun setupCoil() {
        val imageLoader = ImageLoader.Builder(applicationContext)
            .crossfade(true)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .okHttpClient {
                OkHttpClient.Builder()
                      .build()
            }
            .build()
        Coil.setImageLoader(imageLoader)
    }
}