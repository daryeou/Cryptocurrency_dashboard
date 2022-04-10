import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdk = Versions.TARGET_ANDROID_SDK

    defaultConfig {
        applicationId = Versions.APPLICATION_ID
        minSdk = Versions.MIN_ANDROID_SDK
        targetSdk = Versions.TARGET_ANDROID_SDK
        versionCode = Versions.VERSION_CODE
        versionName = Versions.VERSION_NAME
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        setProperty("archivesBaseName", "${getDate()}_${applicationId}_${versionName}_${versionCode}")
        vectorDrawables.useSupportLibrary = true
        buildConfigField("String", "BASE_URL", BuildConfig.DEV.HOME_DOMAIN)
    }

    buildTypes {
        getByName("debug") {
            isMinifyEnabled = false // enables code shrinking and optimization
            isShrinkResources = false // Resource shrinking
            isCrunchPngs = false // Png 압축 사용
            isDebuggable = true
            buildConfigField("Boolean", "DEBUG", "true")
        }
        getByName("release") {
            println("Release Build - It will be shrinking")
            isMinifyEnabled = true // enables code shrinking and optimization
            isShrinkResources = true // Resource shrinking
            isCrunchPngs = true // Png 압축 사용
            isDebuggable = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("Boolean", "DEBUG", "false")
        }
    }

    flavorDimensions += listOf("api")

    productFlavors {
        create("minApi24") {
            dimension = "api"
            minSdk = 24
            versionCode = 20000 + (android.defaultConfig.versionCode ?: 0)
            versionNameSuffix = "-minApi24"
        }

        create("minApi21") {
            dimension = "api"
            minSdk = 21
            versionCode = 10000  + (android.defaultConfig.versionCode ?: 0)
            versionNameSuffix = "-minApi21"
        }
    }

    compileOptions {
        isCoreLibraryDesugaringEnabled = true
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    lint {
        isCheckReleaseBuilds = false
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
        isAbortOnError = false
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    variantFilter {
        ignore = name.containsAnyOfIgnoreCase(listOf("Release"))
    }
}

dependencies {
    implementation(fileTree("dir" to "libs", "include" to listOf("*.jar")))
    implementation("androidx.constraintlayout:constraintlayout:2.1.3")
    implementation("androidx.databinding:databinding-runtime:4.1.3")
    coreLibraryDesugaring(Dependencies.ANDROID_DESUGAR_JDK)
    kotlin()
    koin()
    work()
    fragment()
    retrofit()
    appCompat()
    material()
    coroutine()
    test()
}

fun getDate(): String {
    val current = LocalDateTime.now()
    val formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")
    return current.format(formatter)
}

fun String.containsAnyOfIgnoreCase(keywords: List<String>): Boolean {
    for (keyword in keywords) {
        if (this.contains(keyword, true)) return true
    }
    return false
}