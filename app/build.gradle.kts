plugins {
    //my plugins.....
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("androidx.navigation.safeargs.kotlin")



    //emad plugins
//    id ("com.android.application")
//    id ("kotlin-android")
//    id ("kotlin-parcelize")
//    id ("kotlin-kapt")
//    //id ("androidx.navigation.safeargs.kotlin")
//    id 'com.google.dagger.hilt.android'

}


android {

    namespace = "com.af.tasks"
    compileSdk = 33

    defaultConfig {

        applicationId = "com.af.tasks"
        minSdk = 24
        targetSdk = 33
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
//        sourceCompatibility = JavaVersion.VERSION_1_8
//        targetCompatibility = JavaVersion.VERSION_1_8

        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17

    }
    kotlinOptions {
        //jvmTarget = "1.8"
        jvmTarget="17"
    }

    buildFeatures{
        dataBinding=true
        viewBinding=true
    }

}

dependencies {
    //my dependencies

    val nav_version = "2.5.3"

    //navigation component
    implementation("androidx.fragment:fragment-ktx:1.6.1")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    //view model and live data

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    //room
    implementation ("androidx.room:room-runtime:2.5.2")
    implementation ("androidx.room:room-ktx:2.5.2")
    ksp ("androidx.room:room-compiler:2.5.2")

    //coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9")




    implementation("androidx.core:core-ktx:1.8.10")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    //recycler view
    implementation("androidx.recyclerview:recyclerview:1.3.1")

    //card view
    implementation("androidx.cardview:cardview:1.0.0")




    //-------------------------------------------------
    //implementation fileTree(dir: 'libs', include: ['*.jar'])
//    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.8.0")
//    implementation ("androidx.appcompat:appcompat:1.6.1")
//    implementation ("androidx.core:core-ktx:1.10.1")
//    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
//    implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
//    testImplementation ("junit:junit:4.12")
//    androidTestImplementation ("androidx.test.ext:junit:1.1.1")
//    androidTestImplementation ("androidx.test.espresso:espresso-core:3.2.0")
//
//    // Architectural Components
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
//
//    // Room
//    implementation ("androidx.room:room-runtime:2.5.1")
//    kapt ("androidx.room:room-compiler:2.5.1")
//
//    // Kotlin Extensions and Coroutines support for Room
//    implementation ("androidx.room:room-ktx:2.5.1")
//
//    // Coroutines
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.1")
//    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4")
//
//    // Coroutine Lifecycle Scopes
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
//    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
//
//    // Retrofit
//    implementation ("com.squareup.retrofit2:retrofit:2.6.0")
//    implementation ("com.squareup.retrofit2:converter-gson:2.6.0")
//    implementation ("com.squareup.okhttp3:logging-interceptor:4.5.0")

    // Navigation Components
//    implementation ("androidx.navigation:navigation-fragment-ktx:2.5.3")
//    implementation ("androidx.navigation:navigation-ui-ktx:2.5.3")


//    // Glide
//    implementation 'com.github.bumptech.glide:glide:4.11.0'
//    kapt 'com.github.bumptech.glide:compiler:4.11.0'
//
//    // dagger hilt
//    implementation("com.google.dagger:hilt-android:2.44")
//    kapt("com.google.dagger:hilt-android-compiler:2.44")
}