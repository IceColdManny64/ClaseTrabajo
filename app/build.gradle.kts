

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
}

android {

    namespace = "com.example.clasetrabajo"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.clasetrabajo"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }



    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }



}

dependencies {

    dependencies {
        // Compose y Material
        implementation(libs.androidx.material)
        implementation(libs.androidx.material.icons.extended)
        implementation(libs.material3)
        implementation(libs.androidx.material3.window.size.class1)
        implementation(libs.androidx.foundation)
        implementation(libs.androidx.foundation.layout)
        implementation(libs.androidx.foundation.layout.android)
        implementation(libs.androidx.runtime)
        implementation(libs.androidx.core.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx)
        implementation(libs.androidx.lifecycle.runtime.ktx.v262)
        implementation(libs.androidx.activity.compose)
        implementation(platform(libs.androidx.compose.bom))
        implementation(libs.androidx.ui)
        implementation(libs.androidx.ui.graphics)
        implementation(libs.androidx.ui.tooling.preview)
        implementation(libs.androidx.navigation.compose)
        implementation(libs.androidx.navigation.runtime.ktx)
        implementation(libs.androidx.navigation.runtime.android)
        implementation(libs.androidx.adaptive.android)

        // Room
        val room_version = "2.6.1"
        implementation("androidx.room:room-runtime:$room_version")
        implementation("androidx.room:room-ktx:$room_version")
        ksp("androidx.room:room-compiler:$room_version")

        implementation ("androidx.biometric:biometric:1.2.0-alpha05")

        // Coil (para imágenes)
        implementation(libs.coil.compose)

        // Retrofit + OkHttp + Serialización
        implementation(libs.retrofit2.kotlinx.serialization.converter)
        implementation(libs.retrofit)
        implementation(libs.okhttp)
        implementation(libs.kotlinx.serialization.json)
        implementation(libs.converter.gson)

        //Camera
        val cameraxVersion = "1.3.1"
        implementation("androidx.camera:camera-core:$cameraxVersion")//base
        implementation("androidx.camera:camera-camera2:$cameraxVersion")// Conexión con la API Camera2
        implementation("androidx.camera:camera-lifecycle:$cameraxVersion")
        implementation("androidx.camera:camera-view:$cameraxVersion") // Necesario para la prewiew
        implementation("androidx.navigation:navigation-compose:2.7.7")
        implementation ("com.google.accompanist:accompanist-permissions:0.34.0")
        implementation("androidx.camera:camera-video:$cameraxVersion")
        implementation ("io.coil-kt:coil-compose:2.2.2")

        // Tests
        testImplementation(libs.junit)
        androidTestImplementation(libs.androidx.junit)
        androidTestImplementation(libs.androidx.espresso.core)
        androidTestImplementation(platform(libs.androidx.compose.bom))
        androidTestImplementation(libs.androidx.ui.test.junit4)

        // Debug
        debugImplementation(libs.androidx.ui.tooling)
        debugImplementation(libs.androidx.ui.test.manifest)
    }

}
ksp {
    arg("room.schemaLocation", "$projectDir/schemas")
}