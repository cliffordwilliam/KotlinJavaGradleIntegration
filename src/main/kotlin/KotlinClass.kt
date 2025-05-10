fun getKotlinGreeting(): String {
    return "Hello from Kotlin!"
}

fun main() {
    val javaObj = JavaClass()
    println(javaObj.greet())
    println(getKotlinGreeting())
}
