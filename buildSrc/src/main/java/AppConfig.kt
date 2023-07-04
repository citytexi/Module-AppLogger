import org.gradle.api.JavaVersion

object AppConfig {
    const val APPLICATION_ID = "com.citytexi.testapplogging"
    const val COMPILE_SDK = 33
    const val MIN_SDK = 24
    const val TARGET_SDK = 33
    private const val MAJOR_VERSION_CODE = 1
    private const val MINOR_VERSION_CODE = 0
    private const val PATCH_VERSION_CODE = 0
    const val VERSION_NAME = "$MAJOR_VERSION_CODE.$MINOR_VERSION_CODE.$PATCH_VERSION_CODE"
    const val VERSION_CODE = 1
    const val TEST_INSTRUMENTATION_RUNNER = "androidx.test.runner.AndroidJUnitRunner"
    const val JVM_TARGET = "1.8"

    val SOURCE_COMPATIBILITY = JavaVersion.VERSION_1_8
    val TARGET_COMPATIBILITY = JavaVersion.VERSION_1_8
}