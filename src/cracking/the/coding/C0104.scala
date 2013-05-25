package cracking.the.coding

object C0104 extends App {
	
	def isAnagram(str1: String, str2: String) = {
		if (str1 == null && str2 == null) true
		else if (str1 == null || str2 == null) false
		else if (str1.size != str2.size) false
		else {
			val b2 = str2.toBuffer
			var i = 0
			while (i < str1.size) {
				var j = 0
				while (j < b2.size) {
					if (str1(i) == b2(j)) b2.remove(j)
					j += 1
				}
				i += 1
			}
		
			if (b2.size == 0) true else false
		}
	}
	
	def isAnagram2(str1: String, str2: String) = {
		def isAnaInternal(head1: Char, tail1: String, str2: String): Boolean = {
			if (tail1.isEmpty && str2.size == 1 && str2.contains(head1.toString)) true
			else if (!tail1.isEmpty && str2.contains(head1.toString)) isAnaInternal(tail1.head, tail1.tail, str2.replaceFirst(head1.toString, ""))
			else false
		}

		(str1, str2) match {
			case (null, null) => true
			case (_, null) | (null, _) => false
			case (str1, str2) => isAnaInternal(str1.head, str1.tail, str2)
		}
	}
	
	println(isAnagram("foo", "ofo"))
	println(isAnagram("foo", "oof"))
	println(isAnagram("fo", "off"))
	println(isAnagram("xoo", "oof"))
	println(isAnagram(null, null))
	println(isAnagram(null, "o"))
	println(isAnagram("o", null))
	println(isAnagram("o", "o"))
	println(isAnagram("f", "o"))
	println("----------------")
	println(isAnagram2("foo", "ofo"))
	println(isAnagram2("foo", "oof"))
	println(isAnagram2("fo", "off"))
	println(isAnagram2("xoo", "oof"))
	println(isAnagram2(null, null))
	println(isAnagram2(null, "o"))
	println(isAnagram2("o", null))
	println(isAnagram2("o", "o"))
	println(isAnagram2("f", "o"))
}