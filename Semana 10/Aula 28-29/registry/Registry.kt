package registry


data class Registry(val metadata: Metadata, val entries: List<Entry>)

// Extension functions

// Calculate weeks' totals (per each line) and overall totals (last line)
fun Registry.calculate(): Registry {
    var newEntries = this.entries
    newEntries = computeColumnSums(newEntries)
    newEntries = sumTimesByRows(newEntries)

    return this.copy(entries = newEntries)
}

fun sumTimesByRows(entries: List<Entry>): List<Entry> =
     entries.map {
        var accTime: Time? = Time(0, 0)
        accTime = it.taskTimes.fold(accTime) { acc, time ->
            acc?.add(time)
        }
        it.copy(total = accTime)
    }

fun computeColumnSums(entries: List<Entry>): List<Entry> {
    val numColumns = entries[0].taskTimes.size
    var newEntries: List<Entry> = entries
    (0..numColumns - 1).forEach { col: Int ->
        var accTime: Time? = Time(0, 0)
        // Sum cell values column wise
        newEntries = newEntries.mapIndexed { index, entry ->
            if (index < entries.size - 1) { // Process all lines except last one
                accTime = accTime?.add(entry.taskTimes[col])
                entry
            }
            else { // Last row - replace sum
                entry.copy(taskTimes = replaceTime(entry.taskTimes, col, accTime))
            }
        }
//        println(accTime?.toText())
    }
    return newEntries
}

fun Registry.updateTaskTime(line: Int, col: Int, time: Time): Registry =
    this.copy(entries = this.entries.mapIndexed { index: Int, entry: Entry ->
        if (index == line)
            entry.copy(taskTimes = replaceTime(entry.taskTimes, col, time))
        else
            entry
    })

// Return a new List with Time at column "col" replaced with "time"
fun replaceTime(taskTimes: List<Time?>, col: Int, newTime: Time?): List<Time?> =
   taskTimes.mapIndexed { index, time ->
       if (index == col)
           newTime
       else
           time
   }

// Print registry
fun Registry.println() {
    this.metadata.println()
//    println(entries.size)
    printEntries(this.entries)
}

fun printEntries(entries: List<Entry>) {
//    entries.forEach { println("$it") } // Calls Entry.toString()
    entries.forEach { it.println() }
}

private fun Entry.println() {
    print("${this.weekNumber}\t${this.from} a ${this.to}\t")
    printTasksTimes(this.taskTimes)
    print("${this.total?.toText()}")
    kotlin.io.println()
}

fun printTasksTimes(taskTimes: List<Time?>) {
    taskTimes.forEach { print("${it?.toText()}\t") }
}




















