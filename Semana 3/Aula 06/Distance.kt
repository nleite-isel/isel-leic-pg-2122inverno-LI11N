import kotlin.math.*  // Allows to use *everything* of package kotlin.math  (located in kotlin/math folder)
// Or, use only pow function
//import kotlin.math.pow


fun main() {
	print("x1? ")
	val x1: Double = readLine()!!.toDouble()
	
	print("y1? ")
	val y1: Double = readLine()!!.toDouble()
	
	print("x2? ")
	val x2: Double = readLine()!!.toDouble()
	
	print("y2? ")
	val y2: Double = readLine()!!.toDouble()
	
	val sqrDx: Double = (x2 - x1).pow(2)  // (x2 - x1) powered to 2
	val sqrDy: Double = (y2 - y1).pow(2)  
	val distance: Double = sqrt(sqrDx + sqrDy)
	
	println("distance: $distance")
}
