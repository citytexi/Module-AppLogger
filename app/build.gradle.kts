plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.citytexi.testapplogging"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        applicationId = AppConfig.APPLICATION_ID
        minSdk = AppConfig.MIN_SDK
        targetSdk = AppConfig.TARGET_SDK
        versionCode = AppConfig.VERSION_CODE
        versionName = AppConfig.VERSION_NAME

        testInstrumentationRunner = AppConfig.TEST_INSTRUMENTATION_RUNNER
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = AppConfig.SOURCE_COMPATIBILITY
        targetCompatibility = AppConfig.TARGET_COMPATIBILITY
    }
    kotlinOptions {
        jvmTarget = AppConfig.JVM_TARGET
    }
}

dependencies {
    implementation(project(":core-applogger"))

    implementation(Dependencies.AndroidX.CORE)
    implementation(Dependencies.AndroidX.APP_COMPAT)
    implementation(Dependencies.AndroidX.CONSTRAINT_LAYOUT)

    implementation(Dependencies.Google.MATERIAL)
    testImplementation(Dependencies.Test.JUNIT)
    androidTestImplementation(Dependencies.Test.JUNIT_EXT)
    androidTestImplementation(Dependencies.Test.ESPRESSO)
}