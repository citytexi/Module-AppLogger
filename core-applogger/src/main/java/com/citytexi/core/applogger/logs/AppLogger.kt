package com.citytexi.core.applogger.logs

import com.citytexi.core.applogger.helper.ApplicationLoggerHelper

object AppLogger : ApplicationLoggerHelper by TimberLogger()