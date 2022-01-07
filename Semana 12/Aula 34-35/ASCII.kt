package li11n

fun main() {
    println("Code\tCharacter")

    for (code in 32..127) {
        println("$code\t${code.toChar()}")
    }

}