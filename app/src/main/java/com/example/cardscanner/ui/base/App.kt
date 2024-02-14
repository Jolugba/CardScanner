package com.example.cardscanner.ui.base

import android.app.Application
import com.facebook.stetho.Stetho
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        setUpTimber()
        Stetho.initializeWithDefaults(this)

    }

    private fun setUpTimber() {
        Timber.plant(Timber.DebugTree())
    }

}
