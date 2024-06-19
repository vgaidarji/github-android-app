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
    // fix for: Unable to find method ''java.lang.String com.squareup.javapoet.ClassName.canonicalName()''
    // see https://github.com/google/dagger/issues/3068#issuecomment-999118496
    implementation(libs.square.javapoet)
}
