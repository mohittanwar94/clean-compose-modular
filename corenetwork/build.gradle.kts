plugins {
    id("com.android.library")
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.hilt)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.coreandroid"
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
    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.androidx.activity.compose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.material3)
    api(libs.androidx.ui.test.android)
    api(libs.androidx.navigation.compose)

    api(libs.retrofit)
    api(libs.converter.gson)
    api(libs.kotlinx.coroutines.android)
    api(libs.androidx.lifecycle.extensions)
    api(libs.androidx.lifecycle.viewmodel.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)
    api(libs.hilt.android)
    kapt(libs.hilt.compiler)
    api(libs.hilt.compose.navigation)
    api(libs.okhttp3.logging.interceptor)
    api(libs.androidx.constraintlayout.compose)
    api(libs.coil.compose)
}