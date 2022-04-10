import org.gradle.api.Action
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.exclude

object Dependencies {
    const val KOTLIN_STDLIB = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.KOTLIN_VERSION}"
    const val ANDROID_APP_COMPAT = "androidx.appcompat:appcompat:${Versions.AndroidX.APP_COMPAT}"
    const val ANDROID_CORE_KTX = "androidx.core:core-ktx:${Versions.AndroidX.CORE_KTX}"
    const val ANDROID_CONSTRAINT_LAYUOT = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.CONSTRAINT_LAYOUT}"
    const val JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ANDROID_JUNIT = "junit:junit:${Versions.JUNIT}"
    const val ANDROID_JUNIT_TEST = "androidx.test.ext:junit:${Versions.AndroidX.JUNIT}"
    const val KOTLIN_TEST = "org.jetbrains.kotlin:kotlin-test:${Versions.KOTLIN_VERSION}"
    const val KOTLIN_TEST_JUNIT = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.KOTLIN_VERSION}"
    const val ANDROID_ESPRESSO = "androidx.test.espresso:espresso-core:${Versions.AndroidX.ESPRESSO}"
    const val ANDROID_DESUGAR_JDK = "com.android.tools:desugar_jdk_libs:${Versions.AndroidX.DESUGAR_JDK}"
    const val ANDROID_MATERIAL = "com.google.android.material:material:${Versions.AndroidX.MATERIAL}"
    const val KOTLIN_COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.KotlinX.COROUTINES_CORE}"
    const val KOTLIN_COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.KotlinX.COROUTINES_ANDROID}"
    const val ANDROIDX_WORK_RUNTIME = "androidx.work:work-runtime-ktx:${Versions.AndroidX.WORK}"
    const val ANDROIDX_WORK_MULTIPROCESS = "androidx.work:work-multiprocess:${Versions.AndroidX.WORK}"
    const val KOIN_ANDROID = "io.insert-koin:koin-android:${Versions.KOIN}"
    const val KOIN_ANDROID_COMPAT = "io.insert-koin:koin-android-compat:${Versions.KOIN}"
    const val KOIN_ANDROIDX_WORKMANAGER = "io.insert-koin:koin-androidx-workmanager:${Versions.KOIN}"
    const val KOIN_ANDROIDX_NAVIGATION = "io.insert-koin:koin-androidx-navigation:${Versions.KOIN}"
    const val KOIN_ANDROIDX_COMPOSE = "io.insert-koin:koin-androidx-compose:${Versions.KOIN}"
    const val RETROFIT2 = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT2}"
    const val RETROFIT2_ADAPTER_RXJAVA = "com.squareup.retrofit2:adapter-rxjava2:${Versions.RETROFIT2}"
    const val RETROFIT2_CONVERTER_GSON = "com.squareup.retrofit2:converter-gson:${Versions.RETROFIT2}"
    const val RETROFIT2_CONVERTER_SCALARS = "com.squareup.retrofit2:converter-scalars:${Versions.RETROFIT2}"
    const val OKHTTP3_BOM = "com.squareup.okhttp3:okhttp-bom:4.9.3" // BOM 버전 관리
    const val OKHTTP3 = "com.squareup.okhttp3:okhttp"
    const val OKHTTP3_LOGGING_INTERCEPTOR = "com.squareup.okhttp3:logging-interceptor"
    const val FRAGMENT = "androidx.fragment:fragment:${Versions.AndroidX.FRAGMENT}"
    const val FRAGMENT_KTX = "androidx.fragment:fragment-ktx:${Versions.AndroidX.FRAGMENT}"
    const val FRAGMENT_TEST = "androidx.fragment:fragment-testing:${Versions.AndroidX.FRAGMENT}"
}

fun DependencyHandler.kotlin() {
    implementation(Dependencies.KOTLIN_STDLIB)
}

fun DependencyHandler.material() {
    implementation(Dependencies.ANDROID_MATERIAL)
}

fun DependencyHandler.appCompat() {
    implementation(Dependencies.ANDROID_APP_COMPAT)
    implementation(Dependencies.ANDROID_CORE_KTX)
    implementation(Dependencies.ANDROID_CONSTRAINT_LAYUOT)
}

fun DependencyHandler.koin() {
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.KOIN_ANDROID_COMPAT)
    implementation(Dependencies.KOIN_ANDROIDX_WORKMANAGER)
    implementation(Dependencies.KOIN_ANDROIDX_NAVIGATION)
    implementation(Dependencies.KOIN_ANDROIDX_COMPOSE)
}

fun DependencyHandler.retrofit() {
    implementation(Dependencies.OKHTTP3_BOM)
    implementation(Dependencies.OKHTTP3)
    implementation(Dependencies.OKHTTP3_LOGGING_INTERCEPTOR)
    implementation(Dependencies.RETROFIT2)
    implementation(Dependencies.RETROFIT2_ADAPTER_RXJAVA)
    implementation(Dependencies.RETROFIT2_CONVERTER_GSON)
    implementation(Dependencies.RETROFIT2_CONVERTER_SCALARS)
}

fun DependencyHandler.coroutine() {
    implementation(Dependencies.KOTLIN_COROUTINES_CORE)
    implementation(Dependencies.KOTLIN_COROUTINES_ANDROID)
}

fun DependencyHandler.work() {
    implementation(Dependencies.ANDROIDX_WORK_RUNTIME)
    implementation(Dependencies.ANDROIDX_WORK_MULTIPROCESS)
}

fun DependencyHandler.fragment() {
    implementation(Dependencies.FRAGMENT)
    implementation(Dependencies.FRAGMENT_KTX)
    debugImplementation(Dependencies.FRAGMENT_TEST)
}

fun DependencyHandler.test() {
    testImplementation(Dependencies.JUNIT)
    testImplementation(Dependencies.KOTLIN_TEST)
    testImplementation(Dependencies.KOTLIN_TEST_JUNIT)
    androidTestImplementation(Dependencies.ANDROID_JUNIT_TEST)
    androidTestImplementation(Dependencies.ANDROID_ESPRESSO)
}

private fun DependencyHandler.implementation(name: String): Dependency? {
    return add("implementation", name)
}

fun DependencyHandler.implementation(
    dependencyNotation: String,
    dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
    this, "implementation", dependencyNotation, dependencyConfiguration
)

private fun DependencyHandler.kapt(name: String) {
    add("kapt", name)
}

private fun DependencyHandler.api(name: String) {
    add("api", name)
}

private fun DependencyHandler.testImplementation(name: String) {
    add("testImplementation", name)
}

private fun DependencyHandler.androidTestImplementation(name: String) {
    add("androidTestImplementation", name)
}

private fun DependencyHandler.debugImplementation(name: String) {
    add("debugImplementation", name)
}

