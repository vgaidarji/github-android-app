plugins {
    id(libs.plugins.kotlin.get().pluginId)
    alias(libs.plugins.kotlinSerialization)
}

dependencies {
    api(project(":model"))

    implementation(libs.kotlinx.serialization)
    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.coroutinesCore)
}