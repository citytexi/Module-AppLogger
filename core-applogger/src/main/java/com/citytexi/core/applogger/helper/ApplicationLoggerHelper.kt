package com.citytexi.core.applogger.helper

import android.content.Context
import com.citytexi.core.applogger.model.ApplicationLogFormat

interface ApplicationLoggerHelper {

    fun initialize(context: Context)

    fun e(
        exception: Throwable,
        format: ApplicationLogFormat,
        message: List<Pair<String, String?>> = listOf(),
        userTag: String? = null
    )

    fun d(
        format: ApplicationLogFormat,
        message: List<Pair<String, String?>> = listOf(),
    )

    fun i(
        format: ApplicationLogFormat,
        message: List<Pair<String, String?>> = listOf(),
        userTag: String? = null
    )

}