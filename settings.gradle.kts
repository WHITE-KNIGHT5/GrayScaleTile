pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "GrayTile"
include(":app")
3. build.gradle.kts (main folder)
plugins {
    id("com.android.application") version "8.7.3" apply false
}
4. app/build.gradle.kts
plugins {
    id("com.android.application")
}
android {
    namespace = "com.gray.tile"
    compileSdk = 35
    defaultConfig {
        applicationId = "com.gray.tile"
        minSdk = 29
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
}
