plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.citytexi.core.applogger"
    compileSdk = AppConfig.COMPILE_SDK

    defaultConfig {
        minSdk = AppConfig.MIN_SDK

        testInstrumentationRunner = AppConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFiles("consumer-rules.pro")
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
    implementation(Dependencies.AndroidX.CORE)

    implementation(Dependencies.Timber.TIMBER)
    implementation(platform(Dependencies.Google.FIREBASE))
    implementation(Dependencies.Google.FIREBASE_ANALYTICS)
    implementation(Dependencies.Google.FIREBASE_CRASHLYTICS)
}