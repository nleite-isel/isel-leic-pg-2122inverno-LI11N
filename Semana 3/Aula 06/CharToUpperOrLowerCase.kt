



fun main() {
	println("Introduza uma linha de texto, donde vai ser extraido um caracter:")
	val line: String = readLine()!!
	println("Inserted line: $line")
	val char: Char = line[0] // Extracts the first char
	// Note: Logic AND is represented by &&
	if (char >= 'A' && char <= 'Z') { // if char is in 'A'..'Z'
		// It is an uppercase letter
		//val charLower: Char = char + 32 // <=> char.plus(32)
		// Or:
		//val charLower: Char = char + ' ' // Error, char.plus(Char) does not exist
		//val charLower: Char = char + ' '.toInt() // toInt() is deprecated
		// Or:
		//val charLower: Char = char + ' '.code // SPACE code == ' '.code == 32
		val charLower: Char = char + ('a' - 'A')
		println("$char convertido para minuscula e' $charLower")		
	}
	else if (char >= 'a' && char <= 'z') { 
		// It is an lowercase letter
		//val charUpper: Char = char - 32 
		//val charUpper: Char = char - ('a' - 'A')
		// Or:
		val offset = char - 'a'
		val charUpper: Char = 'A' + offset
		println("$char convertido para maiuscula e' $charUpper")		
	}
	else 
		println("Nao e' letra")
		
		
	
	

}













