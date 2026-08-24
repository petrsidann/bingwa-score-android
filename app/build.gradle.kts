plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
    id("kotlin-parcelize")
}

android {
    namespace = "com.bingwascore.app"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.bingwascore.app"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        // Build config fields
        buildConfigField("String", "API_BASE_URL", "\"https://api.bingwascore.com/\"")
        buildConfigField("String", "APP_VERSION", "\"1.0.0\"")
        
        // Vector drawables
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
            buildConfigField("String", "API_BASE_URL", "\"https://api.bingwascore.com/\"")
        }
        debug {
            isMinifyEnabled = false
            buildConfigField("String", "API_BASE_URL", "\"http://10.0.2.2:5000/\"")
            applicationIdSuffix = ".debug"
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    
    kotlinOptions {
        jvmTarget = "17"
        freeCompilerArgs += listOf(
            "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
            "-opt-in=androidx.compose.animation.ExperimentalAnimationApi",
            "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
        )
    }
    
    buildFeatures {
        compose = true
        buildConfig = true
    }
    
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core Android
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation(libs.androidx.lifecycle.runtime.compose)
    
    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.material.icons.extended)
    implementation(libs.androidx.navigation.compose)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    
    // Hilt Dependency Injection
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    implementation(libs.hilt.navigation.compose)
    
    // Room Database
    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)
    
    // DataStore (Preferences)
    implementation(libs.datastore.preferences)
    
    // Network - OkHttp + Retrofit
    implementation(libs.retrofit)
    implementation(libs.retrofit.moshi)
    implementation(libs.okhttp)
    implementation(libs.okhttp.logging)
    implementation(libs.moshi)
    ksp(libs.moshi.codegen)
    
    // Coroutines
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.coroutines.core)
    
    // Work Manager (Background tasks)
    implementation("androidx.work:work-runtime-ktx:2.9.0")
    
    // Startup
    implementation("androidx.startup:startup-runtime:1.1.1")
    
    // Lottie Animations
    implementation(libs.lottie.compose)
    
    // Coil (Image Loading)
    implementation(libs.coil.compose)
    
    // Accompanist (Compose utilities)
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.34.0")
    implementation("com.google.accompanist:accompanist-permissions:0.34.0")
    
    // Timber (Logging)
    implementation("com.jakewharton.timber:timber:5.0.1")
    
    // Gson (JSON)
    implementation("com.google.code.gson:gson:2.11.0")
    
    // Encrypted SharedPreferences
    implementation("androidx.security:security-crypto:1.1.0-alpha06")
    
    // Biometric Auth
    implementation("androidx.biometric:biometric:1.1.0")
    
    // Testing
    testImplementation("junit:junit:4.13.2")
    testImplementation("org.mockito:mockito-core:5.11.0")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.8.1")
    testImplementation("com.google.truth:truth:1.4.2")
    
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
}
