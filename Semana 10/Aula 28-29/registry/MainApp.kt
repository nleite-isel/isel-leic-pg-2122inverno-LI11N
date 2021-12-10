package registry

import java.time.LocalDate


fun main() {

//    var registry = createRegistry()
    // Load registry data from file
    var registry = loadRegistryFromFile()
        // Update task time of cell (0, 1), that is, entry index = 0, task index = 1
//    registry = registry.updateTaskTime(0, 1, Time(5,5))
//    // Compute total times
//    registry = registry.calculate()
//    // Print registry
    registry?.println()
}

fun loadRegistryFromFile(): Registry? {
    var line: String?
    var metadata: Metadata
    var first = true
    var registry: Registry? = null
    do {
        // The input is redirected to the input file: registryData.txt
        // IntelliJ / Edit configurations / redirect input from...
//        line = readlnOrNull()
        line = readLine()
        if (line != null) {
//            println(line)
            // Split line into tokens
            val tokens = line.split(',')
//            println(tokens)
            if (first) {
                metadata = buildMetadata(tokens)
                first = false
                registry = Registry(metadata, emptyList())
            }
            else {

            }
        }
    }
    while (line != null)
    return registry
}

fun buildMetadata(tokens: List<String>): Metadata =
    registry.Metadata(week = tokens[0],
        datePeriod = tokens[1],
        buildTimesList(tokens),
        total = tokens.last()
    )

fun buildTimesList(tokens: List<String>): List<String> {
    var list = emptyList<String>()
    for (i in 2 until tokens.size-1)
        // Or
//    for (i in 2..tokens.size-2)
        list += tokens[i]
    return list
}


fun createRegistry(): Registry =
    Registry(Metadata("Numero semana", "Periodo", listOf("Aulas ISEL", "Algebra", "PG", "Electr"), "Total Horas"),
             listOf(
                 Entry(1, LocalDate.of(2021, 1, 4), LocalDate.of(2021, 1, 10),
                            listOf(Time(22, 5), Time(4, 0), Time(5, 0), Time(3, 0))),  // Entry #0
                 Entry(2, LocalDate.of(2021, 1, 11), LocalDate.of(2021, 1, 17),
                     listOf(Time(22, 5), Time(3, 0), Time(5, 5), Time(3, 5))),  // Entry #1
                 // ... other entries
                // Last entry containing the totals
                 Entry(null, null, null,
                     listOf(null, null, null, null), null),  // Entry #N-1
             )
        )


