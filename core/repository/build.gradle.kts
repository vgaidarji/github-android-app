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

    defaultConfig {
        minSdk = 24
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
    api(project(":core:api"))

    implementation(libs.dagger.hilt)
    kapt(libs.dagger.hilt.compiler)
}
