plugins {
    kotlin("jvm") version "1.8.0"  // Set the Kotlin version you want to use
    java
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(kotlin("test"))
    
    // Retrofit and Gson dependencies
    implementation("com.squareup.retrofit2:retrofit:2.9.0") // Retrofit
    implementation("com.squareup.retrofit2:converter-gson:2.9.0") // Gson converter for Retrofit
    implementation("com.squareup.okhttp3:okhttp:4.9.2") // OkHttp for HTTP requests
    implementation("com.google.code.gson:gson:2.8.8") // Gson library
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.register<JavaExec>("run") {
    mainClass.set("KotlinClassKt")  // This should be the entry point for your Kotlin code
    classpath = sourceSets["main"].runtimeClasspath
}
