package cracking.the.coding

object C0101 extends App {
	val unique = "abcdef"
	val nonUnique = "aabcdef"
	val nonUniquer2 = "abca"
	
	def isUnique(str: String): Boolean = {
		var uniqueStr = ""
	
		def exists(char: Char): Boolean = {
			var exists = false
			for (i <- 0 until uniqueStr.size) {
				if (char == uniqueStr(i)) exists = true
			}
			exists
		}
	
		for (i <- 0 until str.size) {
			if (!exists(str(i))) {
				uniqueStr += str(i)
			}
		}
	
		uniqueStr.size == str.size
	}
	
	def isUnique2(str: String): Boolean = {
		def isUniqueInternal(head: Char, tail: String, unique: Boolean): Boolean = {
			if (tail.size == 0) true
			else if (head == tail(0)) false
			else isUniqueInternal(tail.head, str, unique) || isUniqueInternal(head, tail.tail, unique)
		}
		
		isUniqueInternal(str.head, str.tail, false)
	}
	
	def isUnique3(str: String): Boolean = {
		var unique = true
	
		for (i <- 0 until str.size) {
			for (j <- i+1 until str.size) {
				if (str(i) == str(j)) unique = false
			}
		}
		
		unique
	}
	

	println(isUnique(unique))
	println(isUnique(nonUnique))
	println(isUnique(nonUniquer2))
	println(isUnique2(unique))
	println(isUnique2(nonUnique))
	println(isUnique2(nonUniquer2))
	println(isUnique3(unique))
	println(isUnique3(nonUnique))
	println(isUnique3(nonUniquer2))
}