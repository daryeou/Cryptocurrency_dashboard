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
    const val KOIN_ANDROID_SCOPE = "org.koin:koin-androidx-scope:${Versions.KOIN}"
    const val KOIN_ANDROID_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.KOIN}"
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
    implementation(Dependencies.KOIN_ANDROID_SCOPE)
    implementation(Dependencies.KOIN_ANDROID_VIEWMODEL)
}

fun DependencyHandler.coroutine() {
    implementation(Dependencies.KOTLIN_COROUTINES_CORE)
    implementation(Dependencies.KOTLIN_COROUTINES_ANDROID)
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

