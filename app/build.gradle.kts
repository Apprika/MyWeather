import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.com.android.application)
    alias(libs.plugins.org.jetbrains.kotlin.kapt)
    alias(libs.plugins.org.jetbrains.kotlin.android)
    alias(libs.plugins.com.google.hilt.android)
    alias(libs.plugins.compose.compiler)
}

val keystorePropertiesFile = rootProject.file("keystore.properties")
val keystoreProperties = Properties()
keystoreProperties.load(FileInputStream(keystorePropertiesFile))

android {

    compileSdk = 35

    namespace = "co.za.kudzi.myweather"

    dataBinding {
        enable = true
    }

    kapt {
        correctErrorTypes = true
    }

    signingConfigs {
        create("release") {
            storeFile = file(keystoreProperties["storeFile"] as String)
            storePassword = keystoreProperties["storePassword"] as String
            keyPassword = keystoreProperties["keyPassword"] as String
            keyAlias = keystoreProperties["keyAlias"] as String
        }
    }

    defaultConfig {
        applicationId = "co.za.kudzi.myweather"
        minSdk = 27
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        buildConfigField(type = "String", name = "API_KEY", value = keystoreProperties.getProperty("openWeatherApiKey") ?: "")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            signingConfig = signingConfigs.getByName("release")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.15"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    // Hilt
    implementation(libs.com.google.dagger.hilt.android)
    kapt(libs.com.google.dagger.hilt.compiler)

    // [Compose]
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    implementation(libs.com.squareup.retrofit)
    implementation(libs.com.github.bumptech.glide)
    implementation(libs.com.squareup.retrofit.gson)
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.org.jetbrains.kotlinx.coroutines.android)
    implementation(libs.androidx.lifecycle.livedata.ktx)
    implementation(libs.androidx.activity.activity.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    implementation(libs.play.services.location)
    debugImplementation(libs.flipper)
    debugImplementation(libs.soloader)
    releaseImplementation(libs.flipper.noop)
    debugImplementation(libs.flipper.network.plugin)
    implementation(libs.logging.interceptor)
    implementation(libs.androidx.constraintlayout.compose)
    implementation(libs.kotlinx.datetime)
    implementation(libs.accompanist.permissions)
}