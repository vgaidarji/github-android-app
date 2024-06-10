plugins {
    id(libs.plugins.androidLibrary.get().pluginId)
    id(libs.plugins.jetbrainsKotlinAndroid.get().pluginId)
    id(libs.plugins.kotlinKapt.get().pluginId)
    alias(libs.plugins.kotlinSerialization)
    alias(libs.plugins.daggerHilt)
}

android {
    namespace = "com.vgaidarji.github.api"
    compileSdk = 34

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

kapt {
    correctErrorTypes = true
}