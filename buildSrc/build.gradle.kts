plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation(libs.android.tools.build.gradle)
    implementation(libs.jetbrains.kotlin.gradle.plugin)
}
