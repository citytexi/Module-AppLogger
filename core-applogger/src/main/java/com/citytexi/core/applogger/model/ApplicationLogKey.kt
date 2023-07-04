package com.citytexi.core.applogger.model

sealed class ApplicationLogKey {
    object Error : ApplicationLogKey() {
        const val EXCEPTION = "exception"
        const val STACKTRACE = "stacktrace"
        const val PARAMS = "params"
        const val MESSAGE = "message"
    }

    object Debug : ApplicationLogKey() {
        const val PARAMS = "params"
        const val MESSAGE = "message"
    }

    object Info : ApplicationLogKey() {
        const val PARAMS = "params"
        const val MESSAGE = "message"
    }
}
