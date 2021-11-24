package registry


data class Registry(val metadata: Metadata, val entries: List<Entry>)

// Extension functions

// Calculate weeks' totals (per each line) and overall totals (last line)
fun Registry.calculate(): Registry {
    TODO("Not yet implemented")
}

fun Registry.updateTaskTime(line: Int, col: Int, time: Time): Registry =
    this.copy(entries = this.entries.mapIndexed { index: Int, entry: Entry ->
        if (index == line)
            entry.copy(taskTimes = replaceTime(entry.taskTimes, col, time))
        else
            entry
    })

// Return a new List with Time at column "col" replaced with "time"
fun replaceTime(taskTimes: List<Time>, col: Int, time: Time): List<Time> {
    TODO("Not yet implemented")
}

// Print registry
fun Registry.println() {
    this.metadata.println()
    println(entries.size)
    printEntries(this.entries)

}

fun printEntries(entries: List<Entry>) {
//    entries.forEach { println("$it") } // Calls Entry.toString()
    entries.forEach { it.println() }

}

private fun Entry.println() {
    println("Entry")
}





















