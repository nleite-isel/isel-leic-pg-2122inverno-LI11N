data class Pair(val first: Int, val second: Int)

fun findNumbers1(list: List<Int>): Pair {
    var i = 0
    while (i < list.size) {
        var j = i + 1
        while (j < list.size) {
            if (list[i] + list[j] == 2020)
                return Pair(list[i], list[j]) // Attention: return exits from function immediately. Do not use return with lambdas (e.g. map, fold)
            ++j
        }
        ++i
    }
    return Pair(-1, -1) // Other (preferable) option is to return null (requires Pair? in the signature)
}

fun findNumbers2(list: List<Int>, criterion: (a: Int, b: Int) -> Boolean): Pair {
    var i = 0
    while (i < list.size) {
        var j = i + 1
        while (j < list.size) {
            //if (list[i] + list[j] == 2020)
            if (criterion(list[i], list[j]))
                return Pair(list[i], list[j]) // Attention: return exits from function immediately. Do not use return with lambdas (e.g. map, fold)
            ++j
        }
        ++i
    }
    return Pair(-1, -1) // Other (preferable) option is to return null (requires Pair? in the signature)
}

fun findNumbers3(list: List<Int>, criterion: (a: Int, b: Int) -> Boolean): Pair {
    var i = 0
    var found: Boolean = false
    var resI = -1; var resJ = -1
    while (i < list.size && !found) {
        var j = i + 1
        while (j < list.size && !found) {
            if (criterion(list[i], list[j])) {
//                return Pair(list[i], list[j]) // Attention: return exits from function immediately. Do not use return with lambdas (e.g. map, fold)
                resI = i
                resJ = j
                found = true
            }
            ++j
        }
        ++i
    }
//    return Pair(-1, -1) // Other (preferable) option is to return null (requires Pair? in the signature)
    return if (resI == -1 && resJ == -1)
        Pair(-1, -1)
    else
        Pair(list[resI], list[resJ])
}


fun main() {
    val expenseReport = listOf<Int>(
        1721,
        979,
        366,
        299,
        675,
        1456
    )
//    val pair = findNumbers1(expenseReport)
    val pair = findNumbers2(expenseReport, {a: Int, b: Int -> Boolean
        a + b == 2020
    })
    if (pair.first == -1 && pair.second == -1) {
        println("No numbers found!")
        return
    }
    println("Numbers found: ${pair.first} and ${pair.second}")

    val elvesResponse = pair.first * pair.second
    println("Response = ${elvesResponse}")

}

















