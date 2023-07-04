package com.citytexi.testapplogging

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.citytexi.core.applogger.logs.AppLogger
import com.citytexi.core.applogger.model.ApplicationLogFormat
import com.citytexi.core.applogger.model.ApplicationLogKey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AppLogger.e(
            exception = NullPointerException(),
            format = ApplicationLogFormat.InitData,
            message = listOf(
                Pair(ApplicationLogKey.Error.EXCEPTION, NullPointerException().toString())
            )
        )
    }
}