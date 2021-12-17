package registry

data class Time(val hour: Int, val min: Int)

// Extension functions
fun Time.add(t: Time?): Time {
//    t?.let {
//        var m = this.min + t.min
//        var h = this.hour + t.hour
//        if (m > 59) {
//            ++h
//            m %= 60
//        }
//        return Time(h, m)
//    }
//    // Else, if t == null
//    return this
// Or:
    if (t != null) {
        var m = this.min + t.min
        var h = this.hour + t.hour
        if (m > 59) {
            ++h
            m %= 60
        }
        return Time(h, m)
    }
    // Else, if t == null
    else
        return this
}
fun Time.toText(): String =
    (if (this.hour < 10) "0" + this.hour else this.hour.toString()) + ":" +
            if (this.min < 10) "0" + this.min else this.min.toString()


fun main() {
    val t1 = Time(27, 5)
    val t2 = Time(3, 59)
    val t3 = t1.add(t2) // 31:4
    println(t3) // <=> println(t3.toString()) Every data class have toString() and copy() redefined
    println(t3.toText()) // 31:04
}







