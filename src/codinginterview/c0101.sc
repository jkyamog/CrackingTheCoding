package codinginterview

object c0101 {
	val unique = "abcdef"                     //> unique  : String = abcdef
	val nonUnique = "aabcdef"                 //> nonUnique  : String = aabcdef
	val nonUniquer2 = "abca"                  //> nonUniquer2  : String = abca
	
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
	}                                         //> isUnique: (str: String)Boolean
	
	def isUnique2(str: String): Boolean = {
		def isUniqueInternal(head: Char, tail: String, unique: Boolean): Boolean = {
			if (tail.size == 0) true
			else if (head == tail(0)) false
			else isUniqueInternal(tail.head, str, unique) || isUniqueInternal(head, tail.tail, unique)
		}
		
		isUniqueInternal(str.head, str.tail, false)
	}                                         //> isUnique2: (str: String)Boolean
	
	def isUnique3(str: String): Boolean = {
		var unique = true
	
		for (i <- 0 until str.size) {
			for (j <- i+1 until str.size) {
				if (str(i) == str(j)) unique = false
			}
		}
		
		unique
	}                                         //> isUnique3: (str: String)Boolean
	

	println(isUnique(unique))                 //> true
	println(isUnique(nonUnique))              //> false
	println(isUnique(nonUniquer2))            //> false
	println(isUnique2(unique))                //> true
	println(isUnique2(nonUnique))             //> false
	println(isUnique2(nonUniquer2))           //> false
	println(isUnique3(unique))                //> true
	println(isUnique3(nonUnique))             //> false
	println(isUnique3(nonUniquer2))           //> false
}