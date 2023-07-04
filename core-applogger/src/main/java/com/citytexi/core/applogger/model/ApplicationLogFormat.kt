package com.citytexi.core.applogger.model

sealed class ApplicationLogFormat(
    val name: String
) {
    object Entry : ApplicationLogFormat(name = "entry")
    object InitData : ApplicationLogFormat(name = "init-data")
    object InitJsonData : ApplicationLogFormat(name = "init-json-data")
    object UserData : ApplicationLogFormat(name = "user-data")
    object Network : ApplicationLogFormat(name = "network")
    object AppUpdate : ApplicationLogFormat(name = "app-update")
    object Service : ApplicationLogFormat(name = "service")
    object Etc : ApplicationLogFormat(name = "etc")
}
