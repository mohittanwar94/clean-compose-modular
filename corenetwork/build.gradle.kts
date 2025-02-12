plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.hilt)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.corenetwork"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    api(libs.retrofit)
    api(libs.converter.gson)
    api(libs.kotlinx.coroutines.android)
    api(libs.okhttp3.logging.interceptor)
    api(libs.hilt.android)
    kapt(libs.hilt.compiler)

    //testing dependencies
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

hilt {
    enableAggregatingTask = false
}