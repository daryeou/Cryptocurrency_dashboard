dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS) // 다른 Gradle에 Repository를 선언했을 경우 빌드 에러 발생
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
        maven {
            url = uri("https://jitpack.io")
        }
    }
}
rootProject.name = "Docfriends_Android_Recruit"
include(":app")
