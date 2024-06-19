// https://medium.com/@kurtlemond/migrating-jacoco-reports-gradle-tasks-to-kotlin-dsl-7b566d89ea92

plugins {
    id("jacoco") apply false
}

dependencies {
    "implementation"("org.jacoco:org.jacoco.core:0.8.12")
}

val excludedFiles = mutableSetOf(
    "**/R.class",
    "**/R$*.class",
    "**/*\$ViewInjector*.*",
    "**/*\$ViewBinder*.*",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Factory*",
    "**/*_MembersInjector*",
    "**/*Module*",
    "**/*Component*",
    "**/*Test*.*",
    "**/*Activity*.*",
    "**/*AndroidApplication*",
    "**/*Binding*",
    "**android**",
)

tasks.register<JacocoReport>("jacocoTestReport") {
    dependsOn("testDebugUnitTest")
    group = "Reporting"
    description = "Generate Jacoco coverage reports for Debug build"

    val javaDirectories = fileTree(
        "${buildDir}/intermediates/classes/debug"
    ) { exclude(excludedFiles) }
    val kotlinDirectories = fileTree(
        "${buildDir}/tmp/kotlin-classes/debug"
    ) { exclude(excludedFiles) }

    val coverageSrcDirectories = listOf("src/main/kotlin")
    classDirectories.setFrom(files(javaDirectories, kotlinDirectories))
    additionalClassDirs.setFrom(files(coverageSrcDirectories))
    sourceDirectories.setFrom(files(coverageSrcDirectories))
    executionData.setFrom(
        files("${project.buildDir}/jacoco/testDebugUnitTest.exec")
    )

    reports {
        xml.required.set(true)
        html.required.set(true)
    }
}
