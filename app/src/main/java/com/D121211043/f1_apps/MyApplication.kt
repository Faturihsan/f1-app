package com.D121211043.f1_apps

import android.app.Application
import com.D121211043.f1_apps.data.AppContainer
import com.D121211043.f1_apps.data.DefaultAppContainer

class MyApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }

}