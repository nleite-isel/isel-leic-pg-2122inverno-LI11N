package li11n

// Not too efficient
//fun String.isPalindrome() =
//    this.reversed() == this

//fun String.isPalindrome(): Boolean{
//    var i = 0;
//    var j = this.length - 1
//    // Or:
//    // var j = this.lastIndex
//    var isPalindrome = true
//    while (i < j && isPalindrome) {
//        if (this[i] != this[j])
//            isPalindrome = false
//        ++i
//        --j
//    }
//    return isPalindrome
//}

//fun String.isPalindrome(): Boolean{
//    var i = 0;
//    var j = this.length - 1
//    var isPalindrome = true
//    while (i < j) {
//        if (this[i] != this[j]) {
//            isPalindrome = false
//            break
//        }
//        ++i
//        --j
//    }
//    return isPalindrome
//}

fun String.isPalindrome(): Boolean{
    var i = 0;
    var j = this.length - 1
    while (i < j) {
        if (this[i] != this[j]) {
            return false
        }
        ++i
        --j
    }
    return true
}

fun String.myReversed(): String {
    var reversed = ""
    for (i in this.length-1 downTo 0) {
        reversed += this[i]
    }
    return reversed
}

fun String.myReversed1(): String {
    var reversed = this.fold("") { acc: String, c: Char -> String
        c + acc
    }
    // acc = "", c = 'r' -> acc "r"
    // acc = "r", c = 'a' -> acc "ar"
    // acc = "ar", c = 'd' -> acc "dar"
    // acc = "dar", c = 'a' -> acc "adar"
    return reversed
}

fun main() {
    val string = "rada"
    val string1 = "ana"
    val string2 = "xpto"

    println("$string is palindrome? ${string.isPalindrome()}")
    println("$string1 is palindrome? ${string1.isPalindrome()}")
    println("$string2 is palindrome? ${string2.isPalindrome()}")

    println(string.myReversed()) // "adar"
    println(string.myReversed1()) // "adar"



}















