import com.android.build.gradle.internal.cxx.configure.gradleLocalProperties

plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.jetbrainsKotlinAndroid.get().pluginId)
    alias(libs.plugins.kotlinSerialization)
    id(libs.plugins.daggerHilt.get().pluginId)
    id(libs.plugins.kotlinKapt.get().pluginId)
}

android {
    namespace = "com.vgaidarji.github.api"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        val githubApiToken: String = gradleLocalProperties(rootDir, providers).getProperty("GITHUB_API_TOKEN") ?: "\"\""
        buildConfigField("String", "GITHUB_API_TOKEN", githubApiToken)
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":model"))

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)

    implementation(libs.kotlinx.serialization)
    implementation(libs.retrofit)
    implementation(libs.retrofit.converter)
    implementation(libs.okhttp)
    implementation(libs.coroutines.core)
}
