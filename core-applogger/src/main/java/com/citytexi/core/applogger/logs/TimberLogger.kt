package com.citytexi.core.applogger.logs

import android.content.Context
import android.os.Build
import androidx.core.os.bundleOf
import com.citytexi.core.applogger.helper.ApplicationLoggerHelper
import com.citytexi.core.applogger.model.ApplicationLogFormat
import com.citytexi.core.applogger.model.ApplicationLogKey
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.crashlytics.ktx.crashlytics
import com.google.firebase.crashlytics.ktx.setCustomKeys
import com.google.firebase.ktx.Firebase
import timber.log.Timber
import java.util.regex.Pattern

class TimberLogger : ApplicationLoggerHelper {
    private lateinit var firebaseAnalytics: FirebaseAnalytics

    override fun initialize(context: Context) {
        kotlin.runCatching {
            Firebase.crashlytics.run {

            }
        }.onSuccess {
            firebaseAnalytics = FirebaseAnalytics.getInstance(context)
        }.onFailure { exception ->
            this.e(
                exception = exception,
                format = ApplicationLogFormat.InitData,
                message = listOf(
                    Pair(ApplicationLogKey.Error.EXCEPTION, exception.toString()),
                    Pair(ApplicationLogKey.Error.STACKTRACE, exception.stackTraceToString()),
                )
            )
        }

//        if (BuildConfig.DEBUG) {
//            Timber.plant(Timber.DebugTree())
//        }
    }

    override fun e(
        exception: Throwable,
        format: ApplicationLogFormat,
        message: List<Pair<String, String?>>,
        userTag: String?
    ) {
        val tag = setTag()

        Timber.i(format.name)
        when (this::firebaseAnalytics.isInitialized) {
            true -> Firebase.crashlytics.run {
                setUserId(userTag ?: "non-login")
                setCustomKeys {
                    key("tag", tag)
                    key("format", format.name)
                    message.forEachIndexed { index, pair ->
                        key(pair.first + index, pair.second ?: "null")
                        Timber.i("[${pair.first}, ${pair.second}]")
                        log("[${pair.first}, ${pair.second}]")
                    }
                }
                log(tag)
                recordException(exception)
            }
            false -> message.forEachIndexed { index, pair ->
                Timber.i("[${pair.first}$index, ${pair.second}]")
            }
        }
    }

    override fun d(
        format: ApplicationLogFormat,
        message: List<Pair<String, String?>>
    ) {
        setTag()
        Timber.d(format.toString())
        message.forEach { Timber.d("[${it.first}, ${it.second}]") }
    }

    override fun i(
        format: ApplicationLogFormat,
        message: List<Pair<String, String?>>,
        userTag: String?
    ) {
        val tag = setTag()

        Timber.i(format.name)
        when (this::firebaseAnalytics.isInitialized) {
            true -> {
                val bundle = bundleOf().apply {
                    putString("init_event", tag)
                    putString("format", format.name)
                    putString("userTag", userTag ?: "non-login")
                }
                message.forEachIndexed { index, pair ->
                    Timber.i("[${pair.first}$index, ${pair.second}]")
                    bundle.putString(pair.first + index, pair.second)
                }
            }
            false -> message.forEachIndexed { index, pair ->
                Timber.i("[${pair.first}$index, ${pair.second}]")
            }
        }
    }

    private fun setTag(): String {
        val ignoreClassList = listOf(
            Timber::class.java.name,
            Timber.Forest::class.java.name,
            Timber.Tree::class.java.name,
            Timber.DebugTree::class.java.name,
            TimberLogger::class.java.name,
            AppLogger::class.java.name,
        )

        val tag = Throwable().stackTrace
            .first { it.className !in ignoreClassList }
            .let(this::createStacktraceElementTag)

        Timber.tag(tag)

        return tag
    }

    private fun createStacktraceElementTag(element: StackTraceElement): String {
        var tag = element.className.substringAfterLast('.')
        val m = Pattern.compile("(\\$\\d+)+$").matcher(tag)

        if(m.find()) {
            tag = m.replaceAll("")
        }

        return if (tag.length <= 23 || Build.VERSION.SDK_INT >= 26) {
            tag
        } else {
            tag.substring(0, 23)
        }
    }
}