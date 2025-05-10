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
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.register<JavaExec>("run") {
    mainClass.set("KotlinClassKt")  // This should be the entry point for your Kotlin code
    classpath = sourceSets["main"].runtimeClasspath
}
