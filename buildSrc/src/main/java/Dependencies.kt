sealed class Dependencies {

    object AndroidX : Dependencies() {
        const val CORE = "androidx.core:core-ktx:1.8.0"
        const val APP_COMPAT = "androidx.appcompat:appcompat:1.6.1"
        const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:2.1.4"
    }

    object Google : Dependencies() {
        const val MATERIAL = "com.google.android.material:material:1.5.0"
        const val FIREBASE = "com.google.firebase:firebase-bom:${DependencyVersion.FIREBASE_BOM}"
        const val FIREBASE_ANALYTICS = "com.google.firebase:firebase-analytics-ktx"
        const val FIREBASE_CRASHLYTICS = "com.google.firebase:firebase-crashlytics-ktx"
    }

    object Test : Dependencies() {
        // testImplementation
        const val JUNIT = "junit:junit:4.13.2"
        // androidTestImplementation
        const val JUNIT_EXT = "androidx.test.ext:junit:1.1.5"
        // androidTestImplementation
        const val ESPRESSO = "androidx.test.espresso:espresso-core:3.5.1"
    }

    object Timber : Dependencies() {
        const val TIMBER = "com.jakewharton.timber:timber:${DependencyVersion.TIMBER}"
    }

}
