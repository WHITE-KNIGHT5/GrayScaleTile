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
