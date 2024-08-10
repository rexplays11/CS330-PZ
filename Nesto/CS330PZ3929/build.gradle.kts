// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.23" apply false
    id("com.google.dagger.hilt.android") version "2.51.1" apply false
}
buildscript {
    dependencies {
        classpath ("com.android.tools.build:gradle:8.2.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.51.1")
    }
}