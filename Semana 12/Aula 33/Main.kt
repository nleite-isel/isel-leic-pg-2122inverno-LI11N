

//fun main() {
//
//}

fun test(i: Int) {
    println(i)
}


fun main(args: Array<String>) {
    println("Hello World!")

//    test(10)
    val array1: Array<Int> = Array(10, { index -> 0} ) // First arg = size; Second arg = lambda called for each index

    val array: IntArray = intArrayOf(10, 2, 9, 8) // List of elements in the array
    for (elem in array)
        println(elem)

    val array2 = array + 99 // Inefficient because it creates a copy

    // Manipulate main function arguments
    // Program arguments: 123, ola, a, 1, xpto, teste

    println("args.size = ${args.size}") // Args.size = 6

    val n1: Int = args[0].toInt()
    println(n1)
//    val n2: Int = args[1].toInt() // Error
//    println(n2)


    for (elem in args)
        println(elem)

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")


}






















