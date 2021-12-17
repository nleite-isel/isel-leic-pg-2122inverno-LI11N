package registry

import java.time.LocalDate


fun main() {

//    var registry = createRegistry()
    // Load registry data from file
    var registry = loadRegistryFromFile()
        // Update task time of cell (0, 1), that is, entry index = 0, task index = 1
    registry = registry?.updateTaskTime(0, 1, Time(5,5))
    // Compute total times
    registry = registry?.calculate()
//    // Print registry
    registry?.println()
}

fun loadRegistryFromFile(): Registry? {
    var line: String?
    var metadata: Metadata? = null
    var first = true
    var registry: Registry? = null
    var entries: List<Entry> = emptyList()
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
            if (first) { // Process first line which corresponds to Metadata row
                metadata = buildMetadata(tokens)
                first = false
//                registry = Registry(metadata, emptyList())
            }
            else { // Process current Entry
                val entry = buildEntry(tokens)
                // Add current entry to the list
                entries += entry
            }
        }
    }
    while (line != null)
    if (metadata != null) {
        // Last entry containing the totals
        val lastRowOfTotals = Entry(null, null, null,
            listOf(null, null, null, null), null)
        return Registry(metadata, entries + lastRowOfTotals)
    }
    else {
        println("Could not build metadata")
        return null
    }
}

fun buildEntry(tokens: List<String>): Entry =
    Entry(tokens[0].toInt(),
        LocalDate.parse(tokens[1]),
        LocalDate.parse(tokens[2]),
        buildTaskTimesList(tokens)
        )

fun buildTaskTimesList(tokens: List<String>): List<Time?> {
    var list = emptyList<Time?>()
    for (i in 3.. tokens.size-1) { // Supposing that "Total Horas" column is absent
        val components = tokens[i].split(':')
        list += Time(components[0].toInt(), components[1].toInt())
    }
    return list
}


fun buildMetadata(tokens: List<String>): Metadata =
    registry.Metadata(week = tokens[0],
        datePeriod = tokens[1],
        buildTaskNamesList(tokens),
        total = tokens.last()
    )

fun buildTaskNamesList(tokens: List<String>): List<String> {
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


