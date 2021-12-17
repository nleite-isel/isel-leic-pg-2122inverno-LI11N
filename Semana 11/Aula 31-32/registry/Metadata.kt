package registry


data class Metadata(val week: String, val datePeriod: String, val taskNames: List<String>, val total: String)

// Extension functions
fun Metadata.println() {
//    println() // Error: recursive call (calls itself)
//    this.println() // Error: recursive call (calls itself)
    kotlin.io.print("${this.week}\t${this.datePeriod}\t")
    printTasksNames(this.taskNames)
    kotlin.io.print("${this.total}")
    kotlin.io.println()
}

fun printTasksNames(taskNames: List<String>) {
    taskNames.forEach { print("$it\t") }
}

fun main() {
    val metadata = Metadata("Numero semana", "Periodo",
        listOf("Aulas ISEL", "Algebra", "PG", "Electr"), "Total Horas")
    metadata.println()
}
