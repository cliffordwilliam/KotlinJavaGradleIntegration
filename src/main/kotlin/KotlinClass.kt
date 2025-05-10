fun getKotlinGreeting(): String {
    return "Hello from Kotlin!"
}

fun main() {
    val javaObj = JavaClass()  // Calling the Java class from Kotlin
    println(javaObj.greet())
    println(getKotlinGreeting())  // Calling the Kotlin function from Kotlin
}
