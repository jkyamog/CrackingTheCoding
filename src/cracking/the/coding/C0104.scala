package cracking.the.coding

object C0104 extends App {
	
	def isAnagram(str1: String, str2: String) = {
		if (str1 == null && str2 == null) true
		else if (str1 == null || str2 == null) false
		else if (str1.size != str2.size) false
		else {
			var isAnagram = true
		
			for (i <- 0 until str1.size) {
				if (str1(i) != str2(str2.size - i - 1)) isAnagram = false
			}
		
			isAnagram
		}
	}
	
	def isAnagram2(str1: String, str2: String) = {
		def isAnaInternal(head1: Char, tail1: String, head2: Char, tail2: String): Boolean = {
			if (head1 == head2 && tail1.tail.isEmpty && tail2.tail.isEmpty) true
			else if (head1 == head2) true && isAnaInternal(tail1.head, tail1.tail, tail2.head, tail2.tail)
			else false
		}

		(str1, str2) match {
			case (null, null) => true
			case (_, null) | (null, _) => false
			case (str1, str2) =>
				val reversed = str2.reverse
				isAnaInternal(str1.head, str1, reversed.head, reversed)
		}
	}
	
	println(isAnagram("foo", "oof"))
	println(isAnagram("fo", "off"))
	println(isAnagram("xoo", "oof"))
	println(isAnagram(null, null))
	println(isAnagram(null, "o"))
	println(isAnagram("o", null))
	println(isAnagram("o", "o"))
	println(isAnagram("f", "o"))
	
	println(isAnagram2("foo", "oof"))
	println(isAnagram2("fo", "off"))
	println(isAnagram2("xoo", "oof"))
	println(isAnagram2(null, null))
	println(isAnagram2(null, "o"))
	println(isAnagram2("o", null))
	println(isAnagram2("o", "o"))
	println(isAnagram2("f", "o"))
}