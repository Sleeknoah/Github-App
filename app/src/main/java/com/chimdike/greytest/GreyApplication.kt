package com.chimdike.greytest

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GreyApplication: Application(){

    override fun onCreate() {
        super.onCreate()
    }
}