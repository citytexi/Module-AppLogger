package com.citytexi.testapplogging

import android.app.Application
import com.citytexi.core.applogger.logs.AppLogger

class TestApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppLogger.initialize(applicationContext)
    }

}